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
            return String.valueOf(values.get(0));
        }

        if (on == null) {
            on = "";
        }

        StringBuilder builder = new StringBuilder();

        Iterator<? extends Object> iterator = values.iterator();
        builder.append(String.valueOf(iterator.next()));

        while(iterator.hasNext()) {
            builder
                .append(on)
                .append(String.valueOf(iterator.next()));
        }

        return builder.toString();
    }
}
