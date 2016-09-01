package com.getbase.exceptions;

import com.getbase.http.HttpMethod;

import java.util.List;

public class ResourceException extends BaseException {
    public ResourceException(int httpStatus, String logref, HttpMethod httpMethod, String url, List<BaseError> errors) {
        super(httpStatus, logref, httpMethod, url, errors);
    }
}
