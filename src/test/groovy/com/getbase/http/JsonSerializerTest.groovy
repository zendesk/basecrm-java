package com.getbase.http

import com.fasterxml.jackson.annotation.JsonView
import com.getbase.models.Lead
import com.getbase.serializer.Views
import com.getbase.serializer.JsonSerializer
import spock.lang.Specification


class JsonSerializerTest extends Specification {
    static class Tag {
        @JsonView(Views.ReadOnly.class) long id;
        @JsonView(Views.ReadWrite.class) String name;

        Tag(long id, String name) {
            this.id = id
            this.name = name
        }

        long getId() {
            return id
        }

        void setId(long id) {
            this.id = id
        }

        String getName() {
            return name
        }

        void setName(String name) {
            this.name = name
        }

    }

    def "Serialize - serializes entity"() {
        given:
        def tag = new Tag(1, "important")

        when:
        def json = JsonSerializer.serialize(tag, Views.ReadWrite.class)

        then:
        json == '{"data":{"name":"important"}}'
    }

    def "Serialize - entity with lots of attributes"() {
        given:
        def lead = new Lead()
        lead.firstName = "Mark"
        lead.lastName = "Johnson"

        when:
        def json = JsonSerializer.serialize(lead, Views.ReadWrite.class)

        then:
        json == '{"data":{"first_name":"Mark","last_name":"Johnson"}}'
    }

    def "Serialize - HashMap attributes"() {
        given:
        def attributes = ["id": 1, "name": "important"]

        when:
        def json = JsonSerializer.serialize(attributes)

        then:
        json == '{"data":{"id":1,"name":"important"}}'
    }
}
