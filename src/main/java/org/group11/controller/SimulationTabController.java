package org.group11.controller;

import javafx.fxml.FXML;

import java.util.List;

import org.group11.SimulationDataParser;

import javafx.event.ActionEvent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class SimulationTabController {

	@FXML
	private LineChart<Number,Number> accelerationChart;

	@FXML
	private LineChart<Number,Number> velocityChart;

	@FXML
	private TextArea milestonesTab;

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

}
