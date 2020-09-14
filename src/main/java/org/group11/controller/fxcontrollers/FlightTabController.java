package org.group11.controller.fxcontrollers;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller for the flight tab.
 */

public class FlightTabController {


	@FXML private TableView<String> flightData;
	@FXML private TableColumn<String, Double> dataType;
	@FXML private TableColumn<Double, Double> data;


	/**
	@FXML
	something to show the map;
	 * @param flightData
	 * @param dataType
	 * @param data
	 */

	//something needed here to get rocket data.


	public FlightTabController(TableView<String> flightData, TableColumn dataType, TableColumn data) {
		//something here to take the data from rocket
		this.flightData = flightData;
		this.dataType = dataType;
		this.data = data;
	}

	@FXML
	public void populateFlightData(ActionEvent event) {
		flightData.getColumns().clear(); //clear it
		//something to read the data and show it

	}

	@FXML
	public void printTestButtonOutput() {
		System.out.println("\n FlightTabController - Test Button Pressed \n");
	}
}
