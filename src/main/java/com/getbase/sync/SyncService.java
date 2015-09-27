package com.getbase.sync;

import com.getbase.http.HttpClient;
import com.getbase.http.HttpMethod;
import com.getbase.http.Response;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.services.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.getbase.utils.Precondition.checkArgument;
import static com.getbase.utils.Precondition.checkNotNull;
import static javax.ws.rs.core.Response.Status.ACCEPTED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

public class SyncService extends BaseService {
    private static final Logger log = LoggerFactory.getLogger(SyncService.class);

    public static final String DEVICE_HEADER = "X-Basecrm-Device-UUID";

    public SyncService(HttpClient httpClient) {
        super(httpClient);
    }

    public Session start(String deviceUUID) {
        checkNotNull(deviceUUID, "deviceUUID parameter must not be null");
        checkArgument(!deviceUUID.trim().isEmpty(), "deviceUUID must not be empty");

        String url = "/sync/start";
        Response response = this.httpClient.request(HttpMethod.POST,
                url,
                null,
                buildHeaders(deviceUUID),
                null);

        if (noConent(response)) {
            log.info("Received 204 from sync start. Nothing to fetch.");
            return null;
        }

        final Session session = SessionDeserializer.deserialize(JsonDeserializer.deserializeRaw(response.getBody()));

        if (session != null) {
            log.info("Started sync process with pending queues: {}", session.getQueues());
        } else {
            log.warn("Sync process will not be started due to missing session data: {}", response);
        }

        return session;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> fetch(String deviceUUID, String sessionId) {
        checkNotNull(deviceUUID, "deviceUUID parameter must not be null");
        checkArgument(!deviceUUID.trim().isEmpty(), "deviceUUID must not be empty");
        checkNotNull(sessionId, "sessionId parameter must not be null");
        checkArgument(!sessionId.trim().isEmpty(), "sessionId must not be empty");

        String url = String.format(Locale.US, "/sync/%s/queues/main", sessionId);
        Response response = this.httpClient.request(HttpMethod.GET,
                url,
                null,
                buildHeaders(deviceUUID),
                null);

        // nothing new to synchronize
        if (noConent(response)) {
            log.info("Received 204 from sync queue. Completing sync process.");
            return null;
        }

        Map<String, Object> attributes = JsonDeserializer.deserializeRaw(response.getBody());

        // sanity check
        if (attributes == null || attributes.get("items") == null) {
            log.warn("Empty sync response or response does not contain items field. Response : {}", response);
            return null;
        }

        logSyncProgress(attributes);

        final List<Map<String, Object>> items = (List<Map<String, Object>>) attributes.get("items");
        if (items.isEmpty()) {
            log.warn("Empty items collection received in sync with HTTP status {}", response.getHttpStatus());
        }
        return items;
    }

    private boolean noConent(Response response) {
        return response.getHttpStatus() == NO_CONTENT.getStatusCode();
    }

    @SuppressWarnings("unchecked")
    private void logSyncProgress(Map<String, Object> attributes) {
        if (log.isDebugEnabled()) {
            final Map<String, Object> meta = (Map<String, Object>) attributes.get("meta");
            if (meta != null) {
                log.debug("Received {} items out of {} remaining.", meta.get("count"), meta.get("count_left"));
            }
        }
    }

    public boolean ack(String deviceUUID, List<String> ackKeys) {
        checkNotNull(deviceUUID, "deviceUUID parameter must not be null");
        checkNotNull(ackKeys, "ackKeys parameter must not be null");
        checkArgument(!deviceUUID.trim().isEmpty(), "deviceUUID must not be empty");

        if (ackKeys.isEmpty()) return true;

        String url = "/sync/ack";

        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("ack_keys", ackKeys);
        String serialized = JsonSerializer.serialize(attributes);

        Response response = this.httpClient.request(HttpMethod.POST,
                url,
                null,
                buildHeaders(deviceUUID),
                serialized);

        boolean acked = response.getHttpStatus() == ACCEPTED.getStatusCode();

        if (!acked) {
            log.warn("Ack request was not accepted for {}. Http status: {}. Response body: {}", ackKeys,
                    response.getHttpStatus(), response.getBody());
        } else {
            log.debug("{} items acknowledged.", ackKeys.size());
        }

        return acked;
    }

    private Map<String, String> buildHeaders(String deviceUUID) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(DEVICE_HEADER, deviceUUID);
        return headers;
    }

    public static final class SessionDeserializer {

        @SuppressWarnings("unchecked")
        public static Session deserialize(Map<String, Object> root) {
            if (root == null || root.get("data") == null) {
                return null;
            }

            Map<String, Object> attributes = (Map<String, Object>)root.get("data");
            String sessionId = (String)attributes.get("id");

            List<Queue> queues = new ArrayList<Queue>();

            for (Map<String, Object> item : (List<Map<String, Object>>)attributes.get("queues")) {
                queues.add(QueueDeserializer.deserialize(item));
            }

            return new Session(sessionId, queues);
        }
    }


    public static final class QueueDeserializer {

        @SuppressWarnings("unchecked")
        public static Queue deserialize(Map<String, Object> root) {
            if (root == null || root.get("data") == null) {
                return null;
            }

            Map<String, Object> attributes = (Map<String, Object>)root.get("data");
            String name = (String)attributes.get("name");
            Integer pages = (Integer)attributes.get("pages");
            Integer totalCount = (Integer)attributes.get("total_count");

            return new Queue(name, pages.longValue(), totalCount.longValue());
        }
    }
}
