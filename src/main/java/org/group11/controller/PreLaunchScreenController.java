package org.group11.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 */
public class PreLaunchScreenController implements Initializable{
  /**
   * 
   */
  @FXML
  WebView webView;
  /**
   * 
   */
  private WebEngine webEngine;

	/**
	 * 
	 */
	public PreLaunchScreenController() {
		// TODO Auto-generated constructor stub
	}
	
	 @Override
   public void initialize(URL url, ResourceBundle rb) {
	   webEngine=webView.getEngine();
	   webEngine.load(MapBox.generateApiCall("212" , "217","0"));
	 }

	/**
	 * 
	 */
	@FXML
	public void printArmButtonOutput() {
		System.out.println("\n PreLaunchScreenController - ARM Button Pressed \n");
	}
	
	/**
	 * 
	 */
	@FXML
	public void printGoNoGoButtonOutput() {
		System.out.println("\n PreLaunchScreenController - Go/No-Go Button Pressed \n");
	}
	
     
}
