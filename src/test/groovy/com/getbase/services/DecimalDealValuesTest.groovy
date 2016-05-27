// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema
package com.getbase.services
class DealsDecimalValueTest extends BaseSpecification {
    def "decimal value test"() {
        given:
        def deal = createDeal([value: 100.10])
        deal.setValue(
                deal.getValue().add(new BigDecimal("10.10"))
        )
        client.deals().update(deal)
        when:
        def result = client.deals().get(deal.id)
        then:
        result.getValue() == new BigDecimal("110.20")
    }
}
