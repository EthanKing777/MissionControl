package org.group11;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulationDataParser {

	/**
	 * An array that stores the Headers listed in the .csv file
	 */
	private String[] headers;
	
	/**
	 * An ArrayList which stores the all raw data listed in the csv file. This raw data does not include headers
	 */
	private List <String> totalDataSet;
	
	public SimulationDataParser(File file) {
		try {
//			File file = new File("Simulation Test Data.csv");
			Scanner scan = new Scanner (file);
			headers = new String[14]; //There are 14 headers in the Simulation Test Data.csv file
			totalDataSet = new ArrayList <String> ();
			this.extractData(scan);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Extract data from the csv file and sort them by Headers and Data.
	 * Headers are identified using <code>#</code> symbols and they're stored in a separate list (<code>headers</code>).
	 * Raw data is stored in a separate list (<code>totalDataSet</code>).
	 * 
	 * @param scan scanner object
	 */
	private void extractData(Scanner scan) {	
		int i=0;
		while(scan.hasNext()) {
			if(scan.hasNext("#")) {
				scan.next();//Skip the # token
				headers[i] = scan.nextLine();
				i++;
			}
			else {
				//Here, we're adding one line at a time which contains 53 variables. 
				//At this stage, they're not split by commas
				totalDataSet.add(scan.nextLine());
			}
		}
	}
	
	/**
	 * Return the list of Headers
	 * @return
	 */
	public String[] getHeaders() {
		return this.headers; 
	}
	
	/**
	 * Search for the variable passed as the argument (<code>type</code>) and return a list with every occurrence of that variable
	 * 
	 * @param type The variable to be extracted
	 * 
	 * @return A list containing every occurrence of the variable
	 */
	public List<Number> getVariableData (String type){
		String[] variables;
		List<Number> selectedVariableData = new ArrayList <Number> ();
		int index = -1;
		
		//'index' represents the index of the corresponding header in the headers array. 
		if(type.equalsIgnoreCase("time")) {
			index = 0;
		}else if(type.equalsIgnoreCase("total velocity")) {
			index = 4;
		}else if(type.equalsIgnoreCase("total acceleration")) {
			index = 5;
		}
		
		for(int i=0; i<totalDataSet.size(); i++) {
			//Split the single line containing 53 variables into individual variables
			variables = totalDataSet.get(i).split(",");
			//Then get the variable from each line and parse it as a Double
			selectedVariableData.add(Double.parseDouble(variables[index]));
		} 
		
		return selectedVariableData;
	}
}

