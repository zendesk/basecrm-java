package com.getbase.http

import com.getbase.models.Address
import com.getbase.models.Lead
import com.getbase.serializer.JsonDeserializer
import org.joda.time.DateTime
import spock.lang.Specification

import static org.joda.time.DateTimeZone.UTC

class JsonDeserializerTest extends Specification {
    def "Deserialize"() {
        given:
        def json = '{"data": {"id": 1, "first_name": "Mark", "last_name": "Johnson", "organization_name": null, "address": {"line1": "2726 Smith Street"}, "tags": ["important"], "created_at": "2014-08-27T16:32:56Z", "custom_fields": {"known_via": "Tom"}}, "meta": {"type": "lead"}}'

        when:
        def lead = JsonDeserializer.deserialize(json, Lead.class)

        then:
        lead."$method"() == expectedValue

        where:
        method                  | expectedValue
        "getId"                 | 1
        "getFirstName"          | "Mark"
        "getLastName"           | "Johnson"
        "getOrganizationName"   | null
        "getTags"               | ["important"]
        "getCreatedAt"          | new DateTime(2014, 8, 27, 16, 32, 56, UTC)
        "getCustomFields"       | ["known_via": "Tom"]
        "getAddress"            | new Address("2726 Smith Street", null, null, null, null)
    }

    def "DeserializeList"() {
        when:
        def items = JsonDeserializer.deserializeList(json, expectedType)

        then:
        items.size() == expectedLen

        items.each { item ->
            assert item.class == expectedType
        }

        def idx = 0
        expectedIds.each { id ->
            assert id == items[idx].getId()
            idx++
        }

        where:
        expectedType | expectedLen | expectedIds | json
        Lead.class   | 2           | [1, 2]      | '{"items": [{"data": {"id": 1}, "meta": {"type": "lead"}}, {"data": {"id": 2}, "meta": {"type": "lead"}}], "meta": {"length": 2}}'
    }

    def "DeserializeErrors"() {
        when:
        def errors = JsonDeserializer.deserializeErrors(json)

        then:
        errors.size() == expectedLen

        def id = 0
        expectedCodes.each { code ->
            assert code == errors[id].getCode()
            id++
        }

        where:
        expectedLen | expectedCodes | json
        1           | ["blank"]     | '{"errors": [{"error": {"resource": "contact", "field": "/data/last_name", "code": "blank"}}]}'
    }
}
