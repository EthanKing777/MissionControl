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

	private ObservableList<PropertyTableModel> weatherTableProperties = FXCollections.observableArrayList();
	private ObservableList<PropertyTableModel> simulationTableProperties = FXCollections.observableArrayList();


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
	public void printSubmitButtonOutput() {
		System.out.println("\n CreateEditSimulationController - Submit Button Pressed \n");
	}
}
