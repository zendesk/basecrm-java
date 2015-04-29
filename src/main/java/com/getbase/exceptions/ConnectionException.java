package com.getbase.exceptions;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
