// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.VisitOutcome;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.*;

public class VisitOutcomesService extends BaseService {
  public VisitOutcomesService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<VisitOutcome> list(Map<String, Object> params) {
    String url = "/v2/visit_outcomes";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), VisitOutcome.class);
  }

  public List<VisitOutcome> list(SearchCriteria criteria) {
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
