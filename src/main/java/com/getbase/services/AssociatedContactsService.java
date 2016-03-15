// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.AssociatedContact;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.*;


public class AssociatedContactsService extends BaseService {
  public AssociatedContactsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<AssociatedContact> list(long dealId, Map<String, Object> params) {
    checkArgument(dealId > 0, "dealId must be a valid id");

    String url = String.format(Locale.US, "/v2/deals/%d/associated_contacts", dealId);
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), AssociatedContact.class);
  }

  public List<AssociatedContact> list(long dealId, SearchCriteria criteria) {
    return list(dealId, criteria.asMap());
  }


  public AssociatedContact create(long dealId, AssociatedContact associatedContact) {
    checkArgument(dealId > 0, "dealId must be a valid id");
    checkNotNull(associatedContact, "associatedContact parameter must not be null");

    String url = String.format(Locale.US, "/v2/deals/%d/associated_contacts", dealId);
    String serialized = JsonSerializer.serialize(associatedContact, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), AssociatedContact.class);
  }

  public AssociatedContact create(long dealId, Map<String, Object> attributes) {
    checkArgument(dealId > 0, "dealId must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = String.format(Locale.US, "/v2/deals/%d/associated_contacts", dealId);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), AssociatedContact.class);
  }


  public boolean delete(long dealId, long contactId) {
    checkArgument(dealId > 0, "dealId must be a valid id");
    checkArgument(contactId > 0, "contactId must be a valid id");
    
    String url = String.format(Locale.US, "/v2/deals/%d/associated_contacts/%d", dealId, contactId);
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

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

