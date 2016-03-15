// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Task;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.*;


public class TasksService extends BaseService {
  public TasksService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<Task> list(Map<String, Object> params) {
    String url = "/tasks";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), Task.class);
  }

  public List<Task> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public Task create(Task task) {
    checkNotNull(task, "task parameter must not be null");

    String url = "/tasks";
    String serialized = JsonSerializer.serialize(task, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Task.class);
  }

  public Task create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = "/tasks";
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Task.class);
  }


  public Task get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/tasks/%d", id); 
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Task.class);
  }


  public Task update(Task task) {
    checkNotNull(task, "task parameter must not be null");
    checkNotNull(task.getId(), "task must have id attribute set");
    checkArgument(task.getId() > 0, "task id must be a valid id");

    String url = String.format(Locale.US, "/tasks/%d", task.getId());
    String serialized = JsonSerializer.serialize(task, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Task.class);
  }

  public Task update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, "/tasks/%d", id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Task.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, "/tasks/%d", id); 
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

    public SearchCriteria creatorId(long creatorId) {
      queryParams.put("creator_id", creatorId);
      return this;
    }

    public SearchCriteria ownerId(long ownerId) {
      queryParams.put("owner_id", ownerId);
      return this;
    }

    public SearchCriteria resourceId(long resourceId) {
      queryParams.put("resource_id", resourceId);
      return this;
    }

    public SearchCriteria completed(boolean completed) {
      queryParams.put("completed", completed);
      return this;
    }

    public SearchCriteria overdue(boolean overdue) {
      queryParams.put("overdue", overdue);
      return this;
    }

    public SearchCriteria q(String q) {
      queryParams.put("q", q);
      return this;
    }

    public SearchCriteria remind(boolean remind) {
      queryParams.put("remind", remind);
      return this;
    }

    public SearchCriteria resourceType(String resourceType) {
      queryParams.put("resource_type", resourceType);
      return this;
    }

    public SearchCriteria type(String type) {
      queryParams.put("type", type);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

