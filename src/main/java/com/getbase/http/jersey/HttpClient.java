package com.getbase.http.jersey;

import com.getbase.Configuration;
import com.getbase.exceptions.ConnectionException;
import com.getbase.http.HttpMethod;
import com.getbase.http.Request;
import com.getbase.http.Response;
import com.getbase.utils.Joiner;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        for (Map.Entry<String, String> h : request.getHeaders().entrySet()) {
            invocationBuilder.header(h.getKey(), h.getValue());
        }

        // perform request
        Invocation invocation;
        javax.ws.rs.core.Response jerseyResponse = null;
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
            try {
                jerseyResponse = invocation.invoke();
            } catch (Exception e) {
                throw new ConnectionException(e);
            }

            // flatten response headers
            Map<String, String> responseHeaders = new HashMap<String, String>();
            for (Map.Entry<String, List<String>> h : jerseyResponse.getStringHeaders().entrySet()) {
                responseHeaders.put(h.getKey(), Joiner.join(";", h.getValue()));
            }

            // prepare basecrm.http response
            Response response = new Response(jerseyResponse.getStatus(),
                    jerseyResponse.readEntity(String.class),
                    responseHeaders);

            return response;
        } finally {
            if (jerseyResponse != null) {
                jerseyResponse.close();
            }
        }
    }

    protected javax.ws.rs.client.Client createJerseyClient(final Configuration config) {
        // setup client
        ClientConfig clientConfig = new ClientConfig();

        if (config.isVerbose()) {
            clientConfig.register(new LoggingFilter());
        }

        javax.ws.rs.client.Client client;

        if (config.isVerifySSL()) {
            client = ClientBuilder.newBuilder().withConfig(clientConfig).hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return config.isVerifySSL();
                }
            }).build();
        } else {
            client = ClientBuilder.newClient(clientConfig);
        }

        return client;
    }
}
