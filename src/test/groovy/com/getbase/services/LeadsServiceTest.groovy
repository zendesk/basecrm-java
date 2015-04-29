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
        new Configuration.Builder().
                verbose().
                accessToken(getAccessToken()).
                userAgent(Configuration.DEFAULT_USER_AGENT + "+tests").
                build()
    }

    def getClient() {
        new Client(getConfiguration())
    }

    def nextRand() {
        Long.toString(new Random().nextLong())
    }

    def "All - with params"() {
        given:
        getClient().leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def leads = getClient().leads().all(["page": 1, "per_page": 1])

        then:
        leads.size() > 0
    }

    def "All - with query param builder"() {
        given:
        getClient().leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def leads = getClient().leads().all(new LeadsService.QueryParamBuilder().page(1).perPage(1))

        then:
        leads.size() > 0
    }

    def "All - scopes to params"() {
        given:
        def searched = getClient().leads().create(["first_name": "Mark " + nextRand(), "last_name": "Johnson " + nextRand()])

        when:
        //getClient().leads().all().page().perPage().stream().forEach(l -> ...)
        def leads = getClient().leads().all(new LeadsService.QueryParamBuilder().
                page(1).
                perPage(1).
                firstName(searched.getFirstName()).
                lastName(searched.getLastName()))

        then:
        leads.size() == 1
        leads.first().getId() == searched.getId()
    }

    def "Get"() {
        given:
        def searched = getClient().leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def found = getClient().leads().get(searched.getId())

        then:
        found.getId() == searched.getId()
    }

    def "Create - with Lead entity"() {
        given:
        def lead = new Lead()
        lead.setFirstName("Mark")
        lead.setLastName("Johnson")

        when:
        def created = getClient().leads().create(lead)

        then:
        created.getId() > 0
        created.getFirstName() == lead.getFirstName()
        created.getLastName() == lead.getLastName()
    }

    def "Create - with attributes"() {
        given:
        def attributes = ["first_name": "Mark", "last_name": "Johnson"]

        when:
        def lead = getClient().leads().create(attributes)

        then:
        lead.getId() > 0
        lead.getFirstName() == "Mark"
        lead.getLastName() == "Johnson"
    }

    def "Update - with Lead entity"() {
        given:
        def lead = getClient().leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        lead.setTitle("CEO")
        def updated = getClient().leads().update(lead)

        then:
        updated.getId() == lead.getId()
        updated.getTitle() == "CEO"
    }

    def "Update - with attributes"() {
        given:
        def lead = getClient().leads().create(["first_name": "Mark", "last_name": "Johnson"])

        when:
        def updated = getClient().leads().update(lead.getId(), ["title": "CEO"])

        then:
        updated.getId() == lead.getId()
        updated.getTitle() == "CEO"
    }

    def "Delete"() {
        given:
        def leadId = getClient().leads().create(["first_name": "Mark", "last_name": "Johnson"]).getId()

        when:
        def result = getClient().leads().delete(leadId)

        then:
        result == true
    }
}
