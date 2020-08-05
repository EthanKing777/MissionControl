package org.group11;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class SimulationTabController {

    @FXML
    private LineChart<Number,Number> accelerationChart;
    
    @FXML
    private LineChart<Number,Number> velocityChart;

    public SimulationTabController() {
		// TODO Auto-generated constructor stub
	}
    
    @FXML
    public void plotSimulationData(ActionEvent event) {
    	XYChart.Series <Number, Number> series = new XYChart.Series<Number,Number>();
    	
    	series.getData().add(new XYChart.Data<Number,Number>(0,-8.8));
    	series.getData().add(new XYChart.Data<Number,Number>(0.1,-6.8));
    	series.getData().add(new XYChart.Data<Number,Number>(0.2,-4.9));
    	series.getData().add(new XYChart.Data<Number,Number>(0.3,-3.1));
    	series.getData().add(new XYChart.Data<Number,Number>(0.4,0.4));
    	series.getData().add(new XYChart.Data<Number,Number>(0.5,6.23));
    	series.getData().add(new XYChart.Data<Number,Number>(0.6,12.047));
    	series.getData().add(new XYChart.Data<Number,Number>(0.7,17.8));
    	series.getData().add(new XYChart.Data<Number,Number>(0.8,24.065));
    	series.getData().add(new XYChart.Data<Number,Number>(0.9,32.005));
    	series.getData().add(new XYChart.Data<Number,Number>(1,40.14));
    	
    	accelerationChart.getData().add(series);
    	    	
    }

}
