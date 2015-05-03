// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Deal

class DealsServiceTest extends BaseSpecification {

    @Shared def deal = deal ?: createDeal()

  

    def "List - with params"() {
        when:
        def deals = client.deals().list(["page": 1, "per_page": 1])

        then:
        deals.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def deals = client.deals().list(new DealsService.SearchCriteria().page(1).perPage(1))

        then:
        deals.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newDeal = createDeal()

        then:
        newDeal instanceof Deal
    }
  
  
    def "Get"() {
        given:
        def searched = deal 

        when:
        def found = client.deals().get(searched.id)

        then:
        found instanceof Deal
        found.id == searched.id
    }
  

    def "Update - with Lead entity"() {
        when:
        def updated = client.deals().update(deal)

        then:
        updated instanceof Deal
    }
  
    def "Delete"() {
        given:
        def newDeal = createDeal()

        when:
        def result = client.deals().delete(newDeal.id)

        then:
        result
    }
}
