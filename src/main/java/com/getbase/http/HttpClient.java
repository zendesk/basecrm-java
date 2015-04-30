package com.getbase.http;

import com.getbase.Configuration;
import com.getbase.exceptions.*;
import com.getbase.serializer.JsonDeserializer;

import java.util.Map;

public abstract class HttpClient {
    public static final String API_VERSION = "/v2";
    public static final String X_REQUEST_ID = "X-Request-Id";

    protected final Configuration config;

    public HttpClient(Configuration config) {
        this.config = config;
    }

    public Response get(String url, Map<String, Object> params) throws ResourceException, RequestException, ServerException {
        return request(HttpMethod.GET, url, params, null);
    }

    public Response post(String url, String body) throws ResourceException, RequestException, ServerException {
        return request(HttpMethod.POST, url, null, body);
    }


    public Response put(String url, String body) throws ResourceException, RequestException, ServerException {
        return request(HttpMethod.PUT, url, null, body);
    }

    public Response delete(String url, Map<String, Object> params) throws ResourceException, RequestException, ServerException {
        return request(HttpMethod.DELETE, url, params, null);
    }

    public Response request(HttpMethod method,
                            String url,
                            Map<String, Object> params,
                            String body) throws RequestException, ResourceException, ServerException {
        Request.Builder builder = new Request.Builder().
                method(method).
                url(this.config.getBaseUrl() + API_VERSION + url);


        if (params != null) {
            for (Map.Entry<String, Object> q : params.entrySet()) {
                builder.param(q.getKey(), q.getValue());
            }
        }

        builder.header("Accept", "application/json").
                header("Authorization", "Bearer " + this.config.getAccessToken()).
                header("User-Agent", this.config.getUserAgent());

        if (body != null) {
            builder.header("Content-Type", "application/json").body(body);
        }

        Response response = rawRequest(builder.build());

        if (response.getHttpStatus() < 200 || response.getHttpStatus() >= 300) {
            handleErrorResponse(response);
        }

        return response;
    }

    public abstract Response rawRequest(Request request);

    private void handleErrorResponse(Response response) throws ResourceException, RequestException, ServerException {
        int responseCode = response.getHttpStatus();

        if (!response.isJSON()) {
            throw new UnknownResponseException("Unknown HTTP error response. JSON expected", response);
        }

        if (responseCode == 422) {
            throw new ResourceException(responseCode,
                                        response.getHeaders().get(X_REQUEST_ID),
                                        JsonDeserializer.deserializeErrors(response.getBody()));
        } else if (responseCode == 429) {
            throw new RateLimitException();
        } else if (responseCode >= 400 && responseCode < 500) {
            throw new RequestException(responseCode,
                    response.getHeaders().get(X_REQUEST_ID),
                    JsonDeserializer.deserializeErrors(response.getBody()));
        } else if (responseCode >= 500 && responseCode < 600) {
            throw new ServerException(responseCode,
                    response.getHeaders().get(X_REQUEST_ID),
                    JsonDeserializer.deserializeErrors(response.getBody()));
        } else {
            throw new UnknownResponseException("Unhandled HTTP error response.", response);
        }

    }
}
