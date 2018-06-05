// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

class LeadUnqualifiedReasonsServiceTest extends BaseSpecification {


    def "List - with params"() {
        when:
        def leadUnqualifiedReasons = client.leadUnqualifiedReasons().list(["page": 1, "per_page": 1])

        then:
        leadUnqualifiedReasons.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def leadUnqualifiedReasons = client.leadUnqualifiedReasons().list(new LeadUnqualifiedReasonsService.SearchCriteria().page(1).perPage(1))

        then:
        leadUnqualifiedReasons.size() > 0
    }
}
