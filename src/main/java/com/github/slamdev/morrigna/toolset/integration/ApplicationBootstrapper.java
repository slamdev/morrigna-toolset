package com.github.slamdev.morrigna.toolset.integration;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Objects;

import static java.util.stream.StreamSupport.stream;

@ApplicationScoped
public class ApplicationBootstrapper {

    @Inject
    @Startup
    private Instance<Controller> controllers;

    public void bootstrap(@Observes @Startup Stage stage) {
        Controller controller = stream(controllers.spliterator(), false)
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        Scene scene = new Scene(controller.getRootNode());
        stage.setScene(scene);
        stage.show();
    }
}
