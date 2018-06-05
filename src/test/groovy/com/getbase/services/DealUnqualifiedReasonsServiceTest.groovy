// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import com.getbase.models.DealUnqualifiedReason
import spock.lang.Shared

class DealUnqualifiedReasonsServiceTest extends BaseSpecification {

    @Shared def dealUnqualifiedReason = dealUnqualifiedReason ?: createDealUnqualifiedReason()


    def "List - with params"() {
        when:
        def dealUnqualifiedReasons = client.dealUnqualifiedReasons().list(["page": 1, "per_page": 1])

        then:
        dealUnqualifiedReasons.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def dealUnqualifiedReasons = client.dealUnqualifiedReasons().list(new DealUnqualifiedReasonsService.SearchCriteria().page(1).perPage(1))

        then:
        dealUnqualifiedReasons.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newDealUnqualifiedReason = createDealUnqualifiedReason()

        then:
        newDealUnqualifiedReason instanceof DealUnqualifiedReason
    }
  
  
    def "Get"() {
        given:
        def searched = dealUnqualifiedReason 

        when:
        def found = client.dealUnqualifiedReasons().get(searched.id)

        then:
        found instanceof DealUnqualifiedReason
        found.id == searched.id
    }
  

    def "Update - with Lead entity"() {
        when:
        def updated = client.dealUnqualifiedReasons().update(dealUnqualifiedReason)

        then:
        updated instanceof DealUnqualifiedReason
    }
  
    def "Delete"() {
        given:
        def newDealUnqualifiedReason = createDealUnqualifiedReason()

        when:
        def result = client.dealUnqualifiedReasons().delete(newDealUnqualifiedReason.id)

        then:
        result
    }
}
