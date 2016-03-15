// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Tag;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Precondition.*;


public class TagsService extends BaseService {
  public TagsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<Tag> list(Map<String, Object> params) {
    String url = "/v2/tags";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), Tag.class);
  }

  public List<Tag> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public Tag create(Tag tag) {
    checkNotNull(tag, "tag parameter must not be null");

    String url = "/v2/tags";
    String serialized = JsonSerializer.serialize(tag, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Tag.class);
  }

  public Tag create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = "/v2/tags";
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Tag.class);
  }


  public Tag get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/v2/tags/%d", id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Tag.class);
  }


  public Tag update(Tag tag) {
    checkNotNull(tag, "tag parameter must not be null");
    checkNotNull(tag.getId(), "tag must have id attribute set");
    checkArgument(tag.getId() > 0, "tag id must be a valid id");

    String url = String.format(Locale.US, "/v2/tags/%d", tag.getId());
    String serialized = JsonSerializer.serialize(tag, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Tag.class);
  }

  public Tag update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, "/v2/tags/%d", id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Tag.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, "/v2/tags/%d", id);
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

    public SearchCriteria creatorId(long creatorId) {
      queryParams.put("creator_id", creatorId);
      return this;
    }

    public SearchCriteria name(String name) {
      queryParams.put("name", name);
      return this;
    }

    public SearchCriteria resourceType(String resourceType) {
      queryParams.put("resource_type", resourceType);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

