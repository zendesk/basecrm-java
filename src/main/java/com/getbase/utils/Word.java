package com.getbase.utils;

public abstract class Word {
    private Word() {
    }

    public static String capitalize(String underscored) {
        if (underscored == null || underscored.isEmpty()) {
            return "";
        }

        String[] parts = underscored.split("_");

        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty())
                builder.append(part.substring(0, 1).toUpperCase()  + part.substring(1));
        }

        return builder.toString().trim();
    }
}
