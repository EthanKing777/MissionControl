package org.group11.controller;

import javafx.fxml.FXML;
import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;

import java.io.*;


/**
 * Controller for the weather tab. This controller will
 * have access to a weather api to fetch weather data and control
 * the GUI inside the weather tab.
 */
public class PrimaryController {

    /* Weather Tab Parameters */

    // Gives access to the weather data.
    private WeatherData weatherData;



    /*  Tab Parameters */


    /*  Tab Parameters */

    public PrimaryController() {
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
        System.out.println("DONE");
    }

    @FXML
    public void displayWeatherData() {
        for (HourlyWeather hourlyWeather : weatherData.getHourlyData()) {
            System.out.println(hourlyWeather.toString());
        }
    }



    /* ====  Tab Methods ==== */


    /* ====  Tab Methods ==== */
}

