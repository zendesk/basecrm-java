// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.TextMessage

class TextMessagesServiceTest extends BaseSpecification {

    def "List - with params"() {
        when:
        def textMessages = client.textMessages().list(["page": 1, "per_page": 1])

        then:
        assert textMessages instanceof List<TextMessage>
    }

    def "List - with query param builder"() {
        when:
        def textMessages = client.textMessages().list(new TextMessagesService.SearchCriteria().page(1).perPage(1))

        then:
        assert textMessages instanceof List<TextMessage>
    }
}
