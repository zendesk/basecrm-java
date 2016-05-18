package com.getbase.http

import com.getbase.Configuration
import spock.lang.Specification

class CustomAuthorizationHttpClientTest extends Specification {

    def authorizationHeader = "CustomAuthorizationHeader"
    def testToken = "this-1s-t3st-t0ken"
    Request finalRequest


    def "Authorization strategy replaces Authorization header"() {
        given:
        def client = new CustomAuthorizationHttpClient()

        when:
        client.request(HttpMethod.GET, "/dummy.json", [:], null)

        then:
        finalRequest.headers[authorizationHeader] == testToken
        finalRequest.headers["Authorization"] == null
    }

    class CustomAuthorizationHttpClient extends com.getbase.http.jersey.HttpClient {

        CustomAuthorizationHttpClient() {
            super(Configuration.getDefault())
        }

        @Override
        protected Request.Builder authorizationStrategy(Request.Builder requestBuilder) {
            return requestBuilder.header(authorizationHeader, testToken);
        }

        @Override
        Response rawRequest(Request request) {
            finalRequest = request
            return new Response(201, null);
        }

    }

}

