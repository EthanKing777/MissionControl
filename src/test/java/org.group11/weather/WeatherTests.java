package org.group11.weather;

import java.io.IOException;

import org.group11.controller.PrimaryController;
import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.weather.WeatherData;
import org.junit.jupiter.api.Test;

public class WeatherTests {

    @Test
    public void testFetchingData()  {
        try {
            WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(-0, -0);
            WeatherData weatherData = wdfp.fetchWeatherData();
        } catch (IOException e) {
            System.out.println(e + ":: Error Fetching WeatherData");
        }
    }

    @Test
    public void invalidLat()  {
        try {
            WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(100, 0);
            WeatherData weatherData = wdfp.fetchWeatherData();
        } catch (IOException e) {
            System.out.println(e + ":: Error Fetching WeatherData");
        }
    }

    @Test
    public void invalidLong() throws IOException {
            WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(0, 190);
            WeatherData weatherData = wdfp.fetchWeatherData();
    }

}
