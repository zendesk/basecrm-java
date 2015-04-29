package com.getbase.http;

import java.util.Map;

public class Response {

    private int httpStatus;
    private String body;
    private Map<String, String> headers;

    public Response(int httpStatus, String body, Map<String, String> headers) {
        this.httpStatus = httpStatus;
        this.body = body;
        this.headers = headers;
    }

    public Response(int httpStatus, String body) {
        this.httpStatus = httpStatus;
        this.body = body;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public boolean isJSON() {
        return this.body != null &&
                this.headers.get("Content-Type") != null &&
                this.headers.get("Content-Type").contains("json");
    }

    public String getBody() {
        return body;
    }

}
