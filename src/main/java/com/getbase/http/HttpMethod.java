package com.getbase.http;

import java.util.EnumSet;

public enum HttpMethod {
    HEAD,
    GET,
    POST,
    PUT,
    PATCH,
    DELETE;

    private static final EnumSet<HttpMethod> bodySupported = EnumSet.of(POST, PUT, PATCH);

    public boolean isBodySupported() {
        return bodySupported.contains(this);
    }
}
