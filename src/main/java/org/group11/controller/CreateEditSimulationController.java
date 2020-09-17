package org.group11.controller.fxcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import org.json.simple.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * A controller for the create/edit simulation tab.
 * Handles the editing of data and populating of the weather and simulation tables.
 */
public class CreateEditSimulationController implements Initializable {

	/**
	 * Edit weather TableView.
	 * Stores the editable weather properties.
	 */
	@FXML
	private TableView<PropertyTableModel> editWeatherTable;


	/**
	 * Edit simulation TableView.
	 * Stores the editable simulation properties.
	 */
	@FXML
	private TableView<PropertyTableModel> editSimulationTable;

	/**
	 * A column that represents the property name column on the edit weather table.
	 */
	@FXML
	private TableColumn<PropertyTableModel, String> weatherIdCol;

	/**
	 * A column that represents the property value column on the edit weather table.
	 */
	@FXML
	private TableColumn<PropertyTableModel, String> weatherValueCol;

	/**
	 * A column that represents the property name column on the edit simulation table.
	 */
	@FXML
	private TableColumn<PropertyTableModel, String> simulationIdCol;

	/**
	 * A column that represents the property value column on the edit simulation table.
	 */
	@FXML
	private TableColumn<PropertyTableModel, String> simulationValueCol;

	/**
	 * A list of all rows in the edit weather table.
	 * Each row is represented by an instance of {@link PropertyTableModel}.
	 */
	private ObservableList<PropertyTableModel> weatherTableProperties = getDefaultWeatherProperties();

	/**
	 * A list of all rows in the edit simulation table.
	 * Each row is represented by an instance of {@link PropertyTableModel}.
	 */
	private ObservableList<PropertyTableModel> simulationTableProperties = getDefaultSimulationProperties();


	/**
	 * Generates an {@link ObservableList} with the default values for the weather table.
	 * @return An {@link ObservableList} with all the default properties for the weather table.
	 */
	private static ObservableList<PropertyTableModel> getDefaultWeatherProperties() {
		ObservableList<PropertyTableModel> properties = FXCollections.observableArrayList();

		properties.add(new PropertyTableModel("Temperature", "10"));
		properties.add(new PropertyTableModel("Wind", "47"));
		properties.add(new PropertyTableModel("Humidity", "77"));

		return properties;
	}


	/**
	 * Generates an {@link ObservableList} with the default values for the simulation table.
	 * @return An {@link ObservableList} with all the default properties for the simulation table.
	 */
	private static ObservableList<PropertyTableModel> getDefaultSimulationProperties() {
		ObservableList<PropertyTableModel> properties = FXCollections.observableArrayList();

		properties.add(new PropertyTableModel("Property 1", "15"));
		properties.add(new PropertyTableModel("Property 2", "Strong"));
		properties.add(new PropertyTableModel("Property 3", "31"));

		return properties;
	}

	/**
	 * Initialization method, called when the controller is first created.
	 * Creates the default cell factories for all columns, and adds the property lists to each table.
	 * @param url
	 * @param resourceBundle
	 */
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

	/**
	 * Resets all the data in the weather table.
	 */
	@FXML
	public void resetWeatherData() {
		this.weatherTableProperties.setAll(getDefaultWeatherProperties());
	}

	/**
	 * Resets all the data in the simulation table.
	 */
	@FXML
	public void resetSimulationData() {
		this.simulationTableProperties.setAll(getDefaultSimulationProperties());
	}

	/**
	 * Parses the data stored in the table and creates a JSON string with all table properties.
	 * @return A JSON string with a JSON object for each table.
	 */
	public String getJsonOutput() {
		JSONObject container = new JSONObject(); //Contains the both the table objects
		JSONObject weatherTableJson = new JSONObject();
		JSONObject simulationTableJson = new JSONObject();

		container.put("weather", weatherTableJson);
		container.put("simulation", simulationTableJson);

		//Add each property and value to the weather JSON object
		for (PropertyTableModel weatherTableProperty : weatherTableProperties) {
			weatherTableJson.put(weatherTableProperty.getPropertyId().getValue(),
					weatherTableProperty.getPropertyValue().getValue());
		}

		//Add each property and value to the simulation JSON object
		for (PropertyTableModel simulationTableProperty : simulationTableProperties) {
			simulationTableJson.put(simulationTableProperty.getPropertyId().getValue(),
					simulationTableProperty.getPropertyValue().getValue());
		}

		return container.toJSONString();
	}

	/**
	 * Prints the properties stored in each table.
	 */
	@FXML
	public void printSubmitButtonOutput() {
		System.out.println("\nWeather table =======================\n");

		for (PropertyTableModel weatherTableProperty : weatherTableProperties) {

			System.out.println(weatherTableProperty.getPropertyId().getValue() + ": "
					+ weatherTableProperty.getPropertyValue().getValue());
		}

		System.out.println("\n\nSimulation table =======================\n");

		for (PropertyTableModel simulationTableProperty : simulationTableProperties) {
			System.out.println(simulationTableProperty.getPropertyId().getValue() +
					": " + simulationTableProperty.getPropertyValue().getValue());
		}

		System.out.println("\n\nJSON output =======================\n");

		System.out.println(getJsonOutput());

	}
}
