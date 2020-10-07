package org.group11.ControllerTests;

import org.group11.controller.CreateEditSimulationController;
import org.group11.controller.PropertyTableModel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class CreateEditSimulationTest {

	/**
	 * Reads an example file and checks that the parsed contents are valid.
	 */
	@Test
	public void readRocketPropertiesFile01() throws FileNotFoundException {
		File propertiesFile = new File("src/test/resources/rocket-properties-1.csv"); //Test file
		CreateEditSimulationController controller = new CreateEditSimulationController();

		controller.readSimulationFile(propertiesFile);

		List<PropertyTableModel> parsedProperties = controller.getSimulationTableProperties();

		String[] expectedPropertyValues =
				{ "0.0523599", "1", "up", "2.7", "-41.276825", "171.777969" ,"0.0872665", "0" };

		assert parsedProperties.size() == 8; //8 properties in the CSV file

		for (int i = 0; i < parsedProperties.size(); i++) {
			String currentPropertyValue = parsedProperties.get(i).getPropertyValue().getValue();

			//Assert that the property matches the expected value
			assert currentPropertyValue.equals(expectedPropertyValues[i]);
		}
	}

	/**
	 * Attempts to read an invalid file.
	 * The test passes if the controller throws a {@link FileNotFoundException}, otherwise it fails.
	 */
	@Test
	public void readRocketPropertiesFile02() {
		File propertiesFile = new File(""); //Invalid file direcotry
		CreateEditSimulationController controller = new CreateEditSimulationController();


		try { //An error should be thrown
			controller.readSimulationFile(propertiesFile);
			assert false; //If this point is reached then the test failed (no error was thrown).
		}
		catch (FileNotFoundException e) {
		}
	}

	/**
	 * Tests if the output CSV string for the rocket properties table is valid.
	 * In this case the output CSV string should be equal to the input CSV file (ignoring comments).
	 */
	@Test
	public void rocketPropertiesCSV01() throws  FileNotFoundException {
		File propertiesFile = new File("src/test/resources/rocket-properties-1.csv"); //Invalid file directory
		CreateEditSimulationController controller = new CreateEditSimulationController();


		controller.readSimulationFile(propertiesFile);

		//Assert that the the file parses correctly and the contents are as expected
		assert controller.getRocketPropertiesCSV().equals("0.0523599,1,up,2.7,-41.276825,171.777969,0.0872665,0");
	}

}
