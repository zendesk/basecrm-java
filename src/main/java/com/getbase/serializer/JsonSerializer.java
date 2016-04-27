package com.getbase.serializer;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.getbase.exceptions.SerializationException;

import java.util.HashMap;
import java.util.Map;

public abstract class JsonSerializer {

    private JsonSerializer(){
    }

    public static String serialize(Object entity, Class<?> viewClass) {
        return serialize(entity, viewClass, null);
    }

    public static String serialize(Object entity) {
        return serialize(entity, null, null);
    }

    public static String serialize(Object entity, String typeName) {
        return serialize(entity, null, typeName);
    }

    public static String serialize(Object entity, Class<?> viewClass, String typeName) {
        try {
            Envelope envelope = typeName == null ?
                    new Envelope(entity) :
                    new MetaEnvelope(entity, typeName);

            return getObjectWriter(viewClass).writeValueAsString(envelope);

        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    private static ObjectWriter getObjectWriter(Class<?> viewClass) {
        return viewClass == null ?
                JacksonProvider.getMapper().writer() :
                JacksonProvider.getMapper().writerWithView(viewClass);
    }

    static class Envelope {
        @JsonView(Views.ReadWrite.class)
        Object data;

        Envelope(Object entity) {
            this.data = entity;
        }
    }

    static class MetaEnvelope extends Envelope{
        @JsonView(Views.ReadWrite.class)
        Map meta = new HashMap<String, String>(1);

        MetaEnvelope(Object entity, String type) {
            super(entity);
            meta.put("type", type);

        }
    }

}
