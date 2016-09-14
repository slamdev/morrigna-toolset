package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.enterprise.context.Dependent;

import static com.github.slamdev.morrigna.toolset.business.attributes.EnumerationAttributeType.Descriptor;

@Dependent
public class EnumerationAttributeTypeDescriptorController extends Controller<GridPane> {

    @FXML
    private TextField codeField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField tagsField;

    public void fillValues(Descriptor descriptor) {
        codeField.setText(descriptor.getCode());
        nameField.setText(descriptor.getName());
        descriptionField.setText(descriptor.getDescription());
        tagsField.setText(String.join(", ", descriptor.getTags()));
    }
}
