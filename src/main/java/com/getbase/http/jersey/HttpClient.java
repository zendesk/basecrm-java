package com.getbase.http.jersey;

import com.getbase.Configuration;
import com.getbase.exceptions.ConnectionException;
import com.getbase.http.Request;
import com.getbase.http.Response;
import com.getbase.utils.Joiner;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.filter.LoggingFilter;
import org.slf4j.bridge.SLF4JBridgeHandler;

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

        redirectJerseyClientJulToSlf4j();

        this.client = createJerseyClient(this.config);
    }

    private void redirectJerseyClientJulToSlf4j() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Override
    public Response rawRequest(Request request) {
        if (!request.getMethod().isBodySupported() && request.getBody() != null) {
            throw new IllegalArgumentException("Provided HTTP method is not allowed to send body");
        }

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

        if (request.getBody() != null && !request.getBody().isEmpty() && request.getMethod().isBodySupported()) {
            invocation = invocationBuilder.build(request.getMethod().name(),
                    Entity.json(request.getBody()));
        } else {
            invocation = invocationBuilder.build(request.getMethod().name());
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

        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, config.getTimeout() * 1000);
        clientConfig.property(ClientProperties.READ_TIMEOUT, config.getTimeout() * 1000);

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
