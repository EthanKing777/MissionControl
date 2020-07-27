package org.group11.controller.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardTab extends AnchorPane {

    @FXML
    private AnchorPane tab;

    public DashboardTab() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/group11/dashboard.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        fxmlLoader.setClassLoader(getClass().getClassLoader());

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
