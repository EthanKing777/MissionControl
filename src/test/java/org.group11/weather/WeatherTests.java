package org.group11.weather;

import java.io.IOException;
import java.util.List;

import org.group11.controller.PrimaryController;
import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class WeatherTests {

    @Test
    public void testFetchingData() {
        try {
            WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(-0, -0);
            WeatherData weatherData = wdfp.fetchWeatherData();
            // Test weather info is fetched and parsed as expected.
            Assert.assertNotNull(weatherData);
            List<HourlyWeather> hours = weatherData.getHourlyData();
            // Test number of hours is 48
            Assert.assertEquals(48, hours.size());
        } catch (IOException e) {
            System.out.println(e + ":: Error Fetching WeatherData");
        }
    }

    @Test
    public void invalidLat() {
        try {
            WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(100, 0);
            WeatherData weatherData = wdfp.fetchWeatherData();
            Assert.assertEquals(0, weatherData.getHourlyData().size());
        } catch (IOException e) {
            System.out.println(e + ":: Error Fetching WeatherData");
        }
    }

    @Test
    public void invalidLong() throws IOException {
        try {
            WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(0, 190);
            WeatherData weatherData = wdfp.fetchWeatherData();
            Assert.assertEquals(0, weatherData.getHourlyData().size());
        } catch (IOException e) {
            System.out.println(e + ":: Error Fetching WeatherData");
        }

    }

}
