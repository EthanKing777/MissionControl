package org.group11.model.weather;

import java.util.List;

public class WeatherData {

    private final List<HourlyWeather> hourlyData;

    public WeatherData(List<HourlyWeather> hourlyData) {
        this.hourlyData = hourlyData;
    }

    public List<HourlyWeather> getHourlyData() {
        return hourlyData;
    }
}
