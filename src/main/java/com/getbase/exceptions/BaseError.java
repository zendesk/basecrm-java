package com.getbase.exceptions;

public class BaseError {
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseError error = (BaseError) o;

        if (!code.equals(error.code)) return false;
        if (!message.equals(error.message)) return false;
        if (details != null ? !details.equals(error.details) : error.details != null) return false;
        if (resource != null ? !resource.equals(error.resource) : error.resource != null) return false;
        return !(field != null ? !field.equals(error.field) : error.field != null);

    }

    @Override
    public String toString() {
        return "BaseError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                ", resource='" + resource + '\'' +
                ", field='" + field + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (resource != null ? resource.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        return result;
    }

    private String code;
    private String message;
    private String details;
    private String resource;
    private String field;
}
