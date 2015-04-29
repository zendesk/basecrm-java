package com.getbase.http

import com.getbase.Configuration
import com.getbase.exceptions.ConnectionException
import com.getbase.exceptions.RequestException
import com.getbase.serializer.JsonDeserializer
import spock.lang.Specification


class HttpClientTest extends Specification {

    public static class EntityWithId {
        long id

        long getId() {
             id
        }
    }

    def getAccessToken() {
        def token = System.getenv("BASECRM_ACCESS_TOKEN")
        if (token == null || token.isEmpty()) throw new RuntimeException('"BASECRM_ACCESS_TOKEN" environment variable was not found.')
        token
    }

    def getConfiguration() {
        new Configuration.Builder().
                verbose().
                accessToken(getAccessToken()).
                userAgent(Configuration.DEFAULT_USER_AGENT + "+tests").
                build()
    }


    def getId(String json) {
        JsonDeserializer.deserialize(json, EntityWithId.class).getId()
    }

    def getClient() {
        new com.getbase.http.jersey.HttpClient(getConfiguration())
    }

    def "Get"() {
        when:
        def response = getClient().get("/users/self", null)

        then:
        response.getHttpStatus() == 200
        response.getHeaders() != null
        !response.getHeaders().isEmpty()
        response.getBody() != null
        !response.getBody().isEmpty()
        getId(response.getBody()) > 0
    }

    def "Get - sends invalid query parameters"() {
        when:
        getClient().get("/users/self", ["unknown": "param"])

        then:
        RequestException ex = thrown()
        ex.getHttpStatus() == 400
        !ex.getRequestId().isEmpty()
        ex.getErrors().size() == 1
        ex.getErrors().first().getCode() == "invalid_param"
    }

    def "Post"() {
        when:
        def response = getClient().post("/leads", '{"data": {"last_name": "Johnson"}}')

        then:
        response.getHttpStatus() == 200
        response.getHeaders() != null
        !response.getHeaders().isEmpty()
        response.getBody() != null
        !response.getBody().isEmpty()
        getId(response.getBody()) > 0
    }

    def "Post - sends invalid payload"() {
        when:
        getClient().post("/leads", '{"data": {}}')

        then:
        com.getbase.exceptions.ResourceException ex = thrown()
        ex.getHttpStatus() == 422
        !ex.getRequestId().isEmpty()
        ex.getErrors().size() == 1
    }

    def "Put"() {
        given:
        def leadId = getId(getClient().post("/leads", '{"data": {"last_name": "Johnson"}}').getBody())

        when:
        def response = getClient().put("/leads/${leadId}", '{"data": {"first_name": "Mark"}}')

        then:
        response.getHttpStatus() == 200
        response.getHeaders() != null
        !response.getHeaders().isEmpty()
        response.getBody() != null
        !response.getBody().isEmpty()
        getId(response.getBody()) == leadId

    }

    def "Delete"() {
        given:
        def leadId = getId(getClient().post("/leads", '{"data": {"last_name": "Johnson"}}').getBody())

        when:
        def response = getClient().delete("/leads/${leadId}", null)

        then:
        response.getHttpStatus() == 204
        !response.getHeaders().isEmpty()
        response.getBody().isEmpty()
    }

    def "Request - authentication error"() {
        given:
        def client = new com.getbase.http.jersey.HttpClient(new Configuration.Builder().accessToken("INVALID").verbose().build())

        when:
        client.request(HttpMethod.GET, "/users/self", null, null)

        then:
        RequestException ex = thrown()
        ex.getHttpStatus() == 401
        !ex.getRequestId().isEmpty()
        ex.getErrors().size() == 1
        ex.getErrors().first().getCode() == "unauthorized"
    }

    def "Request - connection error"() {
        given:
        def client = new com.getbase.http.jersey.HttpClient(new Configuration.Builder().
                baseUrl("https://somethingthatnotexist.fail").
                accessToken("INVALID").
                verbose().
                build())

        when:
        client.request(HttpMethod.GET, "/users/self", null, null)

        then:
        thrown ConnectionException
    }
}
