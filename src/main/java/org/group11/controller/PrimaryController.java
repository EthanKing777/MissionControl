package org.group11.controller;

import javafx.fxml.FXML;
import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;
import org.group11.model.config.configData;

import java.io.*;


public class PrimaryController {

    public PrimaryController() {
        configController cc = new configController();
        WeatherTabController wtc = new WeatherTabController();
        FlightTabController ftc = new FlightTabController();
        PreLaunchScreenController plsc = new PreLaunchScreenController();
    }

}

