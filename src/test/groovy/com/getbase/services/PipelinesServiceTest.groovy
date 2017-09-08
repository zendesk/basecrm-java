package com.getbase.services

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

    def "List - by ids"() {
        given:
        def pipelinesIds = client.pipelines().list(["page": 1])*.id

        when:
        def pipelines = client.pipelines().list(new PipelinesService.SearchCriteria().ids(pipelinesIds))

        then:
        pipelines.size() == pipelinesIds.size()
        pipelines*.id == pipelinesIds
    }

}
