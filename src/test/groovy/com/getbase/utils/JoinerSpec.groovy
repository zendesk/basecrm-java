package com.getbase.utils

import spock.lang.Specification
import spock.lang.Unroll


@Unroll
class JoinerSpec extends Specification {

    def "handles null/empty values"() {
        expect:
        Joiner.join(on, data) == joinedString

        where:
        on      | data                    | joinedString
        ";"     | null                    | ""
        ";"     | []                      | ""
        ";"     | [null]                  | "null"
        ";"     | [null, "E1"]            | "null;E1"
        ";"     | [null, null, "E1"]      | "null;null;E1"
        null    | null                    | ""
        null    | []                      | ""
        null    | [null]                  | "null"
        null    | [null, "E1"]            | "nullE1"
        null    | [null, null, "E1"]      | "nullnullE1"
    }

}
