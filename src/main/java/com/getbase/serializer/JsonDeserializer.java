package com.getbase.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.getbase.exceptions.BaseError;
import com.getbase.exceptions.SerializationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JsonDeserializer {

    private JsonDeserializer(){
    }

    public static Map<String, Object> deserializeRaw(String s) {
        try {
            return JacksonProvider.getMapper().readValue(s, new TypeReference<HashMap<String, Object>>() {});
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static <T> T deserialize(String s, Class<T> type) {
        JsonNode node = null;
        try {
            node = JacksonProvider.getMapper().readTree(s).get("data");
        } catch (IOException e) {
           throw new SerializationException(e);
        }
        return JacksonProvider.getMapper().convertValue(node, type);
    }

    public static <T> T deserialize(Map<String, Object> attributes, Class<T> type) {
        return JacksonProvider.getMapper().convertValue(attributes, type);
    }

     public static <T> List<T> deserializeList(String s, Class<T> type) {
        JsonNode itemsNode = null;
        try {
            itemsNode = JacksonProvider.getMapper().readTree(s).get("items");
        } catch (IOException e) {
            throw new SerializationException(e);
        }

        List<T> items = new ArrayList<T>();
        if (itemsNode != null) {
            for (JsonNode listItemNode : itemsNode) {
                T item = JacksonProvider.getMapper().convertValue(listItemNode.get("data"), type);
                items.add(item);
            }
        }

        return items;
    }

    public static List<BaseError> deserializeErrors(String s) {
        JsonNode errorsNode = null;
        try {
            errorsNode = JacksonProvider.getMapper().readTree(s).get("errors");
        } catch (IOException e) {
            throw new SerializationException(e);
        }

        List<BaseError> errors = new ArrayList<BaseError>();
        if (errorsNode != null) {
            for (JsonNode errorNode : errorsNode) {
                BaseError error = JacksonProvider.getMapper().convertValue(errorNode.get("error"), BaseError.class);
                errors.add(error);
            }
        }

        return errors;
    }
}
