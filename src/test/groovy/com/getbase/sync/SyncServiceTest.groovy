package com.getbase.sync

import com.getbase.http.HttpClient
import com.getbase.http.HttpMethod
import com.getbase.http.Response
import spock.lang.Shared
import spock.lang.Specification

class SyncServiceTest extends Specification {
    @Shared def deviceUUID = "6dadcec8-6e61-4691-b318-1aab27b8fecf"
    @Shared def sessionId = "29f2aeeb-8d68-4ea7-95c3-a2c8e151f5a"

    def "Start - nothing new to synchronize"() {
        given:
        def httpResponse = new Response(204)

        def httpClient = Mock(HttpClient)
        1 * httpClient.request(HttpMethod.POST,
                "/v2/sync/start",
                null,
                ['X-Basecrm-Device-UUID': deviceUUID],
                null) >> httpResponse

        def sync = new SyncService(httpClient)

        when:
        def session = sync.start(deviceUUID)

        then:
        session == null
    }

    def "Start - got session"() {
        given:
        def json = '{"data":{"id":"29f2aeeb-8d68-4ea7-95c3-a2c8e151f5a","queues":[{"data":{"name":"main","pages":1,"total_count":2},"meta":{"type":"sync_session"}}]}}'
        def httpResponse = new Response(201, json)

        def httpClient = Mock(HttpClient)
        1 * httpClient.request(HttpMethod.POST,
                "/v2/sync/start",
                null,
                ['X-Basecrm-Device-UUID': deviceUUID],
                null) >> httpResponse

        def sync = new SyncService(httpClient)

        when:
        def session = sync.start(deviceUUID)

        then:
        session != null
        session instanceof Session
        session.id == sessionId
        session.queues.size() == 1
    }

    def "Fetch - no more data to synchronize"() {
        given:
        def httpResponse = new Response(204)

        def httpClient = Mock(HttpClient)
        1 * httpClient.request(HttpMethod.GET,
                "/v2/sync/${sessionId}/queues/main",
                null,
                ['X-Basecrm-Device-UUID': deviceUUID],
                null) >> httpResponse

        def sync = new SyncService(httpClient)

        when:
        def items = sync.fetch(deviceUUID, sessionId)

        then:
        items == null
    }

    def "Fetch - got queue items"() {
        given:
        def json = '{"items":[{"data":{"id":1},"meta":{"type":"user","sync":{"event_type":"created","ack_key":"User-1234-1","revision":1}}}]}'
        def httpResponse = new Response(200, json)

        def httpClient = Mock(HttpClient)
        1 * httpClient.request(HttpMethod.GET,
                "/v2/sync/${sessionId}/queues/main",
                null,
                ['X-Basecrm-Device-UUID': deviceUUID],
                null) >> httpResponse

        def sync = new SyncService(httpClient)

        when:
        def items = sync.fetch(deviceUUID, sessionId)

        then:
        items == [[
                          "data": ["id":1],
                          "meta":[
                                  "type":"user",
                                  "sync":
                                          [
                                                  "event_type":"created",
                                                  "ack_key":"User-1234-1",
                                                  "revision":1
                                          ]
                          ]
                  ]]
    }

    def "Ack - with an empty list"() {
        given:
        def httpClient = Mock(HttpClient)
        def sync = new SyncService(httpClient)

        when:
        def status = sync.ack(deviceUUID, [])

        then:
        status
        0 * httpClient._
    }

    def "Ack"() {
        given:
        def ackKeys = ["User-1234-1"]
        def httpResponse = new Response(202)

        def httpClient = Mock(HttpClient)
        1 * httpClient.request(HttpMethod.POST,
                "/v2/sync/ack",
                null,
                ['X-Basecrm-Device-UUID': deviceUUID],
                '{"data":{"ack_keys":["User-1234-1"]}}') >> httpResponse

        def sync = new SyncService(httpClient)

        when:
        def status = sync.ack(deviceUUID, ackKeys)

        then:
        status
    }
}
