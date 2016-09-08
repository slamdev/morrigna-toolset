package com.github.slamdev.morrigna.toolset;

import com.github.slamdev.morrigna.toolset.business.OpenCampaignController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;

import java.io.IOException;

import static java.lang.Character.toLowerCase;
import static java.lang.Thread.setDefaultUncaughtExceptionHandler;
import static org.slf4j.LoggerFactory.getLogger;

public class ToolsetApplication extends Application {

    private static final Logger LOGGER = getLogger(ToolsetApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Launching application with args: {}", (Object[]) args);
        try {
            launch(args);
        } finally {
            LOGGER.info("Application is shutdowned");
        }
    }

    public ToolsetApplication() {
        setDefaultUncaughtExceptionHandler((t, e) -> LOGGER.error("Exception in thread [" + t.getName() + "]", e));
    }

    @Override
    public void start(Stage stage) throws IOException {
        LOGGER.info("Configuring stage: {}", stage);
        stage.setTitle("Hello World!");
        FXMLLoader loader = new FXMLLoader();
        Class<OpenCampaignController> type = OpenCampaignController.class;
        String template = "/fxml/%s/%s.fxml";
        loader.setLocation(type.getResource(
                String.format(
                        template,
                        type.getPackage().getName().replaceAll("\\.", "/"),
                        toLowerCase(type.getSimpleName().charAt(0)) + type.getSimpleName().substring(1).replace("Controller", "")
                )
        ));
        loader.setController(new OpenCampaignController());
        Parent root = loader.load();
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }
}
