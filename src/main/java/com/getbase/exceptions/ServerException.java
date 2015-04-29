package com.getbase.exceptions;

import java.util.List;

public class ServerException extends BaseException {
    public ServerException(int httpStatus, String logref, List<BaseError> errors) {
        super(httpStatus, logref, errors);
    }
}
