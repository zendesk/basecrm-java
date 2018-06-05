// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.LeadUnqualifiedReason;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.utils.Joiner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.getbase.utils.Lists.asList;


public class LeadUnqualifiedReasonsService extends BaseService {
  public LeadUnqualifiedReasonsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<LeadUnqualifiedReason> list(Map<String, Object> params) {
    String url = "/v2/lead_unqualified_reasons";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), LeadUnqualifiedReason.class);
  }

  public List<LeadUnqualifiedReason> list(SearchCriteria criteria) {
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
      queryParams.put("ids", Joiner.join(",", ids));
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
