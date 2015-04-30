package com.getbase.services;

import com.getbase.http.HttpClient;

public abstract class BaseService {
    protected final HttpClient httpClient;

    public BaseService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
