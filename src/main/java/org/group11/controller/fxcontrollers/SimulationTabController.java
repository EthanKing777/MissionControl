package org.group11.controller.fxcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.group11.controller.SimulationDataParser;

import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SimulationTabController implements Initializable {

	@FXML
	private LineChart<Number,Number> accelerationChart;

	@FXML
	private LineChart<Number,Number> velocityChart;

	@FXML
	private TextArea milestonesTab;
	
  @FXML
  WebView webView;

  private WebEngine webEngine;

	private SimulationDataParser parser;

	public SimulationTabController() {
		parser = new SimulationDataParser();
	}

	@FXML
	public void plotSimulationData(ActionEvent event) {

		//Clear the pane at every press of the button 
		accelerationChart.getData().clear();
		velocityChart.getData().clear();
		milestonesTab.clear();

		//Populate the window
		populateAccelerationGraph();
		populateVelocityGraph();
		populateMilestoneTab();

	}

	/**
	 * Display the key milestones of the simulation in a TextField
	 */
	private void populateMilestoneTab() {
		//Display Simulation Milestones
		milestonesTab.setPromptText("Milestones");
		for(int i=4;i<parser.getHeaders().length;i++) {
			milestonesTab.appendText("- ");
			milestonesTab.appendText(parser.getHeaders()[i]);
			milestonesTab.appendText("\n");
		}
	}

	/**
	 * Populate the Velocity graph by plotting the Total Velocity data of the Rocket Simulation
	 */
	private void populateVelocityGraph() {
		XYChart.Series <Number, Number> velocitySeries = new XYChart.Series<Number,Number>();
		
		//Get the "Time" data
		List<Number>time = parser.getVariableData("time");
		//Get the "Total Acceleration" data
		List<Number>totalVelocity = parser.getVariableData("total velocity");
		
		//Plot the Velocity for each time stamp. Time goes in the X-Axis and Velocity in the Y=Axis
		for(int i=0; i<time.size();i++){
			velocitySeries.getData().add(new XYChart.Data<Number,Number>(time.get(i),totalVelocity.get(i)));
		}
		
		velocitySeries.setName("Velocity");

		velocityChart.getData().add(velocitySeries);

	}

	/**
	 * Populate the Acceleration graph by plotting the Total Acceleration data of the Rocket Simulation
	 */
	private void populateAccelerationGraph() {
		XYChart.Series <Number, Number> accelerationSeries = new XYChart.Series<Number,Number>();

		//Get the "Time" data
		List<Number>time = parser.getVariableData("time");
		//Get the "Total Acceleration" data
		List<Number>totalAcceleration = parser.getVariableData("total acceleration");
		
		//Plot the acceleration for each time stamp. Time goes in the X-Axis and Acceleration in the Y=Axis
		for(int i=0; i<time.size();i++){
			accelerationSeries.getData().add(new XYChart.Data<Number,Number>(time.get(i),totalAcceleration.get(i)));
		}
		
		accelerationSeries.setName("Acceleration");

		accelerationChart.getData().add(accelerationSeries);
	}
	
	@Override
  public void initialize(URL url, ResourceBundle rb) {
    webEngine=webView.getEngine();
    //webEngine.loadContent(html);
    webEngine.load("https://www.google.com");
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
