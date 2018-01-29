package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.CallOutcome;
import com.getbase.serializer.JsonDeserializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallOutcomesService extends BaseService {

  public CallOutcomesService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<CallOutcome> list(Map<String, Object> params) {
    return JsonDeserializer.deserializeList(this.httpClient.get("/v2/call_outcomes", params).getBody(), CallOutcome.class);
  }

  public List<CallOutcome> list(SearchCriteria criteria) {
    return list(criteria.asMap());
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

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

