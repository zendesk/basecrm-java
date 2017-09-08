package com.getbase.services

import com.getbase.models.Account
import spock.lang.Shared

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
