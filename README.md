# basecrm-java

BaseCRM Official API V2 library client for Java (1.6+)

## Installation

The following intruction assume you have [Gradle Build System](http://gradle.org/) installed.

The library is available via [JCenter](https://bintray.com/bintray/jcenter). To install, add the following content to your `build.gradle` file:

```groovy
repositories {
    jcenter()
    maven {
        url  "https://dl.bintray.com/basecrm/maven"
    }
}

dependencies {
  compile "com.getbase:basecrm-java:1.4.21"
}
```

## Usage

```java
import com.getbase.*;

// Then we instantiate a client (as shown below)
```

### Build a client
__Using this api without authentication gives an error__

```java
Client client = new Client(new Configuration.Builder()
                .accessToken(System.getenv("BASECRM_ACCESS_TOKEN"))
                .verbose()
                .build());
```

### Client Options

The following builder options are available while instantiating a client:

 * __accessToken__: Personal access token
 * __baseUrl__: Base url for the api. Default: `https://api.getbase.com`
 * __userAgent__: Default user-agent for all requests. Default: `BaseCRM/V2 Java/1.4.20`
 * __timeout__: Request timeout. Default: `30` seconds
 * __verbose__: Verbose/debug mode. Default: `false`
 * __verifySSL__: Whether to skip SSL verification or not. Default: `true`

### Architecture

The library follows few architectural principles you should understand before digging deeper.
1. Interactions with resources are done via service objects.
2. Service objects are exposed as methods on client instances.
3. Service objects expose resource-oriented actions.
4. Actions return Plain Old Java Objects.

For example, to interact with deals API you will use `com.getbase.services.DealsService`, which you can get if you call:

```java
client.deals(); // => com.getbase.services.DealsService
```

When you want to list resources you will use `#list` method which returns a `java.util.List` of resources.
You can specify search criteria either by using `SearchCriteria` builder or by passing `java.util.Map`.
Notice that every single service which supports resource listing action, exposes it's own `SearchCriteria`:

```java
import com.getbase.services.LeadsService;

client.leads().list(new LeadsService.SearchCriteria()
                .page(1)
                .perPage(100))
                .stream()
                .forEach(System.out::println);
```

To find a resource by it's unique identifier use `#get` method:

```java
import com.getbase.models.Deal;

Deal deal = client.deals().get(id);
```

When you'd like to create a resource, or update it's attributes you want to use either `#create` or `#update` methods. Both of them can take either `java.util.Map` or a model class e.g. `com.getbase.models.Deal` instance. For example if you want to create a new deal you will call:

```java
import com.getbase.models.*;
import com.getbase.services.*;

Contact coffeeShop = client.contacts().list(new ContactsService.SearchCriteria()
                          .page(1)
                          .perPage(1)
                          .name("Coffee Shop"))
                          .get(0);

Deal redesign = new Deal();
redesign.setContactId(coffeeShop.getId());
redesign.setName("Website redesign");
Deal newDeal  = client.deals().create(redesign);

newDeal.setValue(new BigDecimal("1000.00"));
newDeal.setCurrency("USD");
client.deals().update(newDeal);
```

To destroy a resource use `#delete` method:

```java
boolean deleted = client.deals().delete(id);
```

There other non-CRUD operations supported as well. Please contact corresponding service files for in-depth documentation.

## Sync API

The following sample code shows how to perform a full synchronization flow using high-level wrapper.

First of all you need an instance of `com.getbase.Client`. High-level `com.getbase.sync.Sync` wrapper uses `com.getbase.sync.SyncService` to interact with the Sync API.
In addition to the client instance, you must provide a device's UUID within `deviceUUID` parameter. The device's UUID must not change between synchronization session, otherwise the sync service will not recognize the device and will send all the data again.

```java
import com.getbase.*;
import com.getbase.sync.*;

Client client = new Client(new Configuration.Builder()
                .accessToken(System.getenv("BASECRM_ACCESS_TOKEN"))
                .build());

String deviceUUID = System.getenv("BASECRM_DEVICE_UUID");
Sync sync = new Sync(client, deviceUUID);
```

Now you have two options. Either subscribe to stream of all resources using a single observer, or subscribe to each resource separately and call `fetch` without arguments.

```java
import com.getbase.models.*;

sync.subscribe(Lead.class, (meta, lead) -> true)
    .subscribe(Contact.class, (meta, contact) -> true)
    .fetch();
```

Notice that, when you return `true` from the predicate, the wrapper will eventually ack the data.

## Logging
BaseCRM client uses Simple Logging Facade for Java (SLF4J) to track some diagnostic information. SLF4J is a logging facade that can work with various logging frameworks, such as java.util.logging, logback and log4j. BaseCRM client does not impose any particular logging framework and lets end user to plug-in desired framework at the deployment time. To learn how to provide logging binding refer to SLF4J [manual](http://www.slf4j.org/manual.html#swapping).

Note that client verbose traces have also been redirected to SLF4J to allow common log configuration. However, this means you will not be able to see these logs any more unless you provide logger binding as described above.

## Resources and actions

Documentation for every action can be found in corresponding service files under `src/main/java/com/getbase/services/` directory.

### Account

```java
client.accounts(); // => com.getbase.services.AccountsService
```

Actions:
* Retrieve account details - `client.accounts().self()`

### AssociatedContact

```java
client.associatedContacts(); // => com.getbase.services.AssociatedContactsService
```

Actions:
* Retrieve deal's associated contacts - `client.associatedContacts().list()`
* Create an associated contact - `client.associatedContacts().create()`
* Remove an associated contact - `client.associatedContacts().delete()`

### Call

```java
client.calls(); // => com.getbase.services.CallsService
```

Actions:
* Retrieve all calls - `client.calls().list()`
* Create a call - `client.calls().create()`
* Retrieve a single call - `client.calls().get()`
* Update a call - `client.calls().update()`
* Delete a call - `client.calls().delete()`

### Call Outcome

```java
client.callOutcomes(); // => com.getbase.services.CallOutcomesService
```

Actions:
* Retrieve all call outcomes - `client.callOutcomes().list()`

### Collaboration

```java
client.collaborations(); // => com.getbase.services.CollaborationsService
```

Actions:
* Retrieve all collaborations - `client.collaborations().list()`
* Create a collaboration - `client.collaborations().create()`
* Retrieve a single collaboration - `client.collaborations().get()`
* Delete a collaboration - `client.collaborations().delete()`

### Contact

```java
client.contacts(); // => com.getbase.services.ContactsService
```

Actions:
* Retrieve all contacts - `client.contacts().list()`
* Create a contact - `client.contacts().create()`
* Retrieve a single contact - `client.contacts().get()`
* Update a contact - `client.contacts().update()`
* Delete a contact - `client.contacts().delete()`

### Deal

```java
client.deals(); // => com.getbase.services.DealsService
```

Actions:
* Retrieve all deals - `client.deals().list()`
* Create a deal - `client.deals().create()`
* Retrieve a single deal - `client.deals().get()`
* Update a deal - `client.deals().update()`
* Delete a deal - `client.deals().delete()`

### DealUnqualifiedReason

```java
client.dealUnqualifiedReasons(); // => com.getbase.services.DealUnqualifiedReasonsService
```

Actions:
* Retrieve all deal unqualified reasons - `client.dealUnqualifiedReasons().list()`
* Create a deal unqualified reason - `client.dealUnqualifiedReasons().create()`
* Retrieve a single deal unqualified reason - `client.dealUnqualifiedReasons().get()`
* Update a deal unqualified reason - `client.dealUnqualifiedReasons().update()`
* Delete a deal unqualified reason - `client.dealUnqualifiedReasons().delete()`

### Lead

```java
client.leads(); // => com.getbase.services.LeadsService
```

Actions:
* Retrieve all leads - `client.leads().list()`
* Create a lead - `client.leads().create()`
* Retrieve a single lead - `client.leads().get()`
* Update a lead - `client.leads().update()`
* Delete a lead - `client.leads().delete()`

### LeadUnqualifiedReason

```java
client.leadUnqualifiedReasons(); // => com.getbase.services.LeadUnqualifiedReasonsService
```

Actions:
* Retrieve all lead unqualified reasons - `client.leadUnqualifiedReasons().list()`

### LineItem

```java
client.lineItems(); // => com.getbase.services.LineItemsService
```

Actions:
* Retrieve order's line items - `client.lineItems().list()`
* Create a line item - `client.lineItems().create()`
* Retrieve a single line item - `client.lineItems().get()`
* Delete a line item - `client.lineItems().delete()`

### LossReason

```java
client.lossReasons(); // => com.getbase.services.LossReasonsService
```

Actions:
* Retrieve all reasons - `client.lossReasons().list()`
* Create a loss reason - `client.lossReasons().create()`
* Retrieve a single reason - `client.lossReasons().get()`
* Update a loss reason - `client.lossReasons().update()`
* Delete a reason - `client.lossReasons().delete()`

### Note

```java
client.notes(); // => com.getbase.services.NotesService
```

Actions:
* Retrieve all notes - `client.notes().list()`
* Create a note - `client.notes().create()`
* Retrieve a single note - `client.notes().get()`
* Update a note - `client.notes().update()`
* Delete a note - `client.notes().delete()`

### Order

```java
client.orders(); // => com.getbase.services.OrdersService
```

Actions:
* Retrieve all orders - `client.orders().list()`
* Create an order - `client.orders().create()`
* Retrieve a single order - `client.orders().get()`
* Update an order - `client.orders().update()`
* Delete an order - `client.orders().delete()`

### Pipeline

```java
client.pipelines(); // => com.getbase.services.PipelinesService
```

Actions:
* Retrieve all pipelines - `client.pipelines().list()`

### Product

```java
client.products(); // => com.getbase.services.ProductsService
```

Actions:
* Retrieve all products - `client.products().list()`
* Create a product - `client.products().create()`
* Retrieve a single product - `client.products().get()`
* Update a product - `client.products().update()`
* Delete a product - `client.products().delete()`

### Source

```java
client.sources(); // => com.getbase.services.SourcesService
```

Actions:
* Retrieve all sources - `client.sources().list()`
* Create a source - `client.sources().create()`
* Retrieve a single source - `client.sources().get()`
* Update a source - `client.sources().update()`
* Delete a source - `client.sources().delete()`

### Lead Source

```java
client.leadSources(); // => com.getbase.services.LeadSourcesService
```

Actions:
* Retrieve all lead sources - `client.leadSources().list()`
* Create a lead source - `client.leadSources().create()`
* Retrieve a single lead source - `client.leadSources().get()`
* Update a lead source - `client.leadSources().update()`
* Delete a lead source - `client.leadSources().delete()`

### Stage

```java
client.stages(); // => com.getbase.services.StagesService
```

Actions:
* Retrieve all stages - `client.stages().list()`

### Tag

```java
client.tags(); // => com.getbase.services.TagsService
```

Actions:
* Retrieve all tags - `client.tags().list()`
* Create a tag - `client.tags().create()`
* Retrieve a single tag - `client.tags().get()`
* Update a tag - `client.tags().update()`
* Delete a tag - `client.tags().delete()`

### Task

```java
client.tasks(); // => com.getbase.services.TasksService
```

Actions:
* Retrieve all tasks - `client.tasks().list()`
* Create a task - `client.tasks().create()`
* Retrieve a single task - `client.tasks().get()`
* Update a task - `client.tasks().update()`
* Delete a task - `client.tasks().delete()`

### TextMessage

```java
client.textMessages(); // => com.getbase.services.TextMessagesService
```

Actions:
* Retrieve text messages - `client.textMessages().list()`
* Retrieve a single text message - `client.textMessages().get()`

### User

```java
client.users(); // => com.getbase.services.UsersService
```

Actions:
* Retrieve all users - `client.users().list()`
* Retrieve a single user - `client.users().get()`
* Retrieve an authenticating user - `client.users().self()`

### Visit

```java
client.visits(); // => com.getbase.services.VisitsService
```

Actions:
* Retrieve visits - `client.visits().list()`

### VisitOutcome

```java
client.visitOutcomes(); // => com.getbase.services.VisitOutcomesService
```

Actions:
* Retrieve visit outcomes - `client.visitOutcomes().list()`

## Advanced Topic - Sync session sharing
For more advanced use cases when user wants to make data synchronization faster using multiple threads or processes (or uses micro-services instances) it is possible to share a single session between Sync instances.
To do that user can implement he's own `com.getbase.sync.SessionManager` and pass it to a Sync instance.

```java
class MySessionManager extends SessionManager {

    private MySessionRepository repository;

    MySessionManager(MySessionRepository repository) {
        this.repository = repository;
    }

    public Session getSession(String deviceUUID) {
        return repository.findByDevice(deviceUUID);
    }

    public void setSession(String deviceUUID, Session session) {
        repository.save(deviceUUID, session);
    }

    public void clearSession(String deviceUUID) {
        repository.delete(deviceUUID);
    }

}
```

Here is an example how to set custom SessionManager:

```java
Sync sync = new Sync(client, deviceUUID).setSessionManager(mySessionManager);
```

## Advanced Topic - Instrumenting HTTP Client
Base API client uses Jersey HTTP Client that can be instrumented using [client filters mechanism](https://jersey.java.net/documentation/latest/filters-and-interceptors.html#d0e9771). This might be helpful if for example you want to publish performance metrics for every request, etc. In order to instrument a client or provide some additional configuration you need to implement `com.getbase.http.jersey.Builer` interface and pass it when constructing `com.getbase.http.jersey.HttpClient`.

Here is an example of client filter that publishes performance metrics:
```java
public class RequestMetricsFilter implements ClientRequestFilter, ClientResponseFilter {

    private static final String TIMER_CONTEXT_PROPERTY_NAME = "RequestMetricsFilter.timer";

    private final MetricNamingStrategy naming;

    private final MetricRegistry metricRegistry;

    public RequestMetricsFilter(MetricNamingStrategy naming, MetricRegistry metricRegistry) {
        this.naming = naming;
        this.metricRegistry = metricRegistry;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        final String name = naming.from(Client.class, requestContext.getUri(), requestContext.getMethod());
        final Timer.Context timer = metricRegistry.timer(name).time();
        requestContext.setProperty(TIMER_CONTEXT_PROPERTY_NAME, timer);
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        final Object timer = requestContext.getProperty(TIMER_CONTEXT_PROPERTY_NAME);
        if (timer != null) {
            final Timer.Context timerContext = (Timer.Context) timer;
            timerContext.stop();
            requestContext.removeProperty(TIMER_CONTEXT_PROPERTY_NAME);
        }
    }

}
```

Then you need to register this filter in Jersey `ClientConfig` in your `Builder.build` method:
```java
public class InstrumentedHttpClientBuilder implements Builder {

    @Override
    public Client build(Configuration config) {
        ClientConfig clientConfig = new ClientConfig();

        clientConfig.register(requestMetricsFilter);
        
        \\do additional client config here 
        
        return newClient(clientConfig);
    }
}
```

Finally you need to pass your `Builder` when constructing a `Client`.
```java
 final HttpClient httpClient = new HttpClient(config, new InstrumentedHttpClientBuilder(requestMetricsFilter));
 Client client = new Client(config, httpClient);
```

## Bug Reports
Report [here](https://github.com/basecrm/basecrm-java/issues).

## Copyright and license

Copyright 2015 Zendesk

Licensed under the [Apache License, Version 2.0](LICENSE)
