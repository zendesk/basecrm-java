package com.getbase.services

import com.getbase.models.AssociatedContact
import spock.lang.Shared

class AssociatedContactsServiceTest extends BaseSpecification {

    @Shared def associatedContact = associatedContact ?: createAssociatedContact()

    def "List - with params"() {
        when:
        def associatedContacts = client.associatedContacts().list(associatedContact.dealId, ["page": 1, "per_page": 1])

        then:
        associatedContacts.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def associatedContacts = client.associatedContacts().list(associatedContact.dealId, new AssociatedContactsService.SearchCriteria().page(1).perPage(1))

        then:
        associatedContacts.size() > 0
    }

    def "Create - with attributes"() {
        when:
        def newAssociatedContact = createAssociatedContact()

        then:
        newAssociatedContact instanceof AssociatedContact
    }

    def "Delete"() {
        given:
        def newAssociatedContact = createAssociatedContact()

        when:
        def result = client.associatedContacts().delete(newAssociatedContact.dealId, newAssociatedContact.contactId)

        then:
        result
    }

}
