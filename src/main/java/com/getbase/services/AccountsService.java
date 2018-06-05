// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Account;
import com.getbase.serializer.JsonDeserializer;


public class AccountsService extends BaseService {
  public AccountsService(HttpClient httpClient) {
    super(httpClient);
  }

  public Account self() {
    return JsonDeserializer.deserialize(this.httpClient.get("/v2/accounts/self", null).getBody(), Account.class);
  }


}

