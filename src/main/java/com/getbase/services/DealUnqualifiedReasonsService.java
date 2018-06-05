// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.DealUnqualifiedReason;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;
import com.getbase.utils.Joiner;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.checkArgument;
import static com.getbase.utils.Precondition.checkNotNull;


public class DealUnqualifiedReasonsService extends BaseService {
  public DealUnqualifiedReasonsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<DealUnqualifiedReason> list(Map<String, Object> params) {
    String url = "/v2/deal_unqualified_reasons";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), DealUnqualifiedReason.class);
  }

  public List<DealUnqualifiedReason> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public DealUnqualifiedReason create(DealUnqualifiedReason dealUnqualifiedReason) {
    checkNotNull(dealUnqualifiedReason, "dealUnqualifiedReason parameter must not be null");

    String url = "/v2/deal_unqualified_reasons";
    String serialized = JsonSerializer.serialize(dealUnqualifiedReason, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), DealUnqualifiedReason.class);
  }

  public DealUnqualifiedReason create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = "/v2/deal_unqualified_reasons";
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), DealUnqualifiedReason.class);
  }


  public DealUnqualifiedReason get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/v2/deal_unqualified_reasons/%d", id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), DealUnqualifiedReason.class);
  }


  public DealUnqualifiedReason update(DealUnqualifiedReason dealUnqualifiedReason) {
    checkNotNull(dealUnqualifiedReason, "dealUnqualifiedReason parameter must not be null");
    checkNotNull(dealUnqualifiedReason.getId(), "dealUnqualifiedReason must have id attribute set");
    checkArgument(dealUnqualifiedReason.getId() > 0, "dealUnqualifiedReason id must be a valid id");

    String url = String.format(Locale.US, "/v2/deal_unqualified_reasons/%d", dealUnqualifiedReason.getId());
    String serialized = JsonSerializer.serialize(dealUnqualifiedReason, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), DealUnqualifiedReason.class);
  }

  public DealUnqualifiedReason update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, "/v2/deal_unqualified_reasons/%d", id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), DealUnqualifiedReason.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, "/v2/deal_unqualified_reasons/%d", id);
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

    public SearchCriteria sortBy(String criteria) {
      return sortBy(criteria, "asc");
    }

    public SearchCriteria ids(List<Long> ids) {
      queryParams.put("ids", Joiner.join(",", ids));
      return this;
    }

    public SearchCriteria ids(Long... ids) {
      return ids(asList(ids));
    }

    public SearchCriteria name(String name) {
      queryParams.put("name", name);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}
