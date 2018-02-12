package com.getbase.sync

import com.getbase.Client
import com.getbase.Configuration
import com.getbase.models.User
import spock.lang.Shared
import spock.lang.Specification

class SyncTest extends Specification {
    @Shared def deviceUUID = "6dadcec8-6e61-4691-b318-1aab27b8fecf"
    @Shared def sessionId = "29f2aeeb-8d68-4ea7-95c3-a2c8e151f5a"

    def "Fetch - high-level - no previously set predicate"() {
        given:
        def client = new Client(new Configuration.Builder().accessToken(deviceUUID).build())
        def sync = new Sync(client, deviceUUID)

        when:
        sync.fetch()

        then:
        thrown(IllegalStateException)
    }

    def "Fetch - high-level"() {
        given:
        def session = new Session(sessionId, [new Queue('main', 1, 1)])
        def items = [[
                             "data": [
                                     "id": 1
                             ],
                             "meta": [
                                     "type": "user",
                                     "sync": [
                                             "event_type": "created",
                                             "ack_key": "User-1234-1",
                                             "revision": 1
                                     ]
                             ]
                     ]]

        def syncService = Mock(SyncService)
        1 * syncService.start(deviceUUID) >> session
        2 * syncService.fetch(deviceUUID, sessionId) >>> [items, null]
        1 * syncService.ack(deviceUUID, ['User-1234-1']) >> true

        def client = new Client(new Configuration.Builder().accessToken(deviceUUID).build())
        client.syncService = syncService

        def sync = new Sync(client, deviceUUID)

        when:
        def status = sync.subscribe(User.class, { meta, user ->
            assert meta != null

            assert meta.type.type == "user"
            assert meta.type.isSupported()
            assert meta.type.getClassName() == "com.getbase.models.User"
            assert meta.type.getClassType() == User

            assert user != null
            assert user instanceof User
            assert user.id == 1

            return true
        }).fetch()

        then:
        status
    }

    def "Fetch - low-level - observers subscribed"() {
        given:
        def client = new Client(new Configuration.Builder().accessToken(deviceUUID).build())
        def sync = new Sync(client, deviceUUID)

        when:
        sync.subscribe(User.class, {user -> return true}).fetch({meta, data -> return true})

        then:
        thrown(IllegalStateException)

    }

    def "FetchInternal - nothing to synchronize"() {
        given:
        def session = null

        def syncService = Mock(SyncService)
        1 * syncService.start(deviceUUID) >> session
        0 * syncService.fetch(_)
        0 * syncService.ack(_)

        def client = new Client(new Configuration.Builder().accessToken(deviceUUID).build())
        client.syncService = syncService

        def sync = new Sync(client, deviceUUID)

        when:
        def status = sync.fetchInternal({ meta, data ->
            assert false

            return true
        })

        then:
        status
    }

    def "FetchInternal"() {
        given:
        def session = new Session(sessionId, [new Queue('main', 1, 1)])
        def items = [[
                            "data": [
                                    "id": 1
                            ],
                            "meta": [
                                    "type": "user",
                                    "sync": [
                                            "event_type": "created",
                                            "ack_key": "User-1234-1",
                                            "revision": 1
                                    ]
                            ]
                     ]]

        def syncService = Mock(SyncService)
        1 * syncService.start(deviceUUID) >> session
        2 * syncService.fetch(deviceUUID, sessionId) >>> [items, null]
        1 * syncService.ack(deviceUUID, ['User-1234-1']) >> true

        def client = new Client(new Configuration.Builder().accessToken(deviceUUID).build())
        client.syncService = syncService

        def sync = new Sync(client, deviceUUID)

        when:
        def status = sync.fetchInternal({ meta, data ->
            assert meta != null
            assert data != null

            assert meta.type.type == "user"
            assert meta.type.isSupported()
            assert meta.type.getClassName() == "com.getbase.models.User"
            assert meta.type.getClassType() == User

            assert meta.sync.eventType == "created"
            assert meta.sync.ackKey == "User-1234-1"
            assert meta.sync.revision == 1

            assert data == ["id": 1]
            return true
        })

        then:
        status
    }

    def "fetch continues even if empty item collection returned"() {
        given:
        def session = new Session(sessionId, [new Queue('main', 2, 2)])
        def items1 = [[
                             "data": [
                                     "id": 1
                             ],
                             "meta": [
                                     "type": "user",
                                     "sync": [
                                             "event_type": "created",
                                             "ack_key": "User-1234-1",
                                             "revision": 1
                                     ]
                             ]
                     ]]
        def items2 = [[
                              "data": [
                                      "id": 2
                              ],
                              "meta": [
                                      "type": "user",
                                      "sync": [
                                              "event_type": "created",
                                              "ack_key": "User-1234-2",
                                              "revision": 1
                                      ]
                              ]
                      ]]

        def syncService = Mock(SyncService)
        1 * syncService.start(deviceUUID) >> session
        4 * syncService.fetch(deviceUUID, sessionId) >>> [items1, [], items2, null]
        1 * syncService.ack(deviceUUID, ['User-1234-1']) >> true
        1 * syncService.ack(deviceUUID, ['User-1234-2']) >> true

        def client = new Client(new Configuration.Builder().accessToken(deviceUUID).build())
        client.syncService = syncService

        def sync = new Sync(client, deviceUUID)
        def index = 0

        when:
        def status = sync.fetchInternal(
                { meta, data ->
                    def response1 = {
                        assert meta != null
                        assert data != null

                        assert meta.type.type == "user"
                        assert meta.type.isSupported()
                        assert meta.type.getClassName() == "com.getbase.models.User"
                        assert meta.type.getClassType() == User

                        assert meta.sync.eventType == "created"
                        assert meta.sync.ackKey == "User-1234-1"
                        assert meta.sync.revision == 1

                        assert data == ["id": 1]
                        return true
                    }

                    def response2 = {
                        assert meta != null
                        assert data != null

                        assert meta.type.type == "user"
                        assert meta.type.isSupported()
                        assert meta.type.getClassName() == "com.getbase.models.User"
                        assert meta.type.getClassType() == User

                        assert meta.sync.eventType == "created"
                        assert meta.sync.ackKey == "User-1234-2"
                        assert meta.sync.revision == 1

                        assert data == ["id": 2]
                        return true
                    }

                    def responses = [response1, response2]
                    return responses[index++]()
                })

        then:
        index == 2
        status
    }
}
