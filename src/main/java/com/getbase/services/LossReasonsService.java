// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.LossReason;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.*;


public class LossReasonsService extends BaseService {
  public LossReasonsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<LossReason> list(Map<String, Object> params) {
    String url = "/v2/loss_reasons";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), LossReason.class);
  }

  public List<LossReason> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public LossReason create(LossReason lossReason) {
    checkNotNull(lossReason, "lossReason parameter must not be null");

    String url = "/v2/loss_reasons";
    String serialized = JsonSerializer.serialize(lossReason, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), LossReason.class);
  }

  public LossReason create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = "/v2/loss_reasons";
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), LossReason.class);
  }


  public LossReason get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/v2/loss_reasons/%d", id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), LossReason.class);
  }


  public LossReason update(LossReason lossReason) {
    checkNotNull(lossReason, "lossReason parameter must not be null");
    checkNotNull(lossReason.getId(), "lossReason must have id attribute set");
    checkArgument(lossReason.getId() > 0, "lossReason id must be a valid id");

    String url = String.format(Locale.US, "/v2/loss_reasons/%d", lossReason.getId());
    String serialized = JsonSerializer.serialize(lossReason, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), LossReason.class);
  }

  public LossReason update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, "/v2/loss_reasons/%d", id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), LossReason.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, "/v2/loss_reasons/%d", id);
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
      queryParams.put("ids", ids);
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

