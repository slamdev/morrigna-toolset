package com.github.slamdev.morrigna.toolset.business.dashboard;

import com.github.slamdev.morrigna.toolset.business.stats.attributes.AttributesController;
import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class DashboardController extends Controller<BorderPane> {

    @Inject
    private AttributesController attributes;

    @FXML
    private TabPane tabs;

    @FXML
    public void initialize() {
        Tab attributesTab = new Tab();
        attributesTab.setText("Attributes");
        attributesTab.setContent(attributes.getRootNode());
        tabs.getTabs().add(attributesTab);
    }
}
