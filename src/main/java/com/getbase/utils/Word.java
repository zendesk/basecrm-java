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
                builder.append(part.toUpperCase());
        }

        return builder.toString().trim();
    }
}
