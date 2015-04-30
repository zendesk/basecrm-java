package com.getbase.http.jersey;

import com.getbase.Configuration;
import com.getbase.exceptions.ConnectionException;
import com.getbase.http.HttpMethod;
import com.getbase.http.Request;
import com.getbase.http.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class HttpClient extends com.getbase.http.HttpClient {
    private javax.ws.rs.client.Client client;

    public HttpClient(Configuration config) {
        super(config);

        this.client = createJerseyClient(this.config);
    }

    @Override
    public Response rawRequest(Request request) {
        // set target url
        WebTarget webTarget = client.target(request.getUrl());

        // append query parameters
        for (Map.Entry<String, Object> q : request.getQueryParameters().entrySet()) {
            webTarget = webTarget.queryParam(q.getKey(), q.getValue());
        }

        // create jersey request
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        // assign headers
        request.getHeaders().
                entrySet().
                stream().
                forEach(h -> invocationBuilder.header(h.getKey(), h.getValue()));

        // perform request
        Invocation invocation;
        javax.ws.rs.core.Response jerseyResponse;
        System.out.println(request.toString());
        if (request.getBody() != null && !request.getBody().isEmpty() &&
                (
                        request.getMethod() == HttpMethod.POST ||
                        request.getMethod() == HttpMethod.PUT ||
                        request.getMethod() == HttpMethod.PATCH)
                ) {

            invocation = invocationBuilder.build(request.getMethod().toString(),
                    Entity.json(request.getBody()));
        } else {
            invocation = invocationBuilder.build(request.getMethod().toString());
        }

        try {
            jerseyResponse = invocation.invoke();
        } catch (Exception e) {
            throw new ConnectionException(e);
        }

        // flatten response headers
        Map<String, String> responseHeaders = new HashMap<>();
        jerseyResponse.getStringHeaders().
                entrySet().
                stream().
                forEach(h -> responseHeaders.put(h.getKey(), h.getValue().stream().collect(Collectors.joining(";"))));


        // prepare basecrm.http response
        Response response = new Response(jerseyResponse.getStatus(),
                jerseyResponse.readEntity(String.class),
                responseHeaders);

        return response;
    }

    public static javax.ws.rs.client.Client createJerseyClient(Configuration config) {
        // setup client
        ClientConfig clientConfig = new ClientConfig();

        if (config.isVerbose()) {
            clientConfig.register(new LoggingFilter());
        }

        javax.ws.rs.client.Client client;

        if (config.isVerifySSL()) {
            client = ClientBuilder.newBuilder().withConfig(clientConfig).hostnameVerifier((s, sslSession) -> true).build();
        } else {
            client = ClientBuilder.newClient(clientConfig);
        }

        return client;
    }
}
