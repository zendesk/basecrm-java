package com.getbase.exceptions;

import java.util.List;

import static com.getbase.utils.Joiner.join;

public abstract class BaseException extends RuntimeException {

    private final int httpStatus;
    private final String logref;
    private final List<BaseError> errors;

    public BaseException(int httpStatus, String logref, List<BaseError> errors) {
        super(buildMessage(httpStatus, logref, errors));
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

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getClass())
                .append('{')
                .append(buildMessage(httpStatus, logref, errors))
                .append('}')
                .toString();
    }

    private static String buildMessage(int httpStatus, String logref, List<BaseError> errors) {
        return new StringBuilder()
                .append("httpStatus=").append(httpStatus)
                .append(", logref='").append(logref)
                .append("', errors=").append(join(";", errors))
                .toString();
    }

}
