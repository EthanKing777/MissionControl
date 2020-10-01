package org.group11.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import org.group11.SimulationDataParser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class RocketArcController{
	
	@FXML
	private LineChart<Number,Number> rocketArcGraph;
	
	
	private SimulationDataParser parser;

	public RocketArcController() {
	}

	@FXML
	public void plotSimulationData(ActionEvent event) throws IOException {
		File file = new File ("Simulation Test Data.csv");
		parser = new SimulationDataParser(file);

		//Clear the pane at every press of the button 
		if(rocketArcGraph!= null)rocketArcGraph.getData().clear();
		
		//Populate the window
		populateRocketArcGraph();
	}

	/**
	 * Populate the Rocket Arc graph by plotting the position north and east of launch on the Y and X axis respectively
	 */
	private void populateRocketArcGraph() throws IOException {
		XYChart.Series <Number, Number> rocketArcSeries = new XYChart.Series<>();
		
		//Get the "Time" data
		List<Number>time = parser.getVariableData("time");
		//Get the "Position North of Launch" data
		List<Number>posNorthOfLaunch = parser.getVariableData("position north of launch");
		//Get the "Position North of Launch" data
		List<Number>posEastOfLaunch = parser.getVariableData("position east of launch");
		
		//Plot the rocket for each time stamp. The position north of launch is displayed on the Y axis
		// and the position east of launch is displayed on the X axis
		for(int i=0; i<time.size();i++){
			Number east = posEastOfLaunch.get(i);
			Number north = posNorthOfLaunch.get(i);
			//Number t = time.get(i);
			System.out.println(east + " , " + north);
			rocketArcSeries.getData().add(new XYChart.Data<>(east, north));
		}
		
		rocketArcSeries.setName("RocketArc");
		rocketArcGraph.setAnimated(true);
		rocketArcGraph.getData().add(rocketArcSeries);
	}
	
}
