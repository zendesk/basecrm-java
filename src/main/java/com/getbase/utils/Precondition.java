package com.getbase.utils;

public abstract class Precondition {
    public static <T> T checkNotNull(T reference, String message) {
        if (reference == null) {
            throw new IllegalArgumentException(message);
        }
        return reference;
    }

    public static void checkArgument(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }
}
