package org.group11.ControllerTests;

import org.group11.controller.PropertyTableModel;
import org.junit.jupiter.api.Test;

public class PropertyTableModelTest {

	/**
	 * Tests that the key and values passed into the PropertyTableModel constructor are saved in the appropriate fields
	 * correctly.
	 */
	@Test
	public void initializationTest01() {
		PropertyTableModel propertyTableModel = new PropertyTableModel("test-key", "test-value");

		assert propertyTableModel.getPropertyId().get().equals("test-key");
		assert propertyTableModel.getPropertyValue().get().equals("test-value");
	}

	/**
	 * Tests that the ID property in the PropertyTableModel class can be modified correctly.
	 */
	@Test
	public void modifyKeyTest01() {
		PropertyTableModel propertyTableModel = new PropertyTableModel("test-key", "test-value");

		propertyTableModel.getPropertyId().set("test-key1");

		assert propertyTableModel.getPropertyId().get().equals("test-key1");
		assert propertyTableModel.getPropertyValue().get().equals("test-value");
	}

	/**
	 * Tests that the value property in the PropertyTableModel class can be modified correctly.
	 */
	@Test
	public void modifyValueTest01() {
		PropertyTableModel propertyTableModel = new PropertyTableModel("test-key", "test-value");

		propertyTableModel.getPropertyValue().set("test-value1");

		assert propertyTableModel.getPropertyId().get().equals("test-key");
		assert propertyTableModel.getPropertyValue().get().equals("test-value1");
	}

	/**
	 * Tests if the clone() method in the PropertyTableModel returns a deep cloned instance of the current class.
	 */
	@Test
	public void testDeepClone01() {
		PropertyTableModel propertyTableModel = new PropertyTableModel("test-key", "test-value");
		PropertyTableModel cloned = propertyTableModel.clone();

		//Changing the value for the cloned instance should not change any values in the first instance
		cloned.getPropertyId().set("test-key1");
		cloned.getPropertyValue().set("test-value1");

		assert propertyTableModel != cloned; //Instances should be different
		assert propertyTableModel.getPropertyId() != cloned.getPropertyId();
		assert propertyTableModel.getPropertyValue() != cloned.getPropertyValue();
		assert propertyTableModel.getPropertyId().get().equals("test-key");
		assert propertyTableModel.getPropertyValue().get().equals("test-value");
		assert cloned.getPropertyId().get().equals("test-key1");
		assert cloned.getPropertyValue().get().equals("test-value1");
	}

}
