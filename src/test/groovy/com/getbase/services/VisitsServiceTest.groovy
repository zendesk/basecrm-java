// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Visit

class VisitsServiceTest extends BaseSpecification {

    def "List - with params"() {
        when:
        def visits = client.visits().list(["page": 1, "per_page": 1])

        then:
        assert visits instanceof List<Visit>
    }

    def "List - with query param builder"() {
        when:
        def visits = client.visits().list(new VisitsService.SearchCriteria().page(1).perPage(1))

        then:
        assert visits instanceof List<Visit>
    }
}
