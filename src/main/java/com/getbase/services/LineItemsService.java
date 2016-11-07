package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.LineItem;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;
import com.getbase.utils.Joiner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.checkArgument;
import static com.getbase.utils.Precondition.checkNotNull;

public class LineItemsService extends BaseService {

    public LineItemsService(HttpClient httpClient) {
        super(httpClient);
    }

    public List<LineItem> list(long orderId, SearchCriteria criteria) {
        return list(orderId, criteria.asMap());
    }

    public List<LineItem> list(long orderId, Map<String, Object> params) {
        String url = String.format(Locale.US, "/v2/orders/%d/line_items", orderId);
        return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), LineItem.class);
    }

    public LineItem create(long orderId, LineItem lineItem) {
        checkArgument(orderId > 0, "orderId must be a valid id");
        checkNotNull(lineItem, "lineItem parameter must not be null");

        String url = String.format(Locale.US, "/v2/orders/%d/line_items", orderId);
        String serialized = JsonSerializer.serialize(lineItem, Views.ReadWrite.class, "line_item");
        return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), LineItem.class);
    }

    public LineItem create(long orderId, Map<String, Object> attributes) {
        checkArgument(orderId > 0, "orderId must be a valid id");
        checkNotNull(attributes, "attributes parameter must not be null");

        String url = String.format("/v2/orders/%d/line_items", orderId);
        String serialized = JsonSerializer.serialize(attributes, "line_item");
        return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), LineItem.class);
    }

    public LineItem get(long orderId, long id) {
        checkArgument(orderId > 0, "orderId must be a valid id");
        checkArgument(id > 0, "id must be a valid id");

        String url = String.format(Locale.US, "/v2/orders/%d/line_items/%d", orderId, id);
        return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), LineItem.class);
    }

    public boolean delete(long orderId, long id) {
        checkArgument(orderId > 0, "orderId must be a valid id");
        checkArgument(id > 0, "id must be a valid id");

        String url = String.format(Locale.US, "/v2/orders/%d/line_items/%d", orderId, id);
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

        public SearchCriteria quantity(long quantity) {
            queryParams.put("quantity", quantity);
            return this;
        }

        public SearchCriteria value(BigDecimal value) {
            queryParams.put("value", value);
            return this;
        }

        public Map<String, Object> asMap() {
            return Collections.unmodifiableMap(queryParams);
        }
    }

}
