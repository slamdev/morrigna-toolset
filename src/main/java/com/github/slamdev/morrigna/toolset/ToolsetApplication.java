package com.github.slamdev.morrigna.toolset;

import com.github.slamdev.morrigna.toolset.integration.Startup;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;

import javax.enterprise.util.AnnotationLiteral;
import java.io.IOException;

import static java.lang.Thread.setDefaultUncaughtExceptionHandler;
import static org.slf4j.LoggerFactory.getLogger;

public class ToolsetApplication extends Application {

    private static final Logger LOGGER = getLogger(ToolsetApplication.class);

    private WeldContainer container;

    public ToolsetApplication() {
        setDefaultUncaughtExceptionHandler((t, e) -> LOGGER.error("Exception in thread [" + t.getName() + "]", e));
    }

    public static void main(String[] args) {
        LOGGER.info("Launching application with args: {}", (Object[]) args);
        try {
            launch(args);
        } finally {
            LOGGER.info("Application is shutdowned");
        }
    }

    @Override
    public void start(Stage stage) throws IOException, IllegalAccessException, InstantiationException {
        container.event().select(Stage.class, new AnnotationLiteral<Startup>() {
        }).fire(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        container = new Weld().initialize();
    }

    @Override
    public void stop() throws Exception {
        container.close();
        super.stop();
    }
}
