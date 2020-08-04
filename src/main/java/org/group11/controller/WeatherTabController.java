package org.group11.controller;

import javafx.fxml.FXML;
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
public class WeatherTabController {

    private static final String WEATHER_API = "https://api.openweathermap.org/data/2.5/onecall?units=metric";
    private static final String API_KEY = "26b3148a49fb064524db01c060d26f3f";

    private double latitude;
    private double longitude;

    private WeatherData weatherData;

    public WeatherTabController() {
    }

    /**
     * Fetches weather data from openweathermap API.
     *
     * @param latitude - Latitude of location.
     * @param longitude - Longitude of location.
     * @return - The weather data fetched.
     * @throws IOException - Throws when can't connect to API.
     */
    @FXML
    public String fetchWeatherData(double latitude, double longitude) throws IOException {
        updateLocation(latitude, longitude);

        String weatherData = downloadWeatherData();
        parseWeatherData(weatherData);

        return weatherData;
    }

    /**
     * Parses the fetched weather data into weather model.
     *
     * @param weatherData - The weather data fetched.
     */
    private void parseWeatherData(String weatherData)  {
        try {
            // parse fetched weather data.
            Object obj = new JSONParser().parse(weatherData);
            JSONObject mainObject = (JSONObject) obj;

            // Iterate through hourly array and store in WeatherData class.
            JSONArray hourlyArray = (JSONArray) mainObject.get("hourly");
            List<JSONObject> hourlyData = new ArrayList<>();
            for (Object o : hourlyArray) {
                hourlyData.add((JSONObject) o);
            }
            this.weatherData = new WeatherData(hourlyData);

        } catch (ParseException e) {
            System.out.println("Parse Exception! " + e);
        }
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
