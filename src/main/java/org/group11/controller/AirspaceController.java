package org.group11.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;


public class AirspaceController implements Initializable {
    @FXML
    WebView airspaceView;

    private WebEngine webEngine;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webEngine=airspaceView.getEngine();;
//        webEngine.load("https://pilot.airshare-utm.io/maps");
        webEngine.load("https://www.airshare.co.nz/maps");
    }
}
