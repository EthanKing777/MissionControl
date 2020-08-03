package org.group11.model.weather;

import java.util.List;

public class WeatherData {

    private List<String> hourlyData;

    public WeatherData(List<String> hourlyData) {
        this.hourlyData = hourlyData;
    }

    public List<String> getHourlyData() {
        return hourlyData;
    }
}
