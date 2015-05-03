// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Tag

class TagsServiceTest extends BaseSpecification {

    @Shared def tag = tag ?: createTag()

  

    def "List - with params"() {
        when:
        def tags = client.tags().list(["page": 1, "per_page": 1])

        then:
        tags.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def tags = client.tags().list(new TagsService.SearchCriteria().page(1).perPage(1))

        then:
        tags.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newTag = createTag()

        then:
        newTag instanceof Tag
    }
  
  
    def "Get"() {
        given:
        def searched = tag 

        when:
        def found = client.tags().get(searched.id)

        then:
        found instanceof Tag
        found.id == searched.id
    }
  

    def "Update - with Lead entity"() {
        when:
        def updated = client.tags().update(tag)

        then:
        updated instanceof Tag
    }
  
    def "Delete"() {
        given:
        def newTag = createTag()

        when:
        def result = client.tags().delete(newTag.id)

        then:
        result
    }
}
