package com.getbase.exceptions;

import java.util.List;

public class RequestException extends BaseException {
    public RequestException(int httpStatus, String logref, List<BaseError> errors) {
        super(httpStatus, logref, errors);
    }
}
