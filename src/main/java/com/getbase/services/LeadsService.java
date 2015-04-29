package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Lead;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LeadsService extends BaseService {
    public LeadsService(HttpClient httpClient) {
        super(httpClient);
    }

    public List<Lead> all(Map<String, Object> params) {
        return JsonDeserializer.deserializeList(this.httpClient.get("/leads", params).getBody(), Lead.class);
    }

    public List<Lead> all(QueryParamBuilder builder) {
        return all(builder.build());
    }

    public Lead get(long leadId) {
        return JsonDeserializer.deserialize(this.httpClient.get(String.format("/leads/%d", leadId), null).getBody(), Lead.class);
    }

    public Lead create(Lead lead) {
        if (lead == null) {
            throw new IllegalArgumentException("lead parameter must not be null");
        }

        String serialized = JsonSerializer.serialize(lead, Views.ReadWrite.class);
        return JsonDeserializer.deserialize(this.httpClient.post("/leads", serialized).getBody(), Lead.class);
    }

    public Lead create(Map<String, Object> attributes) {
        if (attributes == null) {
            throw new IllegalArgumentException("attributes parameter must not be null");
        }

        String serialized = JsonSerializer.serialize(attributes);
        return JsonDeserializer.deserialize(this.httpClient.post("/leads", serialized).getBody(), Lead.class);
    }

    public Lead update(Lead lead) {
        if (lead == null) {
            throw new IllegalArgumentException("lead parameter must not be null");
        }

        if (lead.getId() == 0) {
            throw new IllegalArgumentException("lead must have id attribute set");
        }

        String serialized = JsonSerializer.serialize(lead, Views.ReadWrite.class);
        return JsonDeserializer.deserialize(this.httpClient.put(String.format("/leads/%d", lead.getId()), serialized).getBody(), Lead.class);
    }


    public Lead update(long leadId, Map<String, Object> attributes) {
        if (attributes == null) {
            throw new IllegalArgumentException("attributes parameter must not be null");
        }

        if (leadId == 0) {
            throw new IllegalArgumentException("leadId must not not be 0");
        }

        String serialized = JsonSerializer.serialize(attributes);
        return JsonDeserializer.deserialize(this.httpClient.put(String.format("/leads/%d", leadId), serialized).getBody(), Lead.class);
    }

    public boolean delete(long leadId) {
       return this.httpClient.delete(String.format("/leads/%d", leadId), null).getHttpStatus() == 204;
    }

    public static class QueryParamBuilder {
        private Map<String, Object> queryParams;

        public QueryParamBuilder() {
            this.queryParams = new HashMap<>();
        }

        public QueryParamBuilder page(long page) {
            queryParams.put("page", page);
            return this;
        }

        public QueryParamBuilder perPage(long perPage) {
            queryParams.put("per_page", perPage);
            return this;
        }

        public QueryParamBuilder sortBy(String criteria, String order) {
            queryParams.put("sort_by", criteria + ":" + order);
            return this;
        }

        public QueryParamBuilder sortBy(String criteria) {
            return sortBy(criteria, "asc");
        }

        public QueryParamBuilder ids(List<Integer> ids) {
            queryParams.put("ids", ids);
            return this;
        }

        public QueryParamBuilder ids(long... ids) {
            return ids(ids);
        }

        public QueryParamBuilder firstName(String firstName) {
            queryParams.put("first_name", firstName);
            return this;
        }

        public QueryParamBuilder lastName(String lastName) {
            queryParams.put("last_name", lastName);
            return this;
        }

        public QueryParamBuilder addressCity(String city) {
            queryParams.put("address[city]", city);
            return this;
        }

        public Map<String, Object> build() {
            return queryParams;
        }
    }
}
