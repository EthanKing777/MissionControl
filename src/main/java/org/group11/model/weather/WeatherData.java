package org.group11.model.weather;

import org.json.simple.JSONObject;

import java.util.List;

public class WeatherData {

    private final List<JSONObject> hourlyData;

    public WeatherData(List<JSONObject> hourlyData) {
        this.hourlyData = hourlyData;
    }

    public List<JSONObject> getHourlyData() {
        return hourlyData;
    }
}
