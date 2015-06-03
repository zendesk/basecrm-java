package com.getbase.sync;

import com.getbase.Client;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.utils.BiPredicate;
import com.getbase.utils.Predicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.getbase.utils.Precondition.*;

public class Sync {
    protected final Client client;
    protected final String deviceUUID;
    protected final StreamObservable streamObservable;

    public Sync(Client client, String deviceUUID) {
        this.client = client;
        this.deviceUUID = deviceUUID;
        this.streamObservable = new StreamObservable();
    }

    public <T> Sync subscribe(Class<T> type, Predicate<T> predicate) {
        this.streamObservable.subscribe(type, predicate);
        return this;
    }

    public boolean fetch() {
        // there are no observers attached, fetching won't ack fetched data
        if (this.streamObservable.isEmpty()) {
            throw new IllegalStateException("you have got observers attached - use fetch method without input arguments");
        }

        return fetchInternal(this.streamObservable);
    }

    public boolean fetch(BiPredicate<Meta, Map<String, Object>> predicate) {
        // validate if a user intentionally used this method
        if (!this.streamObservable.isEmpty()) {
            throw new IllegalStateException("you have got observers attached - use fetch method without input arguments");
        }

        return fetchInternal(predicate);
    }

    @SuppressWarnings("unchecked")
    protected boolean fetchInternal(BiPredicate<Meta, Map<String, Object>> predicate) {
        checkNotNull(predicate, "predicate parameter must not be null");

        // Set up a new synchronization session for a UUID for the device
        Session session = this.client.sync().start(this.deviceUUID);

        // Check if there is anything to synchronize
        if (session == null || session.getId() == null) {
            return false;
        }

        // Drain the main queue until there is no more data (empty array)
        while (true) {
            // Fetch from the main queue
            List<Map<String, Object>> items = this.client.sync().fetch(this.deviceUUID, session.getId());

            // Nothing more to synchronize ?
            if (items == null || items.isEmpty()) {
                break;
            }

            List<String> ackKeys = new ArrayList<String>();

            // Notify about new data
            for (Map<String, Object> item : items) {

                // Extract meta data and deserialize to POJO
                Map<String, Object> metaAttributes = (Map<String, Object>)item.get("meta");
                Meta meta = JsonDeserializer.deserialize(metaAttributes, Meta.class);

                // Insanity check
                if (meta == null || meta.getSync() == null || meta.getSync().getAckKey() == null) {
                    continue;
                }

                // Extract data
                Map<String, Object> data = (Map<String, Object>)item.get("data");

                // Notify observer
                if (predicate.apply(meta, data)) {
                    // Add to acknowledged objects
                    ackKeys.add(meta.getSync().getAckKey());
                }
            }

            // As we fetch new data, we need to send acknowledgement keys, if any ...
            this.client.sync().ack(this.deviceUUID, ackKeys);
        }

        return true;
    }

    private static class StreamObservable implements BiPredicate<Meta, Map<String, Object>> {
        private final Map<Class, Predicate> observers = new HashMap<Class, Predicate>();

        public <T> void subscribe(Class<T> type, Predicate<T> predicate) {
            this.observers.put(type, predicate);
        }

        public boolean notify(Meta meta, Map<String, Object> data) {
            // if the data represents a type we don't support, don't ack. We might get a new library version
            // with support for the new type, and handle the data later on.
            if (!meta.getType().isSupported()) {
                return false;
            }

            try {
                return notifyPredicate(meta, data);
            } catch (ClassNotFoundException e) {
                return false;
            }
        }

        private boolean notifyPredicate(Meta meta, Map<String, Object> data) throws ClassNotFoundException {
            Class<?> clazz = meta.getType().getClassType();
            Predicate predicate = this.observers.get(clazz);

            // we haven't seen predicate for that type, skip ack, give it a try next time
            return predicate != null && predicate.test(JsonDeserializer.deserialize(data, clazz));
        }

        public boolean isEmpty(){
            return this.observers.isEmpty();
        }

        @Override
        public boolean apply(Meta meta, Map<String, Object> data) {
            return notify(meta, data);
        }
    }
}

