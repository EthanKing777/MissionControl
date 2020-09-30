package org.group11.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controller for the flight tab.
 */

public class FlightTabController {


	@FXML private TableView<PropertyTableModel> flightData;
	@FXML private TableColumn<String, String> dataType;
	@FXML private TableColumn<Double, Double> data;

	public FlightTabController() {
		//TODO: Rocket Serial parser
	}

	public void initialize(URL url, ResourceBundle rb) {
		dataType.setCellValueFactory(new PropertyValueFactory<String, String>("data type"));
		data.setCellValueFactory(new PropertyValueFactory<Double, Double>("data"));

		flightData.setItems(populateFlightData());
	}

	public ObservableList<PropertyTableModel> populateFlightData(){
		ObservableList<PropertyTableModel> property = FXCollections.observableArrayList();
		property.add(new PropertyTableModel("speed", "100"));
		property.add(new PropertyTableModel("height", "10"));
		property.add(new PropertyTableModel("power", "55555"));
		property.add(new PropertyTableModel("something else", "2"));
		return property;
	}

	@FXML
	public void printTestButtonOutput() {
		System.out.println("\n FlightTabController - Test Button Pressed \n");
	}
}
