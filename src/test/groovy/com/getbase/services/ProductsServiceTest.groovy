// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services

import spock.lang.Shared

import com.getbase.models.Product

class ProductsServiceTest extends BaseSpecification {

    @Shared def product = product ?: createProduct()


    def "List - with params"() {
        when:
        def products = client.products().list(["page": 1, "per_page": 1])

        then:
        products.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def products = client.products().list(new ProductsService.SearchCriteria().page(1).perPage(1))

        then:
        products.size() > 0
    }
  
    def "Create - with attributes"() {
        when:
        def newProduct = createProduct()

        then:
        newProduct instanceof Product
    }
  
  
    def "Get"() {
        given:
        def searched = product 

        when:
        def found = client.products().get(searched.id)

        then:
        found instanceof Product
        found.id == searched.id
    }
  

    def "Update - with Lead entity"() {
        when:
        def updated = client.products().update(product)

        then:
        updated instanceof Product
    }
  
    def "Delete"() {
        given:
        def newProduct = createProduct()

        when:
        def result = client.products().delete(newProduct.id)

        then:
        result
    }
}
