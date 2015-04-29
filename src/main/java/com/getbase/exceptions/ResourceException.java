package com.getbase.exceptions;

import java.util.List;

public class ResourceException extends BaseException {
    public ResourceException(int httpStatus, String logref, List<BaseError> errors) {
        super(httpStatus, logref, errors);
    }
}
