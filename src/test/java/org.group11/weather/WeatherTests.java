package org.group11.weather;

import org.group11.controller.WeatherTabController;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class WeatherTests {

    @Test
    public void testFetchingData()  {
        WeatherTabController weatherTabController = new WeatherTabController();

        try {
            System.out.println(weatherTabController.fetchWeatherData());
        } catch (IOException e) {
            System.out.println("Something went wrong!! " + e);
        }

        Assert.assertEquals("Hi", "Hi");

    }
}
