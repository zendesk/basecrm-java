package com.getbase.services

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

    def "List - by ids"() {
        given:
        def stagesIds = client.stages().list(["page": 1])*.id

        when:
        def stages = client.stages().list(new StagesService.SearchCriteria().ids(stagesIds))

        then:
        stages.size() == stagesIds.size()
        stages*.id == stagesIds
    }

}
