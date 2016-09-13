package com.github.slamdev.morrigna.toolset.business.attributes;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import javax.enterprise.context.Dependent;
import java.util.Arrays;

@Dependent
public class AttributesController extends Controller<HBox> {

    @FXML
    private ListView<Attribute> attributes;

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
                                .descriptor(EnumerationAttributeType.Descriptor.builder().code("WAR").name("Warrior").description("Fighting class").build())
                                .descriptor(EnumerationAttributeType.Descriptor.builder().code("MAG").name("Mage").description("Spell caster class").build())
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
        attributes.setCellFactory(param -> new AttributeListCell());
    }

    private static class AttributeListCell extends ListCell<Attribute> {
        @Override
        protected void updateItem(Attribute item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null || item.getName() == null) {
                setText(null);
            } else {
                setText(item.getName());
            }
        }
    }
}
