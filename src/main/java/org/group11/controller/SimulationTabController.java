package org.group11.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import org.group11.SimulationDataParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ResourceBundle;


public class SimulationTabController implements Initializable {

	@FXML
	private LineChart<Number,Number> accelerationChart;

	@FXML
	private LineChart<Number,Number> velocityChart;
	
	@FXML
	private LineChart<Number,Number> rocketArcGraph;

	@FXML
	private TextArea milestonesTab;

	@FXML
	WebView webView;

	private WebEngine webEngine;

	private SimulationDataParser parser;

	public SimulationTabController() {

	}

	@FXML
	public void plotSimulationData(ActionEvent event) throws IOException {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(milestonesTab.getScene().getWindow());
		parser = new SimulationDataParser(file);

		//Clear the pane at every press of the button 
		if(accelerationChart.getData() != null)accelerationChart.getData().clear();
		if(velocityChart.getData() != null)velocityChart.getData().clear();
		if(rocketArcGraph!= null)rocketArcGraph.getData().clear();
		milestonesTab.clear();

		//Populate the window
		populateAccelerationGraph();
		populateVelocityGraph();
		populateRocketArcGraph();
		populateMilestoneTab();
		updateMap();
	}

	/**
	 * Display the key milestones of the simulation in a TextField
	 */
	private void populateMilestoneTab() throws IOException {
		//Display Simulation Milestones
		milestonesTab.setPromptText("Milestones");
		File milesoneFile = new File("output/Simulation Data/milestones/Milestone log.txt");
		milesoneFile.createNewFile();
		FileOutputStream outputStream = new FileOutputStream(milesoneFile);
		for(int i=4;i<parser.getHeaders().length;i++) {
			String dash = "- ";
			milestonesTab.appendText(dash);
			byte[] strToByte = dash.getBytes();
			outputStream.write(strToByte);
			String info = parser.getHeaders()[i];
			strToByte = info.getBytes();
			outputStream.write(strToByte);
			milestonesTab.appendText(info);
			String newLine = "\n";
			strToByte = newLine.getBytes();
			outputStream.write(strToByte);
			milestonesTab.appendText(newLine);
		}
	}

	/**
	 * Populate the Velocity graph by plotting the Total Velocity data of the Rocket Simulation
	 */
	private void populateVelocityGraph() throws IOException {
		XYChart.Series <Number, Number> velocitySeries = new XYChart.Series<>();

		//Get the "Time" data
		List<Number>time = parser.getVariableData("time");
		//Get the "Total Acceleration" data
		List<Number>totalVelocity = parser.getVariableData("total velocity");

		//Plot the Velocity for each time stamp. Time goes in the X-Axis and Velocity in the Y=Axis
		for(int i=0; i<time.size();i++){
			velocitySeries.getData().add(new XYChart.Data<>(time.get(i), totalVelocity.get(i)));
		}

		velocitySeries.setName("Velocity");
		velocityChart.setAnimated(false);
		velocityChart.getData().add(velocitySeries);
		File velGraph = new File("output/Simulation Data/graphs/Velocity Graph.png");
		velGraph.createNewFile();
		WritableImage img = velocityChart.snapshot(new SnapshotParameters(), null);
		ImageIO.write(SwingFXUtils.fromFXImage(img, null), "PNG", velGraph);
	}

	/**
	 * Populate the Acceleration graph by plotting the Total Acceleration data of the Rocket Simulation
	 */
	private void populateAccelerationGraph() throws IOException {
		XYChart.Series <Number, Number> accelerationSeries = new XYChart.Series<>();

		//Get the "Time" data
		List<Number>time = parser.getVariableData("time");
		//Get the "Total Acceleration" data
		List<Number>totalAcceleration = parser.getVariableData("total acceleration");

		//Plot the acceleration for each time stamp. Time goes in the X-Axis and Acceleration in the Y=Axis
		for(int i=0; i<time.size();i++){
			accelerationSeries.getData().add(new XYChart.Data<>(time.get(i), totalAcceleration.get(i)));
		}

		accelerationSeries.setName("Acceleration");
		accelerationChart.setAnimated(false);
		accelerationChart.getData().add(accelerationSeries);

		File accGraph = new File("output/Simulation Data/graphs/Acceleration Graph.png");
		accGraph.createNewFile();
		WritableImage img = accelerationChart.snapshot(new SnapshotParameters(), null);
		ImageIO.write(SwingFXUtils.fromFXImage(img, null), "PNG", accGraph);
	}
	
	/**
	 * Populate the Rocket Arc graph by plotting the position north and east of launch on the Y and X axis respectively
	 */
	private void populateRocketArcGraph() throws IOException {
		XYChart.Series <Number, Number> rocketArcSeries = new XYChart.Series<>();
		
		//Get the "Time" data
		List<Number>time = parser.getVariableData("time");
		//Get the "Position North of Launch" data
		List<Number>posNorthOfLaunch = parser.getVariableData("position north of launch");
		//Get the "Position North of Launch" data
		List<Number>posEastOfLaunch = parser.getVariableData("position east of launch");
		
		//Plot the rocket for each time stamp. The position north of launch is displayed on the Y axis
		// and the position east of launch is displayed on the X axis
		for(int i=0; i<time.size();i++){
			Number east = posEastOfLaunch.get(i);
			Number north = posNorthOfLaunch.get(i);
			//Number t = time.get(i);
			System.out.println(east + " , " + north);
			rocketArcSeries.getData().add(new XYChart.Data<>(north,east));
		}
		
		rocketArcSeries.setName("RocketArc");
		rocketArcGraph.setAnimated(true);
		rocketArcGraph.getData().add(rocketArcSeries);
	}

	/**
	 * Update the map by generating a new map api call
	 */
	public void updateMap() {
		String geoJSON = getGeoJSON();
		try {
			String url = URLEncoder.encode(geoJSON, StandardCharsets.UTF_8.toString());
			webEngine=webView.getEngine();
			MapBox.setLatLng(-41.285099,174.776001);
			MapBox.setLandingLocations(url); //URL encoded as per javadoc
			webEngine.load(MapBox.generateApiCall("345" , "610","8"));
			System.out.println("geojson.io API Call = \n"+"http://geojson.io/#data=data:application/json,"+url);
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
		
		System.out.println(parser.toString());

		GeoJSONBuilder geoJSON = new GeoJSONBuilder(parser);
		JSONObject obj = geoJSON.getGeoJSON();

		//This is only for printing on the console. Please comment out if not needed
		message = obj.toString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(message);
		System.out.println(gson.toJson(je));

		return message;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		webEngine=webView.getEngine();
		MapBox.setLatLng(-41.285099,174.776001);
		webEngine.load(MapBox.generateApiCall("345" , "610","9"));
	}
	
}
