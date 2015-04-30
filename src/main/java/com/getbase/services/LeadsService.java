package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Lead;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Precondition.*;


public class LeadsService extends BaseService {
    public LeadsService(HttpClient httpClient) {
        super(httpClient);
    }

    public List<Lead> list(Map<String, Object> params) {
        return JsonDeserializer.deserializeList(this.httpClient.get("/leads", params).getBody(), Lead.class);
    }

    public List<Lead> list(SearchCriteria criteria) {
        return list(criteria.build());
    }


    public Lead get(long leadId) {
        return JsonDeserializer.deserialize(this.httpClient.get(String.format(Locale.US, "/leads/%d", leadId), null).getBody(), Lead.class);
    }

    public Lead create(Lead lead) {
        checkNotNull(lead, "lead parameter must not be null");


        String serialized = JsonSerializer.serialize(lead, Views.ReadWrite.class);
        return JsonDeserializer.deserialize(this.httpClient.post("/leads", serialized).getBody(), Lead.class);
    }

    public Lead create(Map<String, Object> attributes) {
        checkNotNull(attributes, "attributes parameter must not be null");

        String serialized = JsonSerializer.serialize(attributes);
        return JsonDeserializer.deserialize(this.httpClient.post("/leads", serialized).getBody(), Lead.class);
    }

    public Lead update(Lead lead) {
        checkNotNull(lead, "lead parameter must not be null");
        checkNotNull(lead.getId(), "lead must have id attribute set");
        checkArgument(lead.getId() > 0, "lead id must be a valid id");

        String serialized = JsonSerializer.serialize(lead, Views.ReadWrite.class);
        return JsonDeserializer.deserialize(this.httpClient.put(String.format(Locale.US, "/leads/%d", lead.getId()), serialized).getBody(), Lead.class);
    }


    public Lead update(long leadId, Map<String, Object> attributes) {
        checkNotNull(attributes, "attributes parameter must not be null");
        checkArgument(leadId > 0, "leadId must be a valid id");

        String serialized = JsonSerializer.serialize(attributes);
        return JsonDeserializer.deserialize(this.httpClient.put(String.format(Locale.US, "/leads/%d", leadId), serialized).getBody(), Lead.class);
    }

    public boolean delete(long leadId) {
       checkArgument(leadId > 0, "leadId must be a valid id");

       return this.httpClient.delete(String.format(Locale.US, "/leads/%d", leadId), null).getHttpStatus() == 204;
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

        public SearchCriteria sortBy(String criteria) {
            return sortBy(criteria, "asc");
        }

        public SearchCriteria ids(List<Integer> ids) {
            queryParams.put("ids", ids);
            return this;
        }

        public SearchCriteria ids(long... ids) {
            return ids(ids);
        }

        public SearchCriteria firstName(String firstName) {
            queryParams.put("first_name", firstName);
            return this;
        }

        public SearchCriteria lastName(String lastName) {
            queryParams.put("last_name", lastName);
            return this;
        }

        public SearchCriteria addressCity(String city) {
            queryParams.put("address[city]", city);
            return this;
        }

        public Map<String, Object> build() {
            return queryParams;
        }
    }
}
