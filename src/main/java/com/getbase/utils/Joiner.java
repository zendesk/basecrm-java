package com.getbase.utils;

import java.util.Iterator;
import java.util.List;

public abstract class Joiner {
    private Joiner() {
    }

    public static String join(String on, List<? extends Object> values) {
        if (values == null || values.isEmpty()) {
            return "";
        }

        if (values.size() == 1) {
            return values.get(0).toString();
        }

        StringBuilder builder = new StringBuilder();

        Iterator<? extends Object> iterator = values.iterator();
        builder.append(iterator.next().toString());

        while(iterator.hasNext()) {
            builder.append(on).append(iterator.next().toString());
        }

        return builder.toString();
    }
}
