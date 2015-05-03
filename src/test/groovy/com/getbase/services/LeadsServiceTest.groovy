// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Lead

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
}
