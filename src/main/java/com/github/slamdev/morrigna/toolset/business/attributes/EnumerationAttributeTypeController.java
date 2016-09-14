package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import static com.github.slamdev.morrigna.toolset.business.attributes.EnumerationAttributeType.Descriptor;

@Dependent
public class EnumerationAttributeTypeController extends Controller<VBox> implements AttributeTypeController<EnumerationAttributeType> {

    @FXML
    private SplitPane descriptors;

    @Inject
    private Instance<EnumerationAttributeTypeDescriptorController> descriptorController;

    @Override
    public void fillValues(EnumerationAttributeType type) {
        type.getDescriptors().forEach(this::fillValues);
    }

    private void fillValues(Descriptor descriptor) {
        EnumerationAttributeTypeDescriptorController controller = descriptorController.get();
        descriptors.getItems().add(controller.getRootNode());
        controller.fillValues(descriptor);
    }
}
