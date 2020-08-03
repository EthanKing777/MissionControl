package org.group11.weather;

import org.group11.controller.WeatherTabController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WeatherTests {

    @Test
    public void testFetchingData()  {
        WeatherTabController weatherTabController = new WeatherTabController();

        try {
            System.out.println(weatherTabController.fetchWeatherData(41.0, -41.0));
        } catch (IOException e) {
            System.out.println("Something went wrong!! " + e);
        }

    }
}
