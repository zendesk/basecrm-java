## CHANGELOG

### v1.2.0 (2015-09-28)

**Bug Fixes**

* Complete sync process only when 204 status code is returned
    * Previous version of the client was exiting a sync process in case of an empty item list returned from API, even though HTTP status code 204 (No Content) was not returned. An empty list may be returned in some exceptional cases such as timeouts, but that does not mean the end of sync process - more items will be sent in a next batch. Current version fixes the problem of premature sync exit and waits for explicit termination code (204).

**Features and Improvements**

* Debug traces via SLF4J
    * basic tracing of every HTTP request, such as URL, status code and execution time (on DEBUG level)
    * tracing of sync progress - sync started/completed, number of items fetched, number of items left (on INFO and DEBUG levels)
    * logs are published via SLF4J interface. Refer to README for instruction of how to setup logging binding for SLF4J 

* Jersey HTTP client now allows to plug-in a custom configuration and filters
    * refer to README for details on HTTP Client Instrumentation

### v1.1.0 (2015-06-05)

**Features and Improvements**

* Sync API support
  * Low-level interface via `com.getbase.sync.SyncService`
  * High-level interface via `com.getbase.sync.Sync`

### v1.0.1 (2015-05-08)

**Feature and Improvements**

* Make the wrapper compatible with Java 6, 7, and 8

### v1.0.0 (2015-05-04)

* Birth!
