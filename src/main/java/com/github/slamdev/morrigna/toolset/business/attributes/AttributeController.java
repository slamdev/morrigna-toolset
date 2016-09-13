package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.enterprise.context.Dependent;

@Dependent
public class AttributeController extends Controller<GridPane> {

    @FXML
    private TextField refIdField;

    @FXML
    private TextField codeField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    public void fillValues(Attribute attribute) {
        refIdField.setText(attribute.getRefId());
        codeField.setText(attribute.getCode());
        nameField.setText(attribute.getName());
        descriptionField.setText(attribute.getDescription());
    }
}
