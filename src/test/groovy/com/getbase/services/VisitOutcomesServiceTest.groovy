// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.VisitOutcome

class VisitOutcomesServiceTest extends BaseSpecification {

    def "List - with params"() {
        when:
        def visitOutcomes = client.visitOutcomes().list(["page": 1, "per_page": 1])

        then:
        assert visitOutcomes instanceof List<VisitOutcome>
    }

    def "List - with query param builder"() {
        when:
        def visitOutcomes = client.visitOutcomes().list(new VisitOutcomesService.SearchCriteria().page(1).perPage(1))

        then:
        assert visitOutcomes instanceof List<VisitOutcome>
    }
}
