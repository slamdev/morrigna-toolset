package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.HasRootNode;

public interface AttributeTypeController<T extends AttributeType> extends HasRootNode {

    void fillValues(T type);
}
