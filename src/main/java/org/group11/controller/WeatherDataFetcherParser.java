package org.group11.controller;

import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Allows the controller to fetch and parse the weather data.
 * Has one public method for this task.
 */
public class WeatherDataFetcherParser {

    private static final String WEATHER_API = "https://api.openweathermap.org/data/2.5/onecall?units=metric";
    private static final String API_KEY = "26b3148a49fb064524db01c060d26f3f";

    private double latitude;
    private double longitude;

    public WeatherDataFetcherParser(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Fetches weather data from openweathermap API.
     *
     * @throws IOException - Throws when can't connect to API.
     */
    public WeatherData fetchWeatherData() throws IOException {
        updateLocation(latitude, longitude);

        String weatherData = downloadWeatherData();

        return parseWeatherData(weatherData);
    }

    /**
     * Parses the fetched weather data into weather model.
     *
     * @param weatherDataString - The weather data fetched.
     */
    private WeatherData parseWeatherData(String weatherDataString) {
        WeatherData weatherData = new WeatherData(null);
        try {
            // parse fetched weather data.
            Object obj = new JSONParser().parse(weatherDataString);
            JSONObject mainObject = (JSONObject) obj;

            // Iterate through hourly array and store in WeatherData class.
            JSONArray hourlyArray = (JSONArray) mainObject.get("hourly");
            List<HourlyWeather> hourlyData = new ArrayList<>();
            for (int i = 0; i < hourlyArray.size(); i++) {
                JSONObject hour = (JSONObject) hourlyArray.get(i);
                JSONArray hourGeneralWeather = (JSONArray) hour.get("weather");
                JSONObject firstGeneral = (JSONObject) hourGeneralWeather.get(0);

                // Create hourly weather instance.
                HourlyWeather hourlyWeather = new HourlyWeather(
                        (long) hour.get("dt"),
                        Double.parseDouble(hour.get("temp").toString()),
                        (long) hour.get("pressure"),
                        (long) hour.get("humidity"),
                        Double.parseDouble(hour.get("wind_speed").toString()),
                        (long) hour.get("wind_deg"),
                        new HourlyWeather.GeneralWeather(
                                firstGeneral.get("main").toString(),
                                firstGeneral.get("description").toString())
                );

                hourlyData.add(hourlyWeather);
            }
            weatherData = new WeatherData(hourlyData);

        } catch (ParseException e) {
            System.out.println("Parse Exception! " + e);
        }

        return weatherData;
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
