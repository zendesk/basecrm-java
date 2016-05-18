package com.getbase.http;

import com.getbase.Configuration;
import com.getbase.exceptions.*;
import com.getbase.serializer.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public abstract class HttpClient {
    private static final Logger log = LoggerFactory.getLogger(HttpClient.class);

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
        return request(method, url, params, null, body);
    }

    public Response request(HttpMethod method,
                            String url,
                            Map<String, Object> params,
                            Map<String, String> headers,
                            String body) {
        Request.Builder builder = new Request.Builder().
                method(method).
                url(this.config.getBaseUrl() + url);


        if (params != null) {
            for (Map.Entry<String, Object> q : params.entrySet()) {
                builder.param(q.getKey(), q.getValue());
            }
        }

        authorizationStrategy(builder)
                .header("Accept", "application/json")
                .header("User-Agent", this.config.getUserAgent())
                .header("X-Client-Type", "api");


        if (body != null) {
            builder.header("Content-Type", "application/json").body(body);
        }

        if (headers != null) {
            builder.headers(headers);
        }

        Response response = rawRequest(builder.build());

        if (response.getHttpStatus() < 200 || response.getHttpStatus() >= 300) {
            handleErrorResponse(response);
        }

        return response;
    }

    protected Request.Builder authorizationStrategy(Request.Builder requestBuilder) {
        return requestBuilder.header("Authorization", "Bearer " + this.config.getAccessToken());
    }

    public abstract Response rawRequest(Request request);

    private void handleErrorResponse(Response response) throws ResourceException, RequestException, ServerException {
        int responseCode = response.getHttpStatus();

        if (responseCode == 422) {
            throw new ResourceException(responseCode, tryGetRequestId(response), tryGetErrors(response));
        } else if (responseCode == 429) {
            throw new RateLimitException();
        } else if (responseCode >= 400 && responseCode < 500) {
            throw new RequestException(responseCode, tryGetRequestId(response), tryGetErrors(response));
        } else if (responseCode >= 500 && responseCode < 600) {
            throw new ServerException(responseCode, tryGetRequestId(response), tryGetErrors(response));
        } else {
            throw new UnknownResponseException("Unhandled HTTP error " + response, response);
        }
    }

    private String tryGetRequestId(Response response) {
        final String requestId = response.getHeaders().get(X_REQUEST_ID);
        return requestId != null ? requestId : "unknown";
    }

    private List<BaseError> tryGetErrors(Response response) {
        if (response.isJSON()) {
            return JsonDeserializer.deserializeErrors(response.getBody());
        } else {
            return emptyList();
        }
    }
}
