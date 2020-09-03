package org.group11.controller.fxcontrollers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class PreLaunchScreenController {

	public PreLaunchScreenController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	public void printArmButtonOutput() {
		System.out.println("\n PreLaunchScreenController - ARM Button Pressed \n");
	}
	
	@FXML
	public void printGoNoGoButtonOutput() {
		System.out.println("\n PreLaunchScreenController - Go/No-Go Button Pressed \n");
	}
	
	@FXML
  WebView webView;
  private WebEngine webEngine;

  @FXML
  private void goAction(ActionEvent evt) {
      webEngine.load("http://google.com");
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

      webEngine = webView.getEngine();
      webEngine.locationProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
             // txtURL.setText(newValue);
          }
      });
      // remove right clicks
      webView.setContextMenuEnabled(false);
     // txtURL.setText("http://www.google.com");
  }
     
}
