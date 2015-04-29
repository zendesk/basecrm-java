package com.getbase.exceptions;

public class RateLimitException extends RuntimeException {
    public RateLimitException(String message) {
        super(message);
    }

    public RateLimitException() {
    }
}
