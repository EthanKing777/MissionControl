package org.group11.controller.fxcontrollers;

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
     //webEngine.loadContent(html);
	   webEngine.load(MapBox.generateApiCall("212" , "217","3"));
	   //webEngine.load("https://api.mapbox.com/styles/v1/mapbox/satellite-streets-v11/static/174.776001,-41.285099,14/217x212@2x?access_token=pk.eyJ1IjoiY3ZidXJ0MDgiLCJhIjoiY2tkcDdjaGE5MXprZjJycGR2N2FhN2Q3OSJ9.WHW0WMAG5hF6xhtehdo3EQ");
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
	
	String html = "<!DOCTYPE html>\n" + 
	    "<html>\n" + 
	    "<head>\n" + 
	    "<meta charset=\"utf-8\" />\n" + 
	    "<title>Display a map</title>\n" + 
	    "<meta name=\"viewport\"\n" + 
	    "  content=\"initial-scale=1,maximum-scale=1,user-scalable=no\" />\n" + 
	    "<script src=\"https://api.mapbox.com/mapbox-gl-js/v1.12.0/mapbox-gl.js\"></script>\n" + 
	    "<link href=\"https://api.mapbox.com/mapbox-gl-js/v1.12.0/mapbox-gl.css\"\n" + 
	    "  rel=\"stylesheet\" />\n" + 
	    "<style>\n" + 
	    "body {\n" + 
	    "  margin: 0;\n" + 
	    "  padding: 0;\n" + 
	    "}\n" + 
	    "\n" + 
	    "#map {\n" + 
	    "  position: absolute;\n" + 
	    "  top: 0;\n" + 
	    "  bottom: 0;\n" + 
	    "  width: 100%;\n" + 
	    "}\n" + 
	    "</style>\n" + 
	    "</head>\n" + 
	    "<body>\n" + 
	    "  <div id=\"map\"></div>\n" + 
	    "  <script>\n" + 
	    "    mapboxgl.accessToken = 'pk.eyJ1IjoiY3ZidXJ0MDgiLCJhIjoiY2tkcDdjaGE5MXprZjJycGR2N2FhN2Q3OSJ9.WHW0WMAG5hF6xhtehdo3EQ';\n" + 
	    "    var map = new mapboxgl.Map({\n" + 
	    "      container : 'map', // container id\n" + 
	    "      style : 'mapbox://styles/mapbox/satellite-streets-v11', // style URL\n" + 
	    "      center : [ -74.5, 40 ], // starting position [lng, lat]\n" + 
	    "      zoom : 9\n" + 
	    "    // starting zoom\n" + 
	    "    });\n" + 
	    "  </script>\n" + 
	    "\n" + 
	    "</body>";
	
     
}
