// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.User;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.utils.Joiner;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.checkArgument;


public class UsersService extends BaseService {
  public UsersService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<User> list(Map<String, Object> params) {
    String url = "/v2/users";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), User.class);
  }

  public List<User> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public User get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/v2/users/%d", id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), User.class);
  }


  public User self() {
    return JsonDeserializer.deserialize(this.httpClient.get("/v2/users/self", null).getBody(), User.class);
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

    public SearchCriteria confirmed(boolean confirmed) {
      queryParams.put("confirmed", confirmed);
      return this;
    }

    public SearchCriteria email(String email) {
      queryParams.put("email", email);
      return this;
    }

    public SearchCriteria name(String name) {
      queryParams.put("name", name);
      return this;
    }

    public SearchCriteria role(String role) {
      queryParams.put("role", role);
      return this;
    }

    public SearchCriteria status(String status) {
      queryParams.put("status", status);
      return this;
    }

    /**
     * WARNING!
     * This search param is a subject to change. Use only when really necessary.
     */
    public SearchCriteria zendeskUserIds(List<Long> ids) {
      queryParams.put("zendesk_user_ids", Joiner.join(",", ids));
      return this;
    }

    /**
     * WARNING!
     * This search param is a subject to change. Use only when really necessary.
     */
    public SearchCriteria zendeskUserIds(Long... ids) {
      return zendeskUserIds(asList(ids));
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

