package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Arrays;

import static com.github.slamdev.morrigna.toolset.integration.CellFactoryBuilder.withProperty;

@Dependent
public class AttributesController extends Controller<HBox> {

    @FXML
    private ListView<Attribute> attributes;

    @Inject
    private Instance<AttributeController> attributeController;

    @FXML
    private ScrollPane attributePane;

    @FXML
    public void initialize() {
        attributes.getItems().addAll(Arrays.asList(
                Attribute.builder()
                        .refId("strAttr")
                        .code("STR")
                        .name("Strength")
                        .description("A measure of how physically strong a character is. Strength often controls the maximum weight the character can carry, melee attack and/or damage, and sometimes hit points. Armor and weapons might also have a Strength requirement.")
                        .type(NumberAttributeType.builder().minValue(0).maxValue(99).build())
                        .build(),
                Attribute.builder()
                        .refId("classAttr")
                        .code("CLS")
                        .name("Class")
                        .description("A player class.")
                        .type(EnumerationAttributeType.builder()
                                .descriptor(EnumerationAttributeType.Descriptor.builder().code("WAR").name("Warrior").description("Fighting class").tag("WAR_CLASS").tag("WAR").build())
                                .descriptor(EnumerationAttributeType.Descriptor.builder().code("MAG").name("Mage").description("Spell caster class").tag("MAG_CLASS").build())
                                .build()
                        )
                        .build(),
                Attribute.builder()
                        .refId("hpAttr")
                        .code("HP")
                        .name("Health")
                        .description("Health points.")
                        .type(NumberAttributeType.builder().minValue(0).maxValue(Double.MAX_VALUE).build())
                        .calculationScript("some fancy javascript")
                        .build()
        ));
        attributes.setCellFactory(withProperty(Attribute::getName));
        attributes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showAttributeForm(newValue));
    }

    private void showAttributeForm(Attribute value) {
        AttributeController attribute = attributeController.get();
        attributePane.setContent(attribute.getRootNode());
        attribute.fillValues(value);
    }
}
