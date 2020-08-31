package org.group11.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.shape.Polygon;
import org.group11.controller.weather.WeatherDataFetcherParser;

public class configController {

	@FXML
	private TextField lat;
	@FXML
	private TextField log;

	public configController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	public void saveConfig(ActionEvent event) {
		System.out.println("\n Config - Test Button Pressed \n");
		System.out.println(lat.getText());
		System.out.println(log.getText());
		WeatherTabController wtc = new WeatherTabController();
		System.out.println(lat.getText());
		System.out.println(log.getText());
		wtc.setLat(Double.parseDouble(lat.getText()));
		wtc.setLog(Double.parseDouble(log.getText()));
		wtc.getWeatherData();
	}
}
