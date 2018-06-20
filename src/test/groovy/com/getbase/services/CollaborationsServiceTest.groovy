package com.getbase.services

import com.getbase.models.Collaboration
import spock.lang.Shared

class CollaborationsServiceTest extends BaseSpecification {

    @Shared
    def collaboration = collaboration ?: createCollaboration()

    def "List - with params"() {
        when:
        def collaborations = client.collaborations().list(["page": 1, "per_page": 1])

        then:
        collaborations.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def collaborations = client.collaborations().list(new CollaborationsService.SearchCriteria().page(1).perPage(100))

        then:
        collaborations.size() > 0

        when:
        collaborations = client.collaborations().list(new CollaborationsService.SearchCriteria().page(2).perPage(100))

        then:
        collaborations.size() == 0
    }

    def "List - by ids"() {
        when:
        def collaborations = client.collaborations().list(new CollaborationsService.SearchCriteria().ids([collaboration.id]))

        then:
        collaborations.size() == 1
        collaborations[0].id == collaboration.id
    }

    def "Create"() {
        when:
        def newCollaboration = createCollaboration()

        then:
        newCollaboration instanceof Collaboration
    }

    def "Get"() {
        given:
        def searched = collaboration

        when:
        def found = client.collaborations().get(collaboration.id)

        then:
        found instanceof Collaboration
        found.id == searched.id
    }

    def "Delete"() {
        given:
        def newCollaboration = createCollaboration()

        when:
        def result = client.collaborations().delete(newCollaboration.id)

        then:
        result
    }

}
