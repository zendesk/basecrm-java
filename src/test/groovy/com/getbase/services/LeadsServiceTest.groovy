package com.getbase.services

import com.getbase.Configuration
import com.getbase.Client
import com.getbase.models.Lead
import spock.lang.Specification

class LeadsServiceTest extends Specification {
    def getAccessToken() {
        def token = System.getenv("BASECRM_ACCESS_TOKEN")
        if (token == null || token.isEmpty()) throw new RuntimeException('"BASECRM_ACCESS_TOKEN" environment variable was not found.')
        token
    }

    def getConfiguration() {
        new Configuration.Builder()
                .verbose()
                .accessToken(accessToken)
                .userAgent(Configuration.DEFAULT_USER_AGENT + "+tests")
                .build()
    }

    def getClient() {
        new Client(configuration)
    }

    def nextRand() {
        Long.toString(new Random().nextLong())
    }

    def "List - with params"() {
        given:
        client.leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def leads = client.leads().list(["page": 1, "per_page": 1])

        then:
        leads.size() > 0
    }

    def "List - with query param builder"() {
        given:
        client.leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def leads = client.leads().list(new LeadsService.SearchCriteria().page(1).perPage(1))

        then:
        leads.size() > 0
    }

    def "List - scopes to params"() {
        given:
        def searched = client.leads().create(["first_name": "Mark " + nextRand(), "last_name": "Johnson " + nextRand()])

        when:
        //getClient().leads().all().page().perPage().stream().forEach(l -> ...)
        def leads = client.leads().list(new LeadsService.SearchCriteria()
                .page(1)
                .perPage(1)
                .firstName(searched.firstName)
                .lastName(searched.lastName))

        then:
        leads.size() == 1
        leads.first().id == searched.id
    }

    def "Get"() {
        given:
        def searched = client.leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def found = client.leads().get(searched.id)

        then:
        found.id == searched.id
    }

    def "Create - with Lead entity"() {
        given:
        def lead = new Lead()
        lead.firstName = "Mark"
        lead.lastName = "Johnson"

        when:
        def created = client.leads().create(lead)

        then:
        created.id > 0
        created.firstName == lead.firstName
        created.lastName == lead.lastName
    }

    def "Create - with attributes"() {
        given:
        def attributes = ["first_name": "Mark", "last_name": "Johnson"]

        when:
        def lead = client.leads().create(attributes)

        then:
        lead.id > 0
        lead.firstName == "Mark"
        lead.lastName == "Johnson"
    }

    def "Update - with Lead entity"() {
        given:
        def lead = client.leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        lead.title = "CEO"
        def updated = client.leads().update(lead)

        then:
        updated.id == lead.id
        updated.title == "CEO"
    }

    def "Update - with attributes"() {
        given:
        def lead = client.leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def updated = client.leads().update(lead.getId(), ["title": "CEO"])

        then:
        updated.id == lead.id
        updated.title == "CEO"
    }

    def "Delete"() {
        given:
        def leadId = client.leads().create(["first_name": "Mark", "last_name": "Johnson"]).getId()

        when:
        def result = client.leads().delete(leadId)

        then:
        result
    }
}
