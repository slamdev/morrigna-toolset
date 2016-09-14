package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.scene.layout.GridPane;

import javax.enterprise.context.Dependent;

@Dependent
public class NumberAttributeTypeController extends Controller<GridPane> implements AttributeTypeController<NumberAttributeType> {

    @Override
    public void fillValues(NumberAttributeType type) {

    }
}
