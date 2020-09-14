package org.group11.controller.fxcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateEditSimulationController implements Initializable {

	@FXML
	private TableView<PropertyTableModel> editWeatherTable;

	@FXML
	private TableView<PropertyTableModel> editSimulationTable;

	@FXML
	private TableColumn<PropertyTableModel, String> weatherIdCol;

	@FXML
	private TableColumn<PropertyTableModel, String> weatherValueCol;

	@FXML
	private TableColumn<PropertyTableModel, String> simulationIdCol;

	@FXML
	private TableColumn<PropertyTableModel, String> simulationValueCol;

	private ObservableList<PropertyTableModel> weatherTableProperties = getDefaultWeatherProperties();
	private ObservableList<PropertyTableModel> simulationTableProperties = getDefaultSimulationProperties();

	private static ObservableList<PropertyTableModel> getDefaultWeatherProperties() {
		ObservableList<PropertyTableModel> properties = FXCollections.observableArrayList();

		properties.add(new PropertyTableModel("Temperature", "10"));
		properties.add(new PropertyTableModel("Wind (km/h)", "47"));
		properties.add(new PropertyTableModel("Humidity", "77"));

		return properties;
	}

	private static ObservableList<PropertyTableModel> getDefaultSimulationProperties() {
		ObservableList<PropertyTableModel> properties = FXCollections.observableArrayList();

		properties.add(new PropertyTableModel("Property 1", "15"));
		properties.add(new PropertyTableModel("Property 2", "Strong"));
		properties.add(new PropertyTableModel("Property 3", "31"));

		return properties;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		//Weather table columns
		weatherIdCol.setCellValueFactory(cellData -> cellData.getValue().getPropertyId());
		weatherValueCol.setCellValueFactory(cellData -> cellData.getValue().getPropertyValue());
		weatherValueCol.setCellFactory(TextFieldTableCell.forTableColumn()); //Make the value column editable

		//Simulation table columns
		simulationIdCol.setCellValueFactory(cellData -> cellData.getValue().getPropertyId());
		simulationValueCol.setCellValueFactory(cellData -> cellData.getValue().getPropertyValue());
		simulationValueCol.setCellFactory(TextFieldTableCell.forTableColumn()); //Make the value column editable

		//Update the rows stored in the tables
		editWeatherTable.setItems(weatherTableProperties);
		editSimulationTable.setItems(simulationTableProperties);
	}

	@FXML
	public void resetWeatherData() {
		this.weatherTableProperties.setAll(getDefaultWeatherProperties());
	}

	@FXML
	public void resetSimulationData() {
		this.simulationTableProperties.setAll(getDefaultSimulationProperties());
	}

	@FXML
	public void printSubmitButtonOutput() {
		weatherTableProperties.add(new PropertyTableModel("R", Math.random() + ""));
		simulationTableProperties.add(new PropertyTableModel("R", Math.random() + ""));
	}
}
