package com.getbase.services

import com.getbase.models.LossReason
import spock.lang.Shared

class LossReasonsServiceTest extends BaseSpecification {

    @Shared def lossReason = lossReason ?: createLossReason()

    def "List - with params"() {
        when:
        def lossReasons = client.lossReasons().list(["page": 1, "per_page": 1])

        then:
        lossReasons.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def lossReasons = client.lossReasons().list(new LossReasonsService.SearchCriteria().page(1).perPage(1))

        then:
        lossReasons.size() > 0
    }

    def "List - by ids"() {
        given:
        def lossReasonsIds = (0..3).collect { createLossReason() }*.id

        when:
        def lossReasons = client.lossReasons().list(new LossReasonsService.SearchCriteria().ids(lossReasonsIds))

        then:
        lossReasons.size() == 4
        lossReasons*.id == lossReasonsIds
    }

    def "Create - with attributes"() {
        when:
        def newLossReason = createLossReason()

        then:
        newLossReason instanceof LossReason
    }

    def "Get"() {
        given:
        def searched = lossReason

        when:
        def found = client.lossReasons().get(searched.id)

        then:
        found instanceof LossReason
        found.id == searched.id
    }

    def "Update - with Lead entity"() {
        when:
        def updated = client.lossReasons().update(lossReason)

        then:
        updated instanceof LossReason
    }

    def "Delete"() {
        given:
        def newLossReason = createLossReason()

        when:
        def result = client.lossReasons().delete(newLossReason.id)

        then:
        result
    }

}
