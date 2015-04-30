package com.getbase.serializer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.getbase.exceptions.SerializationException;

public abstract class JsonSerializer {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        mapper.registerModule(new JodaModule());
    }

    private JsonSerializer(){
    }

    public static String serialize(Object entity, Class<?> viewClass) {
        try {
            return mapper.writerWithView(viewClass).writeValueAsString(new Envelope(entity));
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    public static String serialize(Object entity) {
        try {
            return mapper.writeValueAsString(new Envelope(entity));
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    static class Envelope {
        @JsonView(Views.ReadWrite.class)
        Object data;

        Envelope(Object entity) {
            this.data = entity;
        }
    }
}
