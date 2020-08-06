package org.group11.controller;

import java.io.IOException;

import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;

import javafx.fxml.FXML;

/**
 * Controller for the weather tab. This controller will
 * have access to a weather api to fetch weather data and control
 * the GUI inside the weather tab.
 */
public class WeatherTabController {
	
    /* Weather Tab Parameters */

    // Gives access to the weather data.
    private WeatherData weatherData;

    
	public WeatherTabController() {
		getWeatherData();
	}
	
	/* ==== Weather Tab Methods ==== */
    @FXML
    public void getWeatherData() {
        // NOTE: The lat and lon values will be obtained from a form.
        // Fetches and parses the weather data.
        WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(41.0, -41.0);

        try {
            weatherData = wdfp.fetchWeatherData();
        } catch (IOException e) {

        }
    }

    @FXML
    public void displayWeatherData() {
    	System.out.println("*********  Start of WeatherTabController Output  ********* \n");
        for (HourlyWeather hourlyWeather : weatherData.getHourlyData()) {
            System.out.println(hourlyWeather.toString());
        }
        System.out.println("\n *********  End of WeatherTabController Output   **********");
    }

}
