package org.group11.controller.fxcontrollers;

import javafx.beans.property.SimpleStringProperty;

/**
 * Represents a table row that has a column for the property name, and column for the property value.
 */
public class PropertyTableModel {

	/**
	 * The name of the property.
	 */
	private final SimpleStringProperty propertyId;

	/**
	 * The value of the property.
	 */
	private final SimpleStringProperty propertyValue;

	/**
	 * Constructor.
	 * @param propertyId The name of the property.
	 * @param propertyValue The value of the property.
	 */
	public PropertyTableModel(String propertyId, String propertyValue) {
		this.propertyId = new SimpleStringProperty(propertyId);
		this.propertyValue = new SimpleStringProperty(propertyValue);
	}

	/**
	 * Gets the name of the property.
	 * @return A {@link SimpleStringProperty} that contains the name of the property.
	 */
	public SimpleStringProperty getPropertyId() {
		return this.propertyId;
	}

	/**
	 * Gets the value of the property.
	 * @return A {@link SimpleStringProperty} that contains the value of the property.
	 */
	public SimpleStringProperty getPropertyValue() {
		return this.propertyValue;
	}
}
