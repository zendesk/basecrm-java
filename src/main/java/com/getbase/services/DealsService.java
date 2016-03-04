// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Deal;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Precondition.*;


public class DealsService extends BaseService {

  private static final String DEALS_URL = "/v2/deals";
  private static final String DEAL_URL = "/v2/deals/%d";

  public DealsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<Deal> list(Map<String, Object> params) {
    return JsonDeserializer.deserializeList(this.httpClient.get(DEALS_URL, params).getBody(), Deal.class);
  }

  public List<Deal> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public Deal create(Deal deal) {
    checkNotNull(deal, "deal parameter must not be null");

    String serialized = JsonSerializer.serialize(deal, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(DEALS_URL, serialized).getBody(), Deal.class);
  }

  public Deal create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");

    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(DEALS_URL, serialized).getBody(), Deal.class);
  }


  public Deal get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, DEAL_URL, id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Deal.class);
  }


  public Deal update(Deal deal) {
    checkNotNull(deal, "deal parameter must not be null");
    checkNotNull(deal.getId(), "deal must have id attribute set");
    checkArgument(deal.getId() > 0, "deal id must be a valid id");

    String url = String.format(Locale.US, DEAL_URL, deal.getId());
    String serialized = JsonSerializer.serialize(deal, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Deal.class);
  }

  public Deal update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, DEAL_URL, id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Deal.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, DEAL_URL, id);
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

    public SearchCriteria ids(List<Integer> ids) {
      queryParams.put("ids", ids);
      return this;
    }

    public SearchCriteria ids(long... ids) {
      return ids(ids);
    }

    public SearchCriteria contactId(long contactId) {
      queryParams.put("contact_id", contactId);
      return this;
    }

    public SearchCriteria creatorId(long creatorId) {
      queryParams.put("creator_id", creatorId);
      return this;
    }

    public SearchCriteria organizationId(long organizationId) {
      queryParams.put("organization_id", organizationId);
      return this;
    }

    public SearchCriteria ownerId(long ownerId) {
      queryParams.put("owner_id", ownerId);
      return this;
    }

    public SearchCriteria sourceId(long sourceId) {
      queryParams.put("source_id", sourceId);
      return this;
    }

    public SearchCriteria stageId(long stageId) {
      queryParams.put("stage_id", stageId);
      return this;
    }

    public SearchCriteria hot(boolean hot) {
      queryParams.put("hot", hot);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

