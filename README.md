# basecrm-java

BaseCRM Official API V2 library client for Java (1.6+)

## Installation

The following intruction assume you have [Gradle Build System](http://gradle.org/) installed.

The library is available via [JCenter](https://bintray.com/bintray/jcenter). To install, add the following content to your `build.gradle` file:

```groovy
repositories {
    jcenter()
    maven {
        url  "http://dl.bintray.com/basecrm/maven"
    }
}

dependencies {
  compile "com.getbase:basecrm-java:1.1.0"
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
 * __userAgent__: Default user-agent for all requests. Default: `BaseCRM/V2 Java/1.1.0`
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

newDeal.setValue(1000);
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

### Pipeline

```java
client.pipelines(); // => com.getbase.services.PipelinesService
```

Actions:
* Retrieve all pipelines - `client.pipelines().list()`

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

### User

```java
client.users(); // => com.getbase.services.UsersService
```

Actions:
* Retrieve all users - `client.users().list()`
* Retrieve a single user - `client.users().get()`
* Retrieve an authenticating user - `client.users().self()`

## Logging
BaseCRM client uses Simple Logging Facade for Java (SLF4J) to track some diagnostic information. SLF4J is a logging facade that can work with various logging frameworks, such as java.util.logging, logback and log4j. BaseCRM client does not impose any particular logging framework and lets end user to plug-in desired framework at the deployment time. To learn how to provide logging binding refer to SLF4J [manual](http://www.slf4j.org/manual.html#swapping).
Note that client verbose traces have also been redirected to SLF4J to allow common log configuration. However, this means you will not be able to see these logs any more unless you provide logger binding as described above.

## License
MIT

## Bug Reports
Report [here](https://github.com/basecrm/basecrm-java/issues).

## Contact
BaseCRM developers (developers@getbase.com)
