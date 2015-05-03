// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Contact

class ContactsServiceTest extends BaseSpecification {

    @Shared def contact = contact ?: createContact()

  

    def "List - with params"() {
        when:
        def contacts = client.contacts().list(["page": 1, "per_page": 1])

        then:
        contacts.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def contacts = client.contacts().list(new ContactsService.SearchCriteria().page(1).perPage(1))

        then:
        contacts.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newContact = createContact()

        then:
        newContact instanceof Contact
    }
  
  
    def "Get"() {
        given:
        def searched = contact 

        when:
        def found = client.contacts().get(searched.id)

        then:
        found instanceof Contact
        found.id == searched.id
    }
  

    def "Update - with Lead entity"() {
        when:
        def updated = client.contacts().update(contact)

        then:
        updated instanceof Contact
    }
  
    def "Delete"() {
        given:
        def newContact = createContact()

        when:
        def result = client.contacts().delete(newContact.id)

        then:
        result
    }
}
