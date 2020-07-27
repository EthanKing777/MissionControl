package org.group11.controller.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainTab extends AnchorPane {

    @FXML
    private AnchorPane tab;

    public MainTab() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainTab.class.getResource("/org/group11/controller/component/tab.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        fxmlLoader.setClassLoader(MainTab.class.getClassLoader());

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
