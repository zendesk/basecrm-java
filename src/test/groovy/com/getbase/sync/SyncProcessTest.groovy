package com.getbase.sync

import com.getbase.Client
import com.getbase.Configuration
import com.getbase.http.HttpClient
import spock.lang.Specification
import spock.lang.Subject

class SyncProcessTest extends Specification {

    @Subject
    SyncProcess syncProcess

    def client = new Client(Configuration.getDefault(), Mock(HttpClient))
    def sessionManager = Mock(SessionManager)
    def syncService = Mock(SyncService)

    def deviceUUID = 'device-123'
    def sessionId = 'session-id'
    def session = new Session(sessionId, [])

    def setup() {
        syncProcess = new SyncProcess(client, deviceUUID, sessionManager, { x, y -> true })
        client.syncService = syncService
    }

    def 'get session from session manager before create new'() {
        when:
        syncProcess.run()

        then:
        1 * sessionManager.getSession(deviceUUID) >> session
    }

    def 'create new session when no session in session manager'() {
        given:
        sessionManager.getSession(deviceUUID) >> null

        when:
        syncProcess.run()

        then:
        1 * syncService.start(deviceUUID) >> session
    }

    def 'saves valid session in session manager'() {
        when:
        syncService.start(deviceUUID) >> session
        syncProcess.run()

        then:
        1 * sessionManager.setSession(deviceUUID, session)

        when:
        sessionManager.getSession(deviceUUID) >> session
        syncProcess.run()

        then:
        1 * sessionManager.setSession(deviceUUID, session)
    }

    def 'clear session when all data processed'() {
        given:
        syncService.start(deviceUUID) >> session

        when:
        syncProcess.run()

        then:
        1 * sessionManager.clearSession(deviceUUID)
    }

}
