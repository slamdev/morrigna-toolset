package com.github.slamdev.morrigna.toolset.integration;

import javax.enterprise.inject.Instance;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class InstanceStreamSupport {

    private InstanceStreamSupport() {
        // Utility class
    }

    public static <T> Stream<T> stream(Instance<T> instance) {
        return StreamSupport.stream(instance.spliterator(), false);
    }
}
