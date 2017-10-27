// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Lead;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;
import com.getbase.utils.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.*;


public class LeadsService extends BaseService {
  private static final Logger log = LoggerFactory.getLogger(LeadsService.class);
  public LeadsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<Lead> list(Map<String, Object> params) {
    String url = "/v2/leads";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), Lead.class);
  }

  public List<Lead> list(SearchCriteria criteria) {
    List<Lead> tbr = list(criteria.asMap());
    log.info("LeadsService.list={}", tbr);
    return tbr;
  }


  public Lead create(Lead lead) {
    checkNotNull(lead, "lead parameter must not be null");

    String url = "/v2/leads";
    String serialized = JsonSerializer.serialize(lead, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Lead.class);
  }

  public Lead create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = "/v2/leads";
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Lead.class);
  }


  public Lead get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/v2/leads/%d", id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Lead.class);
  }


  public Lead update(Lead lead) {
    checkNotNull(lead, "lead parameter must not be null");
    checkNotNull(lead.getId(), "lead must have id attribute set");
    checkArgument(lead.getId() > 0, "lead id must be a valid id");

    String url = String.format(Locale.US, "/v2/leads/%d", lead.getId());
    String serialized = JsonSerializer.serialize(lead, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Lead.class);
  }

  public Lead update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, "/v2/leads/%d", id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Lead.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, "/v2/leads/%d", id);
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
      log.info("find ids by:{}", Joiner.join(",", ids));
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

    public SearchCriteria ownerId(long ownerId) {
      queryParams.put("owner_id", ownerId);
      return this;
    }

    public SearchCriteria addressCity(String addressCity) {
      queryParams.put("address[city]", addressCity);
      return this;
    }

    public SearchCriteria addressCountry(String addressCountry) {
      queryParams.put("address[country]", addressCountry);
      return this;
    }

    public SearchCriteria addressPostalCode(String addressPostalCode) {
      queryParams.put("address[postal_code]", addressPostalCode);
      return this;
    }

    public SearchCriteria firstName(String firstName) {
      queryParams.put("first_name", firstName);
      return this;
    }

    public SearchCriteria lastName(String lastName) {
      queryParams.put("last_name", lastName);
      return this;
    }

    public SearchCriteria organizationName(String organizationName) {
      queryParams.put("organization_name", organizationName);
      return this;
    }

    public SearchCriteria status(String status) {
      queryParams.put("status", status);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

