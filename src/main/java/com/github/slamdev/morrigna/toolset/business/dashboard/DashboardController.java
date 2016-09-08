package com.github.slamdev.morrigna.toolset.business.dashboard;

import com.github.slamdev.morrigna.toolset.integration.RegionResizer;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class DashboardController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane anchorLeft;

    @FXML
    public void initialize() {
//        new RegionResizer().enableResizing(anchorLeft);
    }

}
