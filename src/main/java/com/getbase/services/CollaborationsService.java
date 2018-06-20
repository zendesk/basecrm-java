package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Collaboration;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;
import com.getbase.utils.Joiner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.checkArgument;
import static com.getbase.utils.Precondition.checkNotNull;

public class CollaborationsService extends BaseService {

    private static final String URI = "/v2/collaborations";

    private static final String URI_WITH_ID = URI + "/%d";

    public CollaborationsService(HttpClient httpClient) {
        super(httpClient);
    }

    public List<Collaboration> list(CollaborationsService.SearchCriteria criteria) {
        return list(criteria.asMap());
    }

    public List<Collaboration> list(Map<String, Object> params) {
        return JsonDeserializer.deserializeList(this.httpClient.get(URI, params).getBody(), Collaboration.class);
    }

    public Collaboration create(Collaboration collaboration) {
        checkNotNull(collaboration, "collaboration parameter must not be null");

        String serialized = JsonSerializer.serialize(collaboration, Views.ReadWrite.class, "collaboration");
        return JsonDeserializer.deserialize(this.httpClient.post(URI, serialized).getBody(), Collaboration.class);
    }

    public Collaboration create(Map<String, Object> attributes) {
        checkNotNull(attributes, "attributes parameter must not be null");

        String serialized = JsonSerializer.serialize(attributes, "collaboration");
        return JsonDeserializer.deserialize(this.httpClient.post(URI, serialized).getBody(), Collaboration.class);
    }

    public Collaboration get(long id) {
        checkArgument(id > 0, "id must be a valid id");

        String uri = String.format(Locale.US, URI_WITH_ID, id);
        return JsonDeserializer.deserialize(this.httpClient.get(uri, null).getBody(), Collaboration.class);
    }

    public boolean delete(long id) {
        checkArgument(id > 0, "id must be a valid id");

        String uri = String.format(Locale.US, URI_WITH_ID, id);
        return this.httpClient.delete(uri, null).getHttpStatus() == 204;
    }

    public static class SearchCriteria {

        private Map<String, Object> queryParams;

        public SearchCriteria() {
            this.queryParams = new HashMap<String, Object>();
        }

        public SearchCriteria page(long page) {
            queryParams.put("page", page);
            return this;
        }

        public SearchCriteria perPage(long perPage) {
            queryParams.put("per_page", perPage);
            return this;
        }

        public SearchCriteria sortBy(String criteria, String order) {
            queryParams.put("sort_by", criteria + ":" + order);
            return this;
        }

        public SearchCriteria ids(List<Long> ids) {
            queryParams.put("ids", Joiner.join(",", ids));
            return this;
        }

        public SearchCriteria ids(Long... ids) {
            return ids(asList(ids));
        }

        public SearchCriteria creatorId(long creatorId) {
            queryParams.put("creator_id", creatorId);
            return this;
        }

        public SearchCriteria resourceType(String resourceType) {
            queryParams.put("resource_type", resourceType);
            return this;
        }

        public SearchCriteria resourceId(long resourceId) {
            queryParams.put("resource_id", resourceId);
            return this;
        }

        public Map<String, Object> asMap() {
            return Collections.unmodifiableMap(queryParams);
        }

    }

}
