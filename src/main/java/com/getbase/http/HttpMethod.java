package com.getbase.http;

public enum HttpMethod {
    HEAD ("HEAD"),
    GET ("GET"),
    POST ("POST"),
    PUT ("PUT"),
    PATCH ("PATCH"),
    DELETE ("DELETE");


    private final String name;

    private HttpMethod(String method) {
        this.name = method;
    }

    public boolean equalsName(String other) {
        return (other == null) ? false : this.name.equals(other);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
