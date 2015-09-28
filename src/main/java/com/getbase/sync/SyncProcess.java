package com.getbase.sync;

import com.getbase.Client;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.utils.BiPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SyncProcess {
    private Session session;
    private BiPredicate<Meta, Map<String, Object>> predicate;
    private String deviceUUID;
    private Client client;
    private List<Map<String, Object>> nextItems;

    public SyncProcess(Client client, String deviceUUID, BiPredicate<Meta, Map<String, Object>> predicate) {
        this.client = client;
        this.deviceUUID = deviceUUID;
        this.predicate = predicate;
    }

    public boolean run() {
        if (!init()) {
            return false;
        }

        while (fetchMore()) {
            process();
        }

        return true;
    }

    private boolean init() {
        // Set up a new synchronization session for a UUID for the device
        session = this.client.sync().start(this.deviceUUID);

        // Check if there is anything to synchronize
        return session != null && session.getId() != null;
    }

    private boolean fetchMore() {
        nextItems = this.client.sync().fetch(this.deviceUUID, session.getId());

        return nextItems != null;
    }

    // Drain the main queue until there is no more data (empty array)
    private void process() {
        List<String> ackKeys = new ArrayList<String>(nextItems.size());

        // Notify about new data
        for (Map<String, Object> item : nextItems) {
            processItem(ackKeys, item);
        }

        // As we fetch new data, we need to send acknowledgement keys, if any ...
        this.client.sync().ack(this.deviceUUID, ackKeys);
    }

    @SuppressWarnings("unchecked")
    private void processItem(List<String> ackKeys, Map<String, Object> item) {
        // Extract meta data and deserialize to POJO
        Map<String, Object> metaAttributes = (Map<String, Object>) item.get("meta");
        Meta meta = JsonDeserializer.deserialize(metaAttributes, Meta.class);

        // Insanity check
        if (meta != null && meta.getSync() != null && meta.getSync().getAckKey() != null) {

            // Extract data
            Map<String, Object> data = (Map<String, Object>) item.get("data");

            // Notify observer
            if (this.predicate.test(meta, data)) {
                // Add to acknowledged objects
                ackKeys.add(meta.getSync().getAckKey());
            }
        }
    }
}
