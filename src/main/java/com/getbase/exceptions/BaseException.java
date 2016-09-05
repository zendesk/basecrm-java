package com.getbase.exceptions;

import com.getbase.http.HttpMethod;

import java.util.List;

import static com.getbase.utils.Joiner.join;

public abstract class BaseException extends RuntimeException {

    private final int httpStatus;
    private final String logref;
    private final HttpMethod httpMethod;
    private final String url;
    private final List<BaseError> errors;

    public BaseException(int httpStatus, String logref, HttpMethod httpMethod, String url, List<BaseError> errors) {
        super(buildMessage(httpStatus, logref, httpMethod, url, errors));
        this.httpStatus = httpStatus;
        this.logref = logref;
        this.httpMethod = httpMethod;
        this.url = url;
        this.errors = errors;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public String getLogref() {
        return this.logref;
    }

    public String getRequestId() {
        return this.logref;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public List<BaseError> getErrors() {
        return this.errors;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getClass())
                .append('{')
                .append(buildMessage(httpStatus, logref, httpMethod, url, errors))
                .append('}')
                .toString();
    }

    private static String buildMessage(int httpStatus, String logref, HttpMethod httpMethod, String url, List<BaseError> errors) {
        return new StringBuilder()
                .append("httpStatus=").append(httpStatus)
                .append(", logref='").append(logref)
                .append("', httpMethod=").append(httpMethod)
                .append(", url=").append(url)
                .append(", errors=").append(join(";", errors))
                .toString();
    }

}
