package com.github.slamdev.morrigna.toolset.integration;

import javafx.scene.Parent;

public interface HasRootNode<T extends Parent> {

    T getRootNode();
}
