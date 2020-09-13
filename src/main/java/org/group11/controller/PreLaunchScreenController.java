package org.group11.controller;

import javafx.fxml.FXML;
import org.group11.model.config.configData;

public class PreLaunchScreenController {

	public PreLaunchScreenController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	public void printArmButtonOutput() {
		System.out.println("\n PreLaunchScreenController - ARM Button Pressed \n");
	}
	
	@FXML
	public void printGoNoGoButtonOutput() {
		System.out.println("\n PreLaunchScreenController - Go/No-Go Button Pressed \n");
	}
}
