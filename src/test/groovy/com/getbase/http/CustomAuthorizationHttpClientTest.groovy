package com.getbase.http

import com.getbase.Configuration
import spock.lang.Specification

class CustomAuthorizationHttpClientTest extends Specification {

    def authorizationHeader = "CustomAuthorizationHeader"
    def testToken = "this-1s-t3st-t0ken"

    def "Authorization strategy replaces Authorization header"() {
        given:
        def client = new CustomAuthorizationHttpClient()

        when:
        client.request(HttpMethod.GET, "/dummy.json", [:], null)

        then:
        client.requestCaptured.headers[authorizationHeader] == testToken
        client.requestCaptured.headers["Authorization"] == null
    }

    class CustomAuthorizationHttpClient extends com.getbase.http.jersey.HttpClient {

        Request requestCaptured

        CustomAuthorizationHttpClient() {
            super(Configuration.getDefault())
        }

        @Override
        protected Request.Builder applyAuthorization(Request.Builder requestBuilder) {
            return requestBuilder.header(authorizationHeader, testToken);
        }

        @Override
        Response rawRequest(Request request) {
            requestCaptured = request
            return new Response(201, null);
        }

    }

}

