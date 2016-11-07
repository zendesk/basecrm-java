package com.getbase.services

import com.getbase.models.LineItem
import com.getbase.models.Order
import spock.lang.Shared

class LineItemsServiceTest extends BaseSpecification {

    @Shared def order = order ?: createOrder()
    @Shared def lineItem = lineItem ?: createLineItem(order)

    def "List - with params"() {
        when:
        def lineItems = client.lineItems().list(order.id, ["page": 1, "per_page": 1])

        then:
        lineItems.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def lineItems = client.lineItems().list(order.id, new LineItemsService.SearchCriteria().page(1).perPage(1))

        then:
        lineItems.size() > 0

        when:
        lineItems = client.lineItems().list(order.id, new LineItemsService.SearchCriteria().page(2).perPage(1))

        then:
        lineItems.size() == 0
    }

    def "List - by ids"() {
        given:
        def lineItemsIds = (0..3).collect { createLineItem(order) }*.id

        when:
        def lineItems = client.lineItems().list(order.id, new LineItemsService.SearchCriteria().ids(lineItemsIds))

        then:
        lineItems.size() == 4
        lineItems*.id == lineItemsIds
    }

    def "Create - with attributes"() {
        when:
        def newLineItem = createLineItem()

        then:
        newLineItem instanceof LineItem
    }

    def "Get"() {
        given:
        def searched = lineItem

        when:
        def found = client.lineItems().get(order.id, lineItem.id)

        then:
        found instanceof LineItem
        found.id == searched.id
    }

    def "Delete"() {
        given:
        def newLineItem = createLineItem(order)

        when:
        def result = client.lineItems().delete(order.id, newLineItem.id)

        then:
        result
    }

    def cleanupSpec() {
        deleteAllOrders()
    }

    private List<Order> deleteAllOrders() {
        client.orders().list(new OrdersService.SearchCriteria().page(1).perPage(100)).each { order ->
            deleteLineItemsForOrder(order)
            client.orders().delete(order.id)
        }
    }

    def deleteLineItemsForOrder(Order order) {
        client.lineItems().list(order.id, new LineItemsService.SearchCriteria().page(1).page(100)).each { lineItem ->
            client.lineItems().delete(order.id, lineItem.id)
        }
    }

}
