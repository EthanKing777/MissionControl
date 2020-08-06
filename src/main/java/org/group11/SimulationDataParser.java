package org.group11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulationDataParser {

	private String[] headers;
	private List <String> totalDataSet;
	
	public SimulationDataParser() {
		try {
			//ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			//File file = new File(classLoader.getResource("open-rocket-export/test1.csv").getFile());
			File file = new File("test_1.csv");
			Scanner scan = new Scanner (file);
			headers = new String[14]; //There are 14 headers in the test_1.csv file
			totalDataSet = new ArrayList <String> ();
			this.extractData(scan);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void extractData(Scanner scan) {	
		int i=0;
		while(scan.hasNext()) {
			if(scan.hasNext("#")) {
				scan.next();//Skip the # token
				headers[i] = scan.nextLine();
				i++;
			}
			else {
				totalDataSet.add(scan.nextLine());
			}
		}
	}
	
	public String[] getHeaders() {
		return this.headers; 
	}
	
	public List<Number> getVariableData (String type){
		String[] variables;
		List<Number> selectedVariableData = new ArrayList <Number> ();
		int index = -1;
		
		if(type.equalsIgnoreCase("time")) {
			index = 0;
		}else if(type.equalsIgnoreCase("total velocity")) {
			index = 4;
		}else if(type.equalsIgnoreCase("total acceleration")) {
			index = 5;
		}
		
		for(int i=0; i<totalDataSet.size(); i++) {
			variables = totalDataSet.get(i).split(",");
			selectedVariableData.add(Double.parseDouble(variables[index]));
		} 
		
		return selectedVariableData;
	}
}

