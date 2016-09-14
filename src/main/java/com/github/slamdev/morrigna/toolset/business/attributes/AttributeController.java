package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import static com.github.slamdev.morrigna.toolset.integration.InstanceStreamSupport.stream;
import static com.github.slamdev.morrigna.toolset.integration.ReflectionUtil.hasGenericType;
import static java.util.stream.Collectors.toList;

@Dependent
public class AttributeController extends Controller<GridPane> {

    @Inject
    private Instance<AttributeTypeController<?>> attributeTypeControllers;

    @Inject
    private Instance<AttributeType> attributeTypes;

    @FXML
    private TextField refIdField;

    @FXML
    private TextField codeField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ComboBox<AttributeTypeContainer> types;

    @FXML
    private AnchorPane typeForm;

    @FXML
    public void initialize() {
        types.valueProperty().addListener((observable, oldValue, newValue) -> showAttributeTypeForm(newValue));
        types.getItems().addAll(stream(attributeTypes).map(AttributeTypeContainer::new).collect(toList()));
    }

    @SuppressWarnings("unchecked")
    private void showAttributeTypeForm(AttributeTypeContainer type) {
        AttributeTypeController controller = stream(attributeTypeControllers)
                .filter(e -> hasGenericType(e, type.getType()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        typeForm.getChildren().clear();
        typeForm.getChildren().add(controller.getRootNode());
        controller.fillValues(type.getType());
    }

    public void fillValues(Attribute attribute) {
        refIdField.setText(attribute.getRefId());
        codeField.setText(attribute.getCode());
        nameField.setText(attribute.getName());
        descriptionField.setText(attribute.getDescription());
        types.getSelectionModel().select(findFromSelect(attribute.getType()));
    }

    private AttributeTypeContainer findFromSelect(AttributeType type) {
        return types.getItems().stream()
                .filter(c -> c.getCode().equals(type.getCode()))
                .peek(c -> c.setType(type))
                .findAny().orElse(new AttributeTypeContainer(type));
    }

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode(of = "code")
    private static class AttributeTypeContainer {

        private AttributeType type;
        private String code;

        public AttributeTypeContainer(AttributeType type) {
            this(type, type.getCode());
        }

        @Override
        public String toString() {
            return code;
        }
    }
}
