package org.group11;

import javafx.fxml.FXML;
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

		populateAccelerationGraph();
		populateVelocityGraph();
		populateMilestoneTab();

	}

	private void populateMilestoneTab() {
		//Display Simulation Milestones
		milestonesTab.setPromptText("Milestones");
		for(int i=4;i<parser.getHeaders().length;i++) {
			milestonesTab.appendText("- ");
			milestonesTab.appendText(parser.getHeaders()[i]);
			milestonesTab.appendText("\n");
		}
	}

	private void populateVelocityGraph() {
		//Populate the Velocity Graph
		XYChart.Series <Number, Number> velocitySeries = new XYChart.Series<Number,Number>();

		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0,0));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.1,0));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.2,0));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.3,0));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.4,0));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.5,0.0048032));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.6,0.067351));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.7,0.18787));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.8,0.3664));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(0.9,0.60716));
		velocitySeries.getData().add(new XYChart.Data<Number,Number>(1,0.92742));
		velocitySeries.setName("Velocity");

		velocityChart.getData().add(velocitySeries);

	}

	private void populateAccelerationGraph() {
		//Populate the Acceleration graph
		XYChart.Series <Number, Number> accelerationSeries = new XYChart.Series<Number,Number>();

		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0,-8.8));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.1,-6.8));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.2,-4.9));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.3,-3.1));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.4,0.4));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.5,6.23));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.6,12.047));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.7,17.8));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.8,24.065));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(0.9,32.005));
		accelerationSeries.getData().add(new XYChart.Data<Number,Number>(1,40.14));
		accelerationSeries.setName("Acceleration");

		accelerationChart.getData().add(accelerationSeries);
	}

}
