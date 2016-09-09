package com.github.slamdev.morrigna.toolset.integration;

import javafx.application.Platform;
import javafx.stage.Stage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ShutdownKeyConfiguration {

    public void configure(@Observes @Startup Stage stage) {
        stage.getScene().setOnKeyPressed(event -> Platform.exit());
    }
}
