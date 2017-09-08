package com.getbase.services

import com.getbase.models.Deal
import spock.lang.Shared

class DealsServiceTest extends BaseSpecification {

    @Shared
    def deal = deal ?: createDeal()

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

    def "List - by ids"() {
        when:
        def deals = client.deals().list(new DealsService.SearchCriteria().ids([deal.id]))

        then:
        deals.size() == 1
        deals*.id == [deal.id]
    }

    def "Create - with attributes"() {
        when:
        def newDeal = createDeal()

        then:
        newDeal instanceof Deal
    }

    def "Create - with decimal value attributes"() {
        when:
        def newDeal = createDecimalDeal()

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
