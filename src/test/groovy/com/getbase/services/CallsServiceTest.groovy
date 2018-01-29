package com.getbase.services

import com.getbase.models.Call
import spock.lang.Shared

class CallsServiceTest extends BaseSpecification {

    @Shared def call = call ?: createCall()

    def "List - with params"() {
        when:
        def calls = client.calls().list(["page": 1, "per_page": 1])

        then:
        calls.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def calls = client.calls().list(new CallsService.SearchCriteria().page(1).perPage(1))

        then:
        calls.size() > 0
    }

    def "Create and List - by ids"() {
        when:
        def callOutcome = client.callOutcomes().list(new CallOutcomesService.SearchCriteria()).first()
        def call = createCall('outcome_id' : callOutcome.id)
        def calls = client.calls().list(new CallsService.SearchCriteria().ids([call.id]))

        then:
        calls.size() == 1
        calls[0].id == call.id
    }

    def "Get"() {
        given:
        def searched = call

        when:
        def found = client.calls().get(searched.id)

        then:
        found instanceof Call
        found.id == searched.id
    }


    def "Update"() {
        when:
        def contact = createContact()
        def updated = client.calls().update(call.id, [resource_type: "contact",
                                                      "resource_id": contact.id])

        then:
        updated instanceof Call
    }

    def "Delete"() {
        given:
        def newCall = createCall()

        when:
        def result = client.calls().delete(newCall.id)

        then:
        result
    }

}
