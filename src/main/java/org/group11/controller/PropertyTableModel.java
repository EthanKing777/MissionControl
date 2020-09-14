package org.group11.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PropertyTableModel {
	private final StringProperty propertyId, propertyValue;

	public PropertyTableModel(String propertyId, String propertyValue) {
		this.propertyId = new SimpleStringProperty(propertyId);
		this.propertyValue = new SimpleStringProperty(propertyValue);
	}

	public StringProperty getPropertyId() {
		return this.propertyId;
	}

	public StringProperty getPropertyValue() {
		return this.propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue.set(propertyValue);
	}
}
