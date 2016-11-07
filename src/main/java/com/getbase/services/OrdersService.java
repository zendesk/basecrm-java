package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Order;
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

public class OrdersService extends BaseService {

    public OrdersService(HttpClient httpClient) {
        super(httpClient);
    }

    public List<Order> list(SearchCriteria criteria) {
        return list(criteria.asMap());
    }

    public List<Order> list(Map<String, Object> params) {
        String url = "/v2/orders";
        return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), Order.class);
    }

    public Order create(Order order) {
        checkNotNull(order, "order parameter must not be null");

        String url = "/v2/orders";
        String serialized = JsonSerializer.serialize(order, Views.ReadWrite.class, "order");
        return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Order.class);
    }

    public Order create(Map<String, Object> attributes) {
        checkNotNull(attributes, "attributes parameter must not be null");

        String url = "/v2/orders";
        String serialized = JsonSerializer.serialize(attributes, "order");
        return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Order.class);
    }

    public Order get(long id) {
        checkArgument(id > 0, "id must be a valid id");

        String url = String.format(Locale.US, "/v2/orders/%d", id);
        return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Order.class);
    }

    public Order update(Order order) {
        checkNotNull(order, "order parameter must not be null");
        checkNotNull(order.getId(), "order must have id attribute set");
        checkArgument(order.getId() > 0, "order id must be a valid id");

        String url = String.format(Locale.US, "/v2/orders/%d", order.getId());
        String serialized = JsonSerializer.serialize(order, Views.ReadWrite.class);
        return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Order.class);
    }

    public Order update(long id, Map<String, Object> attributes) {
        checkArgument(id > 0, "id must be a valid id");
        checkNotNull(attributes, "attributes parameter must not be null");

        String url = String.format(Locale.US, "/v2/orders/%d", id);
        String serialized = JsonSerializer.serialize(attributes);
        return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Order.class);
    }

    public boolean delete(long id) {
        checkArgument(id > 0, "id must be a valid id");

        String url = String.format(Locale.US, "/v2/orders/%d", id);
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

        public SearchCriteria dealId(long dealId) {
            queryParams.put("deal_id", dealId);
            return this;
        }

        public Map<String, Object> asMap() {
            return Collections.unmodifiableMap(queryParams);
        }
    }

}
