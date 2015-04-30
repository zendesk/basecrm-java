package com.getbase.serializer;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.getbase.exceptions.SerializationException;

public abstract class JsonSerializer {

    private JsonSerializer(){
    }

    public static String serialize(Object entity, Class<?> viewClass) {
        try {
            return JacksonProvider.getMapper().writerWithView(viewClass).writeValueAsString(new Envelope(entity));
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    public static String serialize(Object entity) {
        try {
            return JacksonProvider.getMapper().writeValueAsString(new Envelope(entity));
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
