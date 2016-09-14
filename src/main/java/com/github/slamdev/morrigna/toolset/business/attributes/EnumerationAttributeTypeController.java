package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.scene.layout.GridPane;

import javax.enterprise.context.Dependent;

@Dependent
public class EnumerationAttributeTypeController extends Controller<GridPane> implements AttributeTypeController<EnumerationAttributeType> {

    @Override
    public void fillValues(EnumerationAttributeType type) {
        // TODO: implement
    }
}
