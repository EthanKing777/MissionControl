package org.group11.controller;

import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Controller for the weather tab. This controller will
 * have access to a weather api to fetch weather data and control
 * the GUI inside the weather tab.
 */
public class WeatherTabController {

    private static final String WEATHER_API = "https://api.openweathermap.org/data/2.5/onecall?units=metric";
    private static final String API_KEY = "26b3148a49fb064524db01c060d26f3f";

    private double latitude;
    private double longitude;

    public WeatherTabController() {
    }

    @FXML
    public String fetchWeatherData(double latitude, double longitude) throws IOException {
        updateLocation(latitude, longitude);
        parseWeatherData();

        return downloadWeatherData();
    }

    private void parseWeatherData() {

    }

    private String downloadWeatherData() throws IOException {
        String requestURL = WEATHER_API + "&lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;

        HttpURLConnection connection = (HttpURLConnection) new URL(requestURL).openConnection();

        return readInputStream(connection.getInputStream());
    }

    private String readInputStream(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder output = new StringBuilder();
        String currentLine;

        //Read the entire input stream
        while ((currentLine = reader.readLine()) != null) {
            output.append(currentLine);
        }

        return output.toString();
    }

    private void updateLocation(double lat, double lng) {
        this.latitude = lat;
        this.longitude = lng;
    }


}
