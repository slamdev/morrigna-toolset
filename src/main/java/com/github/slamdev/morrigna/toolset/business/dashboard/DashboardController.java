package com.github.slamdev.morrigna.toolset.business.dashboard;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.io.IOException;

import static java.lang.Character.toLowerCase;

@Dependent
public class DashboardController implements Controller {

    private Parent rootNode;

    @PostConstruct
    public void init() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Class<?> type = getClass();
        String template = "/fxml/%s/%s.fxml";
        loader.setLocation(type.getResource(
                String.format(
                        template,
                        type.getPackage().getName().replaceAll("\\.", "/"),
                        toLowerCase(type.getSimpleName().charAt(0)) + type.getSimpleName().substring(1).replace("Controller", "")
                )
        ));
        loader.setController(this);
        rootNode = loader.load();
    }

    @FXML
    public void initialize() {
    }

    @Override
    public Parent getRootNode() {
        return rootNode;
    }
}
