package com.getbase;

import com.getbase.http.HttpClient;
import com.getbase.services.LeadsService;

public class Client {

    private final Configuration config;
    private final HttpClient httpClient;

    private LeadsService leads;

    public Client(Configuration config) {
        this(config, new com.getbase.http.jersey.HttpClient(config));
    }

    public Client(Configuration config, HttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public Configuration getConfig() {
        return this.config;
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public LeadsService leads() {
        if (this.leads == null) {
            this.leads = new LeadsService(this.httpClient);
        }
        return this.leads;
    }
}
