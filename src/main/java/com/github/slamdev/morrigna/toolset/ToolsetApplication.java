package com.github.slamdev.morrigna.toolset;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;

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
    public void start(Stage stage) {
        LOGGER.info("Configuring stage: {}", stage);
        stage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(e -> LOGGER.info("Button clicked from event: {}", e));
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }
}
