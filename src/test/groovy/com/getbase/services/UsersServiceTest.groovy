// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.User

class UsersServiceTest extends BaseSpecification {

    @Shared def user = user ?: client.users().self()

  

    def "List - with params"() {
        when:
        def users = client.users().list(["page": 1, "per_page": 1])

        then:
        users.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def users = client.users().list(new UsersService.SearchCriteria().page(1).perPage(1))

        then:
        users.size() > 0
    }
  
  
    def "Get"() {
        given:
        def searched = user 

        when:
        def found = client.users().get(searched.id)

        then:
        found instanceof User
        found.id == searched.id
    }
    
    def "Self"() {
        when:
        def user = client.users().self()

        then:
        user instanceof User
        user.id > 0
    }
}
