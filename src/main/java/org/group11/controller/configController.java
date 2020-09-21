package org.group11.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.group11.App;
import org.group11.model.config.configData;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class configController {

	@FXML
	private TextField lat;
	@FXML
	private TextField log;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Spinner hours, mins, secs;

	private configData configData;

	public configController() {

	}

	@FXML
	public void saveConfig(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(App.class.getResource("WeatherTabv2.fxml"));

		long launchDateEpoch = datePicker.getValue().toEpochSecond(LocalTime.NOON, ZoneOffset.MIN);
		int launchHour = (int) hours.getValue();
		int launchMin = (int) mins.getValue();
		launchHour = (launchHour * 60) * 60;
		int launchTimeSecs = launchHour + launchMin;
		long LTS = launchTimeSecs;
		System.out.println(launchDateEpoch + LTS);
		System.out.println(System.currentTimeMillis()/1000);

		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MapBox.setLatLng(getLat(), getLog());
		WeatherTabController wtc = loader.getController();
			wtc.setLAT(getLat());
			wtc.setLOG(getLog());

//			Stage stage = (Stage) lat.getScene().getRoot().getScene().getWindow();
//
//			stage.setScene(root.getScene());

			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();


	}


	public double getLat() {
		return Double.parseDouble(lat.getText());
	}

	public double getLog() {
		return Double.parseDouble(log.getText());
	}

    public org.group11.model.config.configData getConfigData() {
        return configData;
    }
}
