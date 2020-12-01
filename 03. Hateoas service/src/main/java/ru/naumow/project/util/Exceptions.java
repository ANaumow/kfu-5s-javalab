package ru.naumow.project.util;

import java.util.function.Supplier;

public class Exceptions {

    public static Supplier<? extends RuntimeException> notFound(String entityName) {
        return () -> new IllegalArgumentException(entityName + " not found");
    }

}
