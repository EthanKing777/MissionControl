package org.group11.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;

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
	private final ObservableList<PropertyTableModel> weatherTableProperties = getDefaultWeatherProperties();

	/**
	 * A list of all rows in the edit simulation table.
	 * Each row is represented by an instance of {@link PropertyTableModel}.
	 */
	private final ObservableList<PropertyTableModel> simulationTableProperties = getDefaultSimulationProperties();

	/**
	 * Contains the default rocket property values from the last loaded CSV file.
	 * Initially empty, until a file is loaded.
	 */
	private List<PropertyTableModel> defaultLoadedSimulationProperties = new ArrayList<>();


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
	 * Opens a file chooser dialog that allows a CSV file to be selected.
	 * Parses the CSV file and adds the parsed data into the rocket properties table.
	 */
	@FXML
	public void loadSimulationDataFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select a simulation data file...");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Simulation data file", "*.csv")
		); //Limit the files that can be picked to only CSV files

		File file = fileChooser.showOpenDialog(editWeatherTable.getScene().getWindow());

		if (file != null) { //Null means no file was selected
			try {
				readSimulationFile(file);
			}
			catch (FileNotFoundException e) {}
		}
	}

	/**
	 * Parses a CSV file containing the rocket properties.
	 * Item order in the CSV file:
	 *  Launch rod angle,
	 *  Launch rod length,
	 *  Launch rod direction,
	 *  Launch altitude,
	 *  Launch latitude,
	 *  Launch longitude,
	 *  Maximum launch rod angle,
	 *  Minimum launch rod angle
	 * @param file The CSV file to be parsed
	 * @throws FileNotFoundException Thrown if the given file does not exist on the file system
	 */
	public void readSimulationFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);

		scanner.useDelimiter(",");

		String[] headers = {
				"Launch rod angle", "Launch rod length", "Launch rod direction", "Launch altitude", "Launch latitude",
				"Launch longitude", "Maximum launch rod angle", "Minimum launch rod angle"
		}; //The CSV file headers (in order)

		List<PropertyTableModel> properties = new ArrayList<>();
		int i = 0;

		while (scanner.hasNext()) {
			String[] line = scanner.nextLine().split(","); //Properties are seperated with a comma

			if (line[0].startsWith("#")) { //Ignore lines starting with #
				continue;
			}

			for (String value : line) { //For each property on the current line
				properties.add(new PropertyTableModel(headers[i], value));
				i++;
			}
		}

		simulationTableProperties.clear();
		simulationTableProperties.addAll(properties);

		// Clone the list and store it in a separate field.
		// Used to save the default values loaded from the CSV.
		defaultLoadedSimulationProperties = clonePropertiesList(simulationTableProperties);
	}

	/**
	 * Resets the values in the rocket properties table to the default values from the last loaded CSV file.
	 */
	public void resetSimulationTable() {
		simulationTableProperties.clear();
		simulationTableProperties.addAll(clonePropertiesList(defaultLoadedSimulationProperties));
	}

	/**
	 * Performs a deep clone of the given {@literal List<PropertyTableModel>}.
	 * @param properties The {@link List} to clone.
	 * @return A deep clone of the given list.
	 */
	public List<PropertyTableModel> clonePropertiesList(List<PropertyTableModel> properties) {
		ArrayList<PropertyTableModel> clonedList = new ArrayList<>();

		for (PropertyTableModel property : properties) {
			clonedList.add(property.clone()); //Clone each property in the given list and add it to the new list
		}

		return clonedList;
	}

	/**
	 * Gets the values in the weather properties table as a CSV.
	 * @return A CSV string containing the weather properties.
	 */
	public String getWeatherPropertiesCSV() {
		String output = "";

		for (int i = 0; i < weatherTableProperties.size(); i++) {
			output += weatherTableProperties.get(i).getPropertyValue().getValue();

			if (i < weatherTableProperties.size() - 1) { //If the current value is not the last in the list
				output += ",";
			}
		}

		return output;
	}

	/**
	 * Gets the values in the rocket properties table as a CSV.
	 * @return A CSV string containing the rocket properties.
	 */
	public String getRocketPropertiesCSV() {
		String output = "";

		for (int i = 0; i < simulationTableProperties.size(); i++) {
			output += simulationTableProperties.get(i).getPropertyValue().getValue();

			if (i < simulationTableProperties.size() - 1) { //If the current value is not the last in the list
				output += ",";
			}
		}

		return output;
	}

	/**
	 * Saves the weather and rocket properties to a single CSV file.
	 * Uses a save file dialog to allow the user to choose the save location.
	 * @throws FileNotFoundException
	 */
	public void savePropertiesFileCSV() throws FileNotFoundException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select a simulation data file...");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Simulation data file", "*.csv")
		); //Limit the files that can be picked to only CSV files

		File file = fileChooser.showSaveDialog(editWeatherTable.getScene().getWindow()); //Show the save file dialog

		if (file != null) { //No save location selected
			PrintWriter writer = new PrintWriter(file);

			//Write both tables as a single CSV file
			writer.write(getWeatherPropertiesCSV() + "," + getRocketPropertiesCSV());
			writer.close();
		}
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


		System.out.println("\n\nCSV output =======================\n");
		System.out.println("Weather properties: " + getWeatherPropertiesCSV());
		System.out.println("Rocket properties: " + getRocketPropertiesCSV());

	}
}
