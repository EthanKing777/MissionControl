package org.group11;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class SimulationTabController {

	 @FXML
	    private void plotSimulationData(ActionEvent e) throws IOException{
		 	App.setRoot("SimulationTab");
	        System.out.println("Button Pressed");
	    }
}
