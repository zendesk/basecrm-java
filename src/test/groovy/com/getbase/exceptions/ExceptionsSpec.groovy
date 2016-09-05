package com.getbase.exceptions

import com.getbase.http.HttpMethod
import spock.lang.Specification
import spock.lang.Unroll


class ExceptionsSpec extends Specification {

    @Unroll
    def 'exception string for #exception.class contains detailed message'() {
        expect:
        exception.getMessage() == expected

        where:
        exception                                                                               | expected
        new RequestException(401, "logref", HttpMethod.GET, "/v2/contact", [ baseError() ])     | "httpStatus=401, logref='logref', httpMethod=GET, url=/v2/contact, errors=BaseError{code='111', message='error message', details='error details', resource='error resource', field='null'}"
        new ResourceException(422, "logref", HttpMethod.GET, "/v2/contact", [ baseError() ])    | "httpStatus=422, logref='logref', httpMethod=GET, url=/v2/contact, errors=BaseError{code='111', message='error message', details='error details', resource='error resource', field='null'}"
        new ServerException(506, "logref", HttpMethod.GET, "/v2/contact", [ baseError() ])      | "httpStatus=506, logref='logref', httpMethod=GET, url=/v2/contact, errors=BaseError{code='111', message='error message', details='error details', resource='error resource', field='null'}"
    }

    def baseError() {
        def error = new BaseError()
        error.code = 111
        error.details = 'error details'
        error.message = 'error message'
        error.resource = 'error resource'
        error
    }

}
