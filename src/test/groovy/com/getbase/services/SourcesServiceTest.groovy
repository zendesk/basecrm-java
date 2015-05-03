// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Source

class SourcesServiceTest extends BaseSpecification {

    @Shared def source = source ?: createSource()

  

    def "List - with params"() {
        when:
        def sources = client.sources().list(["page": 1, "per_page": 1])

        then:
        sources.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def sources = client.sources().list(new SourcesService.SearchCriteria().page(1).perPage(1))

        then:
        sources.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newSource = createSource()

        then:
        newSource instanceof Source
    }
  
  
    def "Get"() {
        given:
        def searched = source 

        when:
        def found = client.sources().get(searched.id)

        then:
        found instanceof Source
        found.id == searched.id
    }
  

    def "Update - with Lead entity"() {
        when:
        def updated = client.sources().update(source)

        then:
        updated instanceof Source
    }
  
    def "Delete"() {
        given:
        def newSource = createSource()

        when:
        def result = client.sources().delete(newSource.id)

        then:
        result
    }
}
