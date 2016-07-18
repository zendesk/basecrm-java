package com.getbase.services

import com.getbase.models.Source
import spock.lang.Shared

class LeadSourcesServiceTest extends BaseSpecification {

    @Shared def source = source ?: createLeadSource()

  

    def "List - with params"() {
        when:
        def sources = client.leadSources().list(["page": 1, "per_page": 1])

        then:
        sources.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def sources = client.leadSources().list(new LeadSourcesService.SearchCriteria().page(1).perPage(1))

        then:
        sources.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newSource = createLeadSource()

        then:
        newSource instanceof Source
    }
  
  
    def "Get"() {
        given:
        def searched = source 

        when:
        def found = client.leadSources().get(searched.id)

        then:
        found instanceof Source
        found.id == searched.id
    }
  

    def "Update - with Source entity"() {
        when:
        def updated = client.leadSources().update(source)

        then:
        updated instanceof Source
    }
  
    def "Delete"() {
        given:
        def newSource = createLeadSource()

        when:
        def result = client.leadSources().delete(newSource.id)

        then:
        result
    }

}
