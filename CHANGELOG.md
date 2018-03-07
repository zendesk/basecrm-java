## CHANGELOG

### v1.4.13 (2018-03-07)
**Bug Fixes**
* Serialize dealId as writable attribute for create/update [#44](https://github.com/basecrm/basecrm-java/pull/44)

### v1.4.12 (2018-02-12)

**Features and Improvements**

* `Sync` supports `timeToRunInMillis` constructor parameter, to specify max time it is allowed to run [#42](https://github.com/basecrm/basecrm-java/pull/42)

### v1.4.11 (2018-01-25)

**Features and Improvements**

* `Call` model added [#41](https://github.com/basecrm/basecrm-java/pull/41)

### v1.4.10 (2018-01-02)

**Features and Improvements**

* New property (`invited`) added to the User model [#40](https://github.com/basecrm/basecrm-java/issues/40)

### v1.4.9 (2017-12-14)

**Features and Improvements**

* New properties added to the User model [#39](https://github.com/basecrm/basecrm-java/issues/39)

### v1.4.8 (2017-10-31)

**Bug Fixes**

* Preserving null contactId value returned from service [#37](https://github.com/basecrm/basecrm-java/issues/37)

**Features and Improvements**

* Added contact.parentOrganizationId [#38](https://github.com/basecrm/basecrm-java/pull/38)

### v1.4.7 (2017-09-11)

**Bug Fixes**

* Handling the ids parameter in SearchCriteria [#34](https://github.com/basecrm/basecrm-java/pull/34)

**Features and Improvements**

* Added deal.customizedWinLikelihood [#35](https://github.com/basecrm/basecrm-java/pull/35)

### v1.4.6 (2017-06-19)

**Features and Improvements**

* Do not subclass java.util.logging.Logger as Google App Engine SM disallows it [#33](https://github.com/basecrm/basecrm-java/pull/33)

### v1.4.5 (2016-11-08)

**Features and Improvements**

* [Orders API](https://developers.getbase.com/docs/rest/reference/orders) support [#32](https://github.com/basecrm/basecrm-java/pull/32)
* [Line Items API](https://developers.getbase.com/docs/rest/reference/line_items) support [#32](https://github.com/basecrm/basecrm-java/pull/32)
* Pipeline disabled property exposed [#30](https://github.com/basecrm/basecrm-java/pull/30)

### v1.4.4 (2016-09-13)

**Features and Improvements**

* Extra properties added to Deal, Source and User models [#28](https://github.com/basecrm/basecrm-java/pull/28)

### v1.4.3 (2016-09-01)

**Features and Improvements**

* BaseException has context of HTTP method and URL, MDC setup for HttpClient requests removed [#27](https://github.com/basecrm/basecrm-java/pull/27)

### v1.4.2 (2016-08-09)

**Features and Improvements**

* MDC setup for HttpClient requests [#26](https://github.com/basecrm/basecrm-java/pull/26)
    * properties: baseClientMethod, baseClientUrl

### v1.4.1 (2016-07-18)

**Features and Improvements**

* Support for lead sources  [#25](https://github.com/basecrm/basecrm-java/pull/25)

### v1.4.0 (2016-06-24)

**Features and Improvements**

* Support for decimal deal value  [#23](https://github.com/basecrm/basecrm-java/pull/23)

  **Important:** Deal value type has been changed to BigDecimal

### v1.3.3 (2016-05-23)

**Features and Improvements**

* HttpClient opened for authentication extensions [#21](https://github.com/basecrm/basecrm-java/pull/21)

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
