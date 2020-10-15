package org.group11.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.group11.flightDataParser;
import org.json.simple.JSONObject;
import org.group11.SimulationDataParser;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import org.group11.SimulationDataParser;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;



/**
 * Controller for the flight tab.
 */

public class FlightTabController {


	@FXML private TableView<PropertyTableModel> flightData;
	@FXML private TableColumn<String, String> dataType;
	@FXML private TableColumn<Double, Double> data;

	@FXML WebView webView;

	private WebEngine webEngine;

	private flightDataParser parser;
	private SimulationDataParser simParser; //just for landing site

	public FlightTabController() {
		//TODO: Rocket Serial parser also need to fix this more too
		dataType.setCellValueFactory(new PropertyValueFactory<String, String>("data type"));
		data.setCellValueFactory(new PropertyValueFactory<Double, Double>("data"));
		flightData.setItems(populateFlightData());

		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(flightData.getScene().getWindow());
		simParser = new SimulationDataParser(file);

		FileChooser fileChooser1 = new FileChooser();
		File file1 = fileChooser1.showOpenDialog(flightData.getScene().getWindow());
		parser = new flightDataParser(file1);

		//Clear the pane at every press of the button
		//TODO: clear stuff each tick


		//Populate the window
		populateFlightData();
		updateMap();
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

	/**
	 * Update the map by generating a new map api call
	 */
	public void updateMap() {
		String geoJSON = getGeoJSON();
		try {
			webEngine=webView.getEngine();
			MapBox.setLatLng(-41.285099,174.776001);
			MapBox.setLandingLocations(URLEncoder.encode(geoJSON, StandardCharsets.UTF_8.toString())); //URL encoded as per javadoc
			webEngine.load(MapBox.generateApiCall("345" , "610","8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create a GeoJSON object using the Geo Spatial data of the rocket landing sites
	 *
	 * @return A GeoJSON object
	 */
	@SuppressWarnings("unchecked")
	private String getGeoJSON() {
		String message;

		System.out.println(simParser.toString());

		GeoJSONBuilder geoJSON = new GeoJSONBuilder(simParser);
		JSONObject obj = geoJSON.getGeoJSON();

		//This is only for printing on the console. Please comment out if needed
		message = obj.toString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(message);
		System.out.println(gson.toJson(je));

		return message;
	}


	public void initialize(URL url, ResourceBundle rb) {
		webEngine=webView.getEngine();
		MapBox.setLatLng(-41.285099,174.776001);
		webEngine.load(MapBox.generateApiCall("345" , "610","9"));
	}
}


