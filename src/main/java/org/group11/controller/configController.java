package org.group11.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.group11.App;
import org.group11.model.config.configData;


import java.io.IOException;

public class configController {

	@FXML
	private TextField lat;
	@FXML
	private TextField log;

	private configData configData;

	public configController() {

	}

	@FXML
	public void saveConfig(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(App.class.getResource("WeatherTabv2.fxml"));


		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		WeatherTabController wtc = loader.getController();
			wtc.setLAT(getLat());
			wtc.setLOG(getLog());

			Stage stage = new Stage();
			stage.setScene(new Scene(root));

			stage.setTitle("TEST");
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
