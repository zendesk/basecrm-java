// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Stage

class StagesServiceTest extends BaseSpecification {


  

    def "List - with params"() {
        when:
        def stages = client.stages().list(["page": 1, "per_page": 1])

        then:
        stages.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def stages = client.stages().list(new StagesService.SearchCriteria().page(1).perPage(1))

        then:
        stages.size() > 0
    }
}
