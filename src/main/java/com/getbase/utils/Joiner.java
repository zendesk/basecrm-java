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

        if (on == null) on = "";

        StringBuilder builder = new StringBuilder();

        Iterator<? extends Object> iterator = values.iterator();
        builder.append(iterator.next().toString());

        while(iterator.hasNext()) {
            Object o = iterator.next();
            builder.append(on).append(o == null ? "null" : o.toString());
        }

        return builder.toString();
    }
}
