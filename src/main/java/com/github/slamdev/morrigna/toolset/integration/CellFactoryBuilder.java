package com.github.slamdev.morrigna.toolset.integration;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

public final class CellFactoryBuilder {

    private CellFactoryBuilder() {
        // Utility class
    }

    public static <T> Callback<ListView<T>, ListCell<T>> withProperty(Function<T, String> propertyAccessor) {
        return param -> new PropertyListCell<T>(propertyAccessor);
    }

    @RequiredArgsConstructor
    private static class PropertyListCell<T> extends ListCell<T> {

        private final Function<T, String> propertyAccessor;

        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(propertyAccessor.apply(item));
            }
        }
    }
}
