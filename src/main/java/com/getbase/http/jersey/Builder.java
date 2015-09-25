package com.getbase.http.jersey;

import com.getbase.Configuration;

import javax.ws.rs.client.Client;

public interface Builder {
    Client build(Configuration configuration);
}
