package com.getbase.services

import com.getbase.models.Order
import spock.lang.Shared

class OrdersServiceTest extends BaseSpecification {

    @Shared
    def order = order ?: createOrder()

    def "List - with params"() {
        when:
        def orders = client.orders().list(["page": 1, "per_page": 1])

        then:
        orders.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def orders = client.orders().list(new OrdersService.SearchCriteria().page(1).perPage(100))

        then:
        orders.size() > 0
    }

    def "List - by ids"() {
        when:
        def orders = client.orders().list(new OrdersService.SearchCriteria().ids([order.id]))

        then:
        orders.size() == 1
        orders[0].id == order.id
    }

    def "Create - with attributes"() {
        when:
        def newOrder = createOrder()

        then:
        newOrder instanceof Order
    }

    def "Get"() {
        given:
        def searched = order

        when:
        def found = client.orders().get(order.id)

        then:
        found instanceof Order
        found.id == searched.id
    }

    def "Update"() {
        when:
        order.discount = 15
        def updated = client.orders().update(order)

        then:
        updated instanceof Order
    }

    def "Delete"() {
        given:
        def newOrder = createOrder()

        when:
        def result = client.orders().delete(newOrder.id)

        then:
        result
    }

    def cleanupSpec() {
        deleteAllOrders()
    }

}
