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
	private TableColumn<PropertyTableModel, String> weatherIdCol;

	@FXML
	private TableColumn<PropertyTableModel, String> weatherValueCol;

	private ObservableList<PropertyTableModel> weatherTableProperties = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		weatherIdCol.setCellValueFactory(cellData -> cellData.getValue().getPropertyId());
		weatherValueCol.setCellValueFactory(cellData -> cellData.getValue().getPropertyValue());
		weatherValueCol.setCellFactory(TextFieldTableCell.forTableColumn()); //Make the value column editable

		editWeatherTable.setItems(weatherTableProperties);
	}

	@FXML
	public void printSubmitButtonOutput() {
		System.out.println("\n CreateEditSimulationController - Submit Button Pressed \n");
		weatherTableProperties.add(new PropertyTableModel("R", Math.random() + ""));
	}
}
