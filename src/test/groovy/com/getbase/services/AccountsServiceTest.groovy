// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Account

class AccountsServiceTest extends BaseSpecification {

    @Shared def account = account ?: client.accounts().self()

    
    def "Self"() {
        when:
        def account = client.accounts().self()

        then:
        account instanceof Account
        account.id > 0
    }
}
