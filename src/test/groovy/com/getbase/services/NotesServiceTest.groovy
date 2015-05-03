// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Note

class NotesServiceTest extends BaseSpecification {

    @Shared def note = note ?: createNote()

  

    def "List - with params"() {
        when:
        def notes = client.notes().list(["page": 1, "per_page": 1])

        then:
        notes.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def notes = client.notes().list(new NotesService.SearchCriteria().page(1).perPage(1))

        then:
        notes.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newNote = createNote()

        then:
        newNote instanceof Note
    }
  
  
    def "Get"() {
        given:
        def searched = note 

        when:
        def found = client.notes().get(searched.id)

        then:
        found instanceof Note
        found.id == searched.id
    }
  

    def "Update - with Lead entity"() {
        when:
        def updated = client.notes().update(note)

        then:
        updated instanceof Note
    }
  
    def "Delete"() {
        given:
        def newNote = createNote()

        when:
        def result = client.notes().delete(newNote.id)

        then:
        result
    }
}
