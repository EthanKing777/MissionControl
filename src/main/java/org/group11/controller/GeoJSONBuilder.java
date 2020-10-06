package org.group11.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.group11.SimulationDataParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GeoJSONBuilder {
	
	private JSONObject json;
	private Map jsonMap;
	private JSONArray features;
	private SimulationDataParser parser;

	/**
	 * Create an instance of this object.
	 * 
	 * @param parser The SimulationDataParser used to extract coordinates
	 */
	public GeoJSONBuilder(SimulationDataParser parser) {
		this.parser = parser;
		json = new JSONObject();
		features = new JSONArray();
		jsonMap = new LinkedHashMap();
		buildJSONstring();
	}
	
	/**
	 * Builds a GeoJSON string by adding an "n" number of "features", where "n" equals the number coordinates being plotted
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void buildJSONstring() {
		addFeatures();
		//This will maintain the order 
		jsonMap.put("type", "FeatureCollection");
		jsonMap.put("features", features);
		json.putAll(jsonMap);
	}
	
	/**
	 * Creates a list of "features" of size "n", where "n" equals the number of coordinates.<br>
	 * A <code>JSONObject</code> is created for each individual coordinate. The format is as follows:<br><br>
	 * 
	 * {<br><code>"type" : "Feature"</code>,<br><code>"properties" : {}</code>,<br><code>"geometry" : {<br>"type":"Point",<br>"coordinates":[<br>latitude,longitude<br>]}}</code>
	 *
	 */
	@SuppressWarnings("unchecked")
	private void addFeatures() {
		List<Number>time = parser.getVariableData("time");
		List<Number>latitude = parser.getVariableData("latitude");
		List<Number>longitude = parser.getVariableData("longitude");
			
		for(int i=0; i<time.size();i++) {
			JSONObject item = new JSONObject();
			double lat = (double)latitude.get(i);
			double lon = (double)longitude.get(i);
			//System.out.println("Adding" + " : " + lat + " - " + lon);
			item.put("type", "Feature");
			item.put("properties", addProperties());
			item.put("geometry", addGeometry(lat, lon));
			
			features.add(item);	
		}
	}
	
	/**
	 * Create a Property object
	 *  
	 * @return A Property Object
	 */
	private JSONObject addProperties() {
		JSONObject properties = new JSONObject();
		return properties;
	}
	
	/**
	 * Create a Geometry object with the <code>Latitude</code> and <code>Longitude</code>
	 * 
	 * @param lat Latitude
	 * @param lon Longitude
	 * @return A Geometry object
	 */
	@SuppressWarnings("unchecked")
	private JSONObject addGeometry(double lat, double lon) {
		JSONObject geometry = new JSONObject();
		JSONArray coordinates = new JSONArray();
		//When passing coordinates to the GeoJSON array, the longitude is passed before latitude
		coordinates.add(lon);
		coordinates.add(lat);
		//System.out.println("Added : " + coordinates.get(0) + " - "  + coordinates.get(1)+"\n");
		
		geometry.put("type", "Point");
		geometry.put("coordinates", coordinates);
		
		//geometry.putAll(jsonMap);
		
		return geometry;
	}
	
	/**
	 * Return the final GeoJSON object
	 * 
	 * @return A GeoJSON object
	 */
	public JSONObject getGeoJSON() {
		return this.json;
	}
	
}
