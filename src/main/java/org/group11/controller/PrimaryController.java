package org.group11.controller;

import javafx.fxml.FXML;
import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the weather tab. This controller will
 * have access to a weather api to fetch weather data and control
 * the GUI inside the weather tab.
 */
public class PrimaryController {

    /* Weather Tab Parameters */

    // Fetches and parses the weather data.
    private WeatherDataFetcherParser weatherDataFetcherParser;

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
        weatherDataFetcherParser = new WeatherDataFetcherParser(41.0, -41.0);

        try {
            weatherData = weatherDataFetcherParser.fetchWeatherData();
        } catch (IOException e) {

        }
    }



    /* ====  Tab Methods ==== */


    /* ====  Tab Methods ==== */
}

