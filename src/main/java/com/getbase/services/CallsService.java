package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Call;
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


public class CallsService extends BaseService {

    private static final String URI = "/v2/calls";

    private static final String URI_WITH_ID = "/v2/calls/%d";

    public CallsService(HttpClient httpClient) {
        super(httpClient);
    }

    public List<Call> list(Map<String, Object> params) {
        return JsonDeserializer.deserializeList(this.httpClient.get(URI, params).getBody(), Call.class);
    }

    public List<Call> list(SearchCriteria criteria) {
        return list(criteria.asMap());
    }


    public Call create(Call call) {
        checkNotNull(call, "call parameter must not be null");

        String serialized = JsonSerializer.serialize(call, Views.ReadWrite.class);
        return JsonDeserializer.deserialize(this.httpClient.post(URI, serialized).getBody(), Call.class);
    }

    public Call create(Map<String, Object> attributes) {
        checkNotNull(attributes, "attributes parameter must not be null");

        String serialized = JsonSerializer.serialize(attributes);
        return JsonDeserializer.deserialize(this.httpClient.post(URI, serialized).getBody(), Call.class);
    }


    public Call get(long id) {
        checkArgument(id > 0, "id must be a valid id");

        String url = String.format(Locale.US, URI_WITH_ID, id);
        return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Call.class);
    }

    public Call update(long id, Map<String, Object> attributes) {
        checkArgument(id > 0, "id must be a valid id");
        checkNotNull(attributes, "attributes parameter must not be null");

        String url = String.format(Locale.US, URI_WITH_ID, id);
        String serialized = JsonSerializer.serialize(attributes);
        return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Call.class);
    }


    public boolean delete(long id) {
        checkArgument(id > 0, "id must be a valid id");

        String url = String.format(Locale.US, URI_WITH_ID, id);
        return this.httpClient.delete(url, null).getHttpStatus() == 204;
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

        public SearchCriteria ids(List<Long> ids) {
            queryParams.put("ids", Joiner.join(",", ids));
            return this;
        }

        public SearchCriteria ids(Long... ids) {
            return ids(asList(ids));
        }

        public SearchCriteria resourceType(String resourceType) {
            queryParams.put("resource_type", resourceType);
            return this;
        }

        public SearchCriteria resourceId(long resourceId) {
            queryParams.put("resource_id", resourceId);
            return this;
        }

        public SearchCriteria associatedDealId(long associatedDealId) {
            queryParams.put("associated_deal_id", associatedDealId);
            return this;
        }

        public Map<String, Object> asMap() {
            return Collections.unmodifiableMap(queryParams);
        }
    }

}

