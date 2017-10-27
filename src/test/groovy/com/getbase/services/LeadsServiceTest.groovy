package com.getbase.services

import com.getbase.models.Lead
import spock.lang.Shared

class LeadsServiceTest extends BaseSpecification {

    @Shared def lead = lead ?: createLead()

    def "List - with params"() {
        when:
        def leads = client.leads().list(["page": 1, "per_page": 1])

        then:
        leads.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def leads = client.leads().list(new LeadsService.SearchCriteria().page(1).perPage(1))

        then:
        leads.size() > 0
    }

    def "List - by ids"() {
        when:
        sleep(1000)
        def leads = client.leads().list(new LeadsService.SearchCriteria().ids([lead.id]))

        then:
        leads.size() == 1
        leads*.id == [lead.id]
    }

    def "Create - with attributes"() {
        when:
        def newLead = createLead()

        then:
        newLead instanceof Lead
    }

    def "Get"() {
        given:
        def searched = lead

        when:
        def found = client.leads().get(searched.id)

        then:
        found instanceof Lead
        found.id == searched.id
    }

    def "Update - with Lead entity"() {
        when:
        def updated = client.leads().update(lead)

        then:
        updated instanceof Lead
    }

    def "Delete"() {
        given:
        def newLead = createLead()

        when:
        def result = client.leads().delete(newLead.id)

        then:
        result
    }

    def "Lead source setting"() {
        given:
        def lead = createLead()
        def leadSource = createLeadSource()

        when:
        lead.sourceId = leadSource.id
        client.leads().update(lead)

        then:
        client.leads().get(lead.id).sourceId == leadSource.id
    }

}
