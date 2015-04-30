package com.getbase.serializer;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.getbase.exceptions.BaseError;
import com.getbase.exceptions.SerializationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class JsonDeserializer {
    private static final ObjectMapper mapper;
    private static final PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy namingStrategy;

    static {
        mapper = new ObjectMapper();
        namingStrategy = new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy();

        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        mapper.registerModule(new JodaModule());
    }

    private JsonDeserializer(){
    }

    public static <T> T deserialize(String s, Class<T> type) {
        JsonNode node = null;
        try {
            node = mapper.readTree(s).get("data");
        } catch (IOException e) {
           throw new SerializationException(e);
        }
        return mapper.convertValue(node, type);
    }

     public static <T> List<T> deserializeList(String s, Class<T> type) {
        JsonNode itemsNode = null;
        try {
            itemsNode = mapper.readTree(s).get("items");
        } catch (IOException e) {
            throw new SerializationException(e);
        }

        List<T> items = new ArrayList<T>();
        if (itemsNode != null) {
            for (JsonNode listItemNode : itemsNode) {
                T item = mapper.convertValue(listItemNode.get("data"), type);
                items.add(item);
            }
        }

        return items;
    }

    public static List<BaseError> deserializeErrors(String s) {
        JsonNode errorsNode = null;
        try {
            errorsNode = mapper.readTree(s).get("errors");
        } catch (IOException e) {
            throw new SerializationException(e);
        }

        List<BaseError> errors = new ArrayList<BaseError>();
        if (errorsNode != null) {
            for (JsonNode errorNode : errorsNode) {
                BaseError error = mapper.convertValue(errorNode.get("error"), BaseError.class);
                errors.add(error);
            }
        }

        return errors;
    }
}
