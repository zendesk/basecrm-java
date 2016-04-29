## CHANGELOG

### v1.3.2 (2016-04-29)

**Features and Improvements**

* [Products API](https://developers.getbase.com/docs/rest/reference/products) support [#19](https://github.com/basecrm/basecrm-java/pull/19)

* toString for models is more readable [#19](https://github.com/basecrm/basecrm-java/pull/19)

### v1.3.1 (2016-03-24)

**Bug Fixes**

* NPE fixed for Joiner - for every list starting with null element NPE was thrown [#17](https://github.com/basecrm/basecrm-java/pull/17)

### v1.3.0 (2016-03-15)

**Features and Improvements**

* `com.getbase.sync.SessionManager` class to make feasible sharing single sync session between threads / nodes [#11](https://github.com/basecrm/basecrm-java/pull/11)
    * refer to README for details on Sync session sharing

* HttpClient is sending additional header: "X-Client-Type: api" [#13](https://github.com/basecrm/basecrm-java/pull/13) 

* Api version prefix management moved from HttpClient to BaseService implementations [#13](https://github.com/basecrm/basecrm-java/pull/13)

* Descriptive message in BaseException instead of null [#12](https://github.com/basecrm/basecrm-java/pull/12)

**Bug Fixes**

* Services SearchCriteria ids method with vararg long infinite loop was removed [#14](https://github.com/basecrm/basecrm-java/pull/14)

* Services SearchCriteria ids method with List<Integer> replaced by List<Long> [#14](https://github.com/basecrm/basecrm-java/pull/14)
    * All models ids are Long so client will be able to reach any id > `Integer.MAX_VALUE`
    * **This is actually a breaking change**, all ids method calls with `List<Integer>` must be replaced by `List<Long>`

### v1.2.0 (2015-09-28)

**Features and Improvements**

* Debug traces via SLF4J
    * basic tracing of every HTTP request, such as URL, status code and execution time (on DEBUG level)
    * tracing of sync progress - sync started/completed, number of items fetched, number of items left (on INFO and DEBUG levels)
    * logs are published via SLF4J interface. Refer to README for instruction of how to setup logging binding for SLF4J 

* Jersey HTTP client now allows to plug-in a custom configuration and filters
    * refer to README for details on HTTP Client Instrumentation

**Bug Fixes**

* Complete sync process only when 204 status code is returned
    * Previous version of the client was exiting a sync process in case of an empty item list returned from API, even though HTTP status code 204 (No Content) was not returned. An empty list may be returned in some exceptional cases such as timeouts, but that does not mean the end of sync process - more items will be sent in a next batch. Current version fixes the problem of premature sync exit and waits for explicit termination code (204).

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
