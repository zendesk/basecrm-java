package com.getbase.exceptions;

import com.getbase.http.Response;

public class UnknownResponseException extends RuntimeException {
    private Response response;

    public UnknownResponseException(String message, Response response) {
        super(message);
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
