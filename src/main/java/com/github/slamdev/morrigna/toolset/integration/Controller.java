package com.github.slamdev.morrigna.toolset.integration;

import javafx.scene.Parent;

import javax.inject.Inject;
import java.util.function.Supplier;

import static com.github.slamdev.morrigna.toolset.integration.LazySupplier.lazily;

public abstract class Controller<T extends Parent> implements HasRootNode {

    @Inject
    private FXMLTypedLoader loader;

    private Supplier<T> rootNode = lazily(this::initRootNode);

    private T initRootNode() {
        return loader.load(this);
    }

    @Override
    public T getRootNode() {
        return rootNode.get();
    }
}
