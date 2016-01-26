package com.sqli.nespresso.train.utils;

import java.util.Collection;

public final class Preconditions {

    public static void assertNotNull(Object source) {
       assertNotNull(source, "Missing the source is null !");
    }

    public static void assertNotNull(Object source, String string) {
        if (source == null)
            throw new IllegalArgumentException(string);
    }

    public static void assertNotEmpty(Collection<?> source, String string) {
        assertNotNull(source);
        if (source.isEmpty() )
            throw new IllegalArgumentException(string);
    }

    public static void assertNotEmpty(Collection<?> source) {
       assertNotEmpty(source, "The source must be not empty !");
    }

    private Preconditions() {}
}
