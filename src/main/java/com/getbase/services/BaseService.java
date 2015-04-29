package com.getbase.services;

import com.getbase.http.HttpClient;

public abstract class BaseService {
    protected final HttpClient httpClient;

    public BaseService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    protected <T> T checkNotNull(T reference, String message) {
        if (reference == null) {
            throw new NullPointerException(message);
        }
        return reference;
    }

    protected void checkArgument(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }
}
