package com.getbase.sync;

import com.getbase.Client;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.utils.BiPredicate;

import java.util.HashMap;
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

    public <T> Sync subscribe(Class<T> type, BiPredicate<Meta, T> predicate) {
        this.streamObservable.subscribe(type, predicate);
        return this;
    }

    public boolean fetch() {
        // there are no observers attached, fetching won't ack fetched data
        if (this.streamObservable.isEmpty()) {
            throw new IllegalStateException("you have no observers attached - use subscribe first");
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

    protected boolean fetchInternal(BiPredicate<Meta, Map<String, Object>> predicate) {
        checkNotNull(predicate, "predicate parameter must not be null");

        SyncProcess syncProcess = new SyncProcess(client, deviceUUID, predicate);
        
        return syncProcess.run();
    }

    private static class StreamObservable implements BiPredicate<Meta, Map<String, Object>> {
        private final Map<Class, BiPredicate> observers = new HashMap<Class, BiPredicate>();

        public <T> void subscribe(Class<T> type, BiPredicate<Meta, T> predicate) {
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

        @SuppressWarnings("unchecked")
        private boolean notifyPredicate(Meta meta, Map<String, Object> data) throws ClassNotFoundException {
            Class<?> clazz = meta.getType().getClassType();
            BiPredicate predicate = this.observers.get(clazz);

            // we haven't seen predicate for that type, skip ack, give it a try next time
            return predicate != null && predicate.test(meta, JsonDeserializer.deserialize(data, clazz));
        }

        public boolean isEmpty(){
            return this.observers.isEmpty();
        }

        @Override
        public boolean test(Meta meta, Map<String, Object> data) {
            return notify(meta, data);
        }
    }
}

