// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Pipeline

class PipelinesServiceTest extends BaseSpecification {


  

    def "List - with params"() {
        when:
        def pipelines = client.pipelines().list(["page": 1, "per_page": 1])

        then:
        pipelines.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def pipelines = client.pipelines().list(new PipelinesService.SearchCriteria().page(1).perPage(1))

        then:
        pipelines.size() > 0
    }
}
