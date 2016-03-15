package com.getbase.utils;

import java.util.ArrayList;
import java.util.List;

import static com.getbase.utils.Precondition.checkNotNull;

public class Lists {

    public static <T> List<T> asList(T[] items) {
        checkNotNull(items, "items must not be null");

        List<T> itemsList = new ArrayList<T>(items.length);
        for(T item : items) {
            itemsList.add(item);
        }

        return itemsList;
    }

}
