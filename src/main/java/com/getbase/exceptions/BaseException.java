package com.getbase.exceptions;

import java.util.List;

public abstract class BaseException extends RuntimeException {

    private final int httpStatus;
    private final String logref;

    @Override
    public String toString() {
        return "BaseException{" +
                "httpStatus=" + httpStatus +
                ", logref='" + logref + '\'' +
                ", errors=" + errors +
                '}';
    }

    private final List<BaseError> errors;

    public BaseException(int httpStatus, String logref, List<BaseError> errors) {
        this.httpStatus = httpStatus;
        this.logref = logref;
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

    public List<BaseError> getErrors() {
        return this.errors;
    }

}
