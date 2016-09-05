package com.getbase.exceptions;

import com.getbase.http.HttpMethod;

import java.util.List;

public class ServerException extends BaseException {
    public ServerException(int httpStatus, String logref, HttpMethod httpMethod, String url, List<BaseError> errors) {
        super(httpStatus, logref, httpMethod, url, errors);
    }
}
