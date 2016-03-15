package com.getbase.sync;

/**
 * Manages Sync session instances.
 *
 * It could be extended for sharing single Sync session between many threads / processes / nodes.
 * Default implementation is a dummy base for extensions and it literally does nothing.
 *
 */
public class SessionManager {

    public Session getSession(String deviceUUID) {
        return null;
    }

    public void setSession(String deviceUUID, Session session) {
        // intentionally left blank
    }

    public void clearSession(String deviceUUID) {
        // intentionally left blank
    }

}
