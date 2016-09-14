package com.github.slamdev.morrigna.toolset.integration;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

import static java.util.Arrays.stream;

public final class ReflectionUtil {

    private ReflectionUtil() {
        // Utility class
    }

    public static boolean hasGenericType(Object object, Object generic) {
        return hasGenericType(object.getClass(), generic.getClass());
    }

    public static boolean hasGenericType(Class type, Class generic) {
        return stream(type.getGenericInterfaces())
                .filter(i -> i instanceof ParameterizedType)
                .map(i -> (ParameterizedType) i)
                .map(ParameterizedType::getActualTypeArguments)
                .flatMap(Arrays::stream)
                .anyMatch(generic::equals);
    }
}
