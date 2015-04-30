package com.getbase.http;

import com.getbase.utils.Joiner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Request {
    private HttpMethod method = HttpMethod.GET;
    private String url;
    private Map<String, Object> queryParameters = new HashMap<String, Object>();
    private Map<String, String> headers = new HashMap<String, String>();
    private String body;

    public HttpMethod getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method=" + method +
                ", url='" + url + '\'' +
                ", queryParameters=" + queryParameters +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }

    public static final class Builder {
        private final Request request;

        public Builder() {
            this.request = new Request();
        }

        public Builder method(HttpMethod method) {
            this.request.method = method;
            return this;
        }

        public Builder url(String url) {
            this.request.url = url;
            return this;
        }

        public Builder param(String key, Object value) {
            this.request.queryParameters.put(key, value);
            return this;
        }

        public Builder param(String key, List<? extends Object> values) {
            Objects.requireNonNull(values);

            if (values.isEmpty()) {
                return this;
            }

            String value = Joiner.join(",", values);
            this.request.queryParameters.put(key, value);

            return this;
        }

        public Builder header(String key, String value) {
            this.request.headers.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.request.body = body;
            return this;
        }

        public Request build() {
            return this.request;
        }
    }

}
