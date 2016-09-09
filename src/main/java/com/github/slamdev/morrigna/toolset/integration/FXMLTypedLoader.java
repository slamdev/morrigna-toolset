package com.github.slamdev.morrigna.toolset.integration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.net.URL;

import static java.lang.Character.toLowerCase;

@Dependent
public class FXMLTypedLoader {

    public <T extends Parent> T load(Controller<T> controller) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getFxmlUrl(controller.getClass()));
        loader.setController(controller);
        try {
            return loader.load();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private URL getFxmlUrl(Class<?> type) {
        String template = "/fxml/%s/%s.fxml";
        String packageDir = type.getPackage().getName().replaceAll("\\.", "/");
        String fileName = toLowerFirst(type.getSimpleName()).replace("Controller", "");
        return type.getResource(String.format(template, packageDir, fileName));
    }

    private String toLowerFirst(String string) {
        return toLowerCase(string.charAt(0)) + string.substring(1);
    }
}
