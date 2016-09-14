package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.enterprise.context.Dependent;

@Dependent
public class NumberAttributeTypeController extends Controller<GridPane> implements AttributeTypeController<NumberAttributeType> {

    @FXML
    private TextField minValueField;

    @FXML
    private TextField maxValueField;

    @Override
    public void fillValues(NumberAttributeType type) {
        minValueField.setText(String.valueOf(type.getMinValue()));
        maxValueField.setText(String.valueOf(type.getMaxValue()));
    }
}
