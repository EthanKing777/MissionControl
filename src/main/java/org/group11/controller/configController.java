package org.group11.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.group11.model.config.configData;

public class configController {

	@FXML
	private TextField lat;
	@FXML
	private TextField log;

	private configData configData;

	public configController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	public void saveConfig(ActionEvent event) {
		System.out.println("\n Config - Test Button Pressed \n");
		configData = new configData(getLat(), getLog(), true, true);
		System.out.print(configData.getLAT());
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
