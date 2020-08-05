package org.group11.model.weather;

import java.util.List;

/**
 * This class will store every hour of weather data in an array
 * of HourlyWeather objects, and is used to get the data.
 */
public class WeatherData {

    private final List<HourlyWeather> hourlyData;

    public WeatherData(List<HourlyWeather> hourlyData) {
        this.hourlyData = hourlyData;
    }

    public List<HourlyWeather> getHourlyData() {
        return hourlyData;
    }

}
