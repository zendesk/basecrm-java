// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase;

import com.getbase.http.HttpClient;
import com.getbase.services.*;
import com.getbase.sync.SyncService;

public class Client {

    private final Configuration config;
    private final HttpClient httpClient;

    private AccountsService accountsService;
    private AssociatedContactsService associatedContactsService;
    private CallsService callsService;
    private CallOutcomesService callOutcomesService;
    private ContactsService contactsService;
    private DealsService dealsService;
    private DealUnqualifiedReasonsService dealUnqualifiedReasonsService;
    private LeadsService leadsService;
    private LeadUnqualifiedReasonsService leadUnqualifiedReasonsService;
    private LineItemsService lineItemsService;
    private LossReasonsService lossReasonsService;
    private NotesService notesService;
    private OrdersService ordersService;
    private PipelinesService pipelinesService;
    private ProductsService productsService;
    private SourcesService sourcesService;
    private LeadSourcesService leadSourcesService;
    private StagesService stagesService;
    private TagsService tagsService;
    private TasksService tasksService;
    private UsersService usersService;
    private SyncService syncService;

    public Client(Configuration config) {
        this(config, new com.getbase.http.jersey.HttpClient(config));
    }

    public Client(Configuration config, HttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public Configuration getConfig() {
        return this.config;
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public AccountsService accounts() {
        if (this.accountsService == null) {
            this.accountsService = new AccountsService(this.httpClient);
        }
        return this.accountsService;
    }

    public AssociatedContactsService associatedContacts() {
        if (this.associatedContactsService == null) {
            this.associatedContactsService = new AssociatedContactsService(this.httpClient);
        }
        return this.associatedContactsService;
    }

    public CallsService calls() {
        if (this.callsService == null) {
            this.callsService = new CallsService(this.httpClient);
        }
        return this.callsService;
    }

    public CallOutcomesService callOutcomes() {
        if (this.callOutcomesService == null) {
            this.callOutcomesService = new CallOutcomesService(this.httpClient);
        }
        return this.callOutcomesService;
    }
   
    public ContactsService contacts() {
        if (this.contactsService == null) {
            this.contactsService = new ContactsService(this.httpClient);
        }
        return this.contactsService;
    }

    public DealsService deals() {
        if (this.dealsService == null) {
            this.dealsService = new DealsService(this.httpClient);
        }
        return this.dealsService;
    }

    public DealUnqualifiedReasonsService dealUnqualifiedReasons() {
        if (this.dealUnqualifiedReasonsService == null) {
            this.dealUnqualifiedReasonsService = new DealUnqualifiedReasonsService(this.httpClient);
        }
        return this.dealUnqualifiedReasonsService;
    }

    public LeadsService leads() {
        if (this.leadsService == null) {
            this.leadsService = new LeadsService(this.httpClient);
        }
        return this.leadsService;
    }

    public LeadUnqualifiedReasonsService leadUnqualifiedReasons() {
        if (this.leadUnqualifiedReasonsService == null) {
            this.leadUnqualifiedReasonsService = new LeadUnqualifiedReasonsService(this.httpClient);
        }
        return this.leadUnqualifiedReasonsService;
    }

    public LineItemsService lineItems() {
        if (this.lineItemsService == null) {
            this.lineItemsService = new LineItemsService(this.httpClient);
        }
        return this.lineItemsService;
    }

    public LossReasonsService lossReasons() {
        if (this.lossReasonsService == null) {
            this.lossReasonsService = new LossReasonsService(this.httpClient);
        }
        return this.lossReasonsService;
    }

    public NotesService notes() {
        if (this.notesService == null) {
            this.notesService = new NotesService(this.httpClient);
        }
        return this.notesService;
    }

    public OrdersService orders() {
        if (this.ordersService == null) {
            this.ordersService = new OrdersService(this.httpClient);
        }
        return this.ordersService;
    }

    public PipelinesService pipelines() {
        if (this.pipelinesService == null) {
            this.pipelinesService = new PipelinesService(this.httpClient);
        }
        return this.pipelinesService;
    }

    public ProductsService products() {
        if (this.productsService == null) {
            this.productsService = new ProductsService(this.httpClient);
        }
        return this.productsService;
    }

    public SourcesService sources() {
        if (this.sourcesService == null) {
            this.sourcesService = new SourcesService(this.httpClient);
        }
        return this.sourcesService;
    }

    public LeadSourcesService leadSources() {
        if (this.leadSourcesService == null) {
            this.leadSourcesService = new LeadSourcesService(this.httpClient);
        }
        return this.leadSourcesService;
    }
   
    public StagesService stages() {
        if (this.stagesService == null) {
            this.stagesService = new StagesService(this.httpClient);
        }
        return this.stagesService;
    }

    public TagsService tags() {
        if (this.tagsService == null) {
            this.tagsService = new TagsService(this.httpClient);
        }
        return this.tagsService;
    }

    public TasksService tasks() {
        if (this.tasksService == null) {
            this.tasksService = new TasksService(this.httpClient);
        }
        return this.tasksService;
    }

    public UsersService users() {
        if (this.usersService == null) {
            this.usersService = new UsersService(this.httpClient);
        }
        return this.usersService;
    }

    public SyncService sync() {
        if (this.syncService == null) {
            this.syncService = new SyncService(this.httpClient);
        }
        return this.syncService;
    }
}
