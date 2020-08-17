package org.group11.controller;

import java.io.IOException;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;

import javafx.fxml.FXML;

/**
 * Controller for the weather tab. This controller will
 * have access to a weather api to fetch weather data and control
 * the GUI inside the weather tab.
 */
public class WeatherTabController {

    @FXML
    private Polygon compassPoint;

    @FXML
    private Text windDir, windDirStr, cloudCoveragePer;

    /* Weather Tab Parameters */

    // Gives access to the weather data.
    private WeatherData weatherData;

    
	public WeatherTabController() {
		getWeatherData();
	}
	
	/* ==== Weather Tab Methods ==== */
    @FXML
    public void getWeatherData() {
        // NOTE: The lat and lon values will be obtained from a form.
        // Fetches and parses the weather data.
        WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(-41.0, 174.0);

        try {
            weatherData = wdfp.fetchWeatherData();
        } catch (IOException e) {

        }
    }

    @FXML
    public void displayWeatherData() {
    	System.out.println("*********  Start of WeatherTabController Output  ********* \n");
        for (HourlyWeather hourlyWeather : weatherData.getHourlyData()) {
            System.out.println(hourlyWeather.toString());
        }
        HourlyWeather hourlyWeather =  weatherData.getHourlyData().get(0);
        Double windDirDeg = (double) hourlyWeather.getWindDegrees();
        Double cloudCoverage = hourlyWeather.getCloud();
        compassPoint.setRotate(windDirDeg);
        windDir.setText(windDirDeg + "°");
        if(windDirDeg == 0 || windDirDeg == 360){
            windDirStr.setText("N");
        }else if (windDirDeg == 90){
            windDirStr.setText("E");
        }else if(windDirDeg == 180){
            windDirStr.setText("S");
        }else if(windDirDeg == 270){
            windDirStr.setText("W");
        }else if(windDirDeg > 0 & windDirDeg <90){
            windDirStr.setText("NE");
        }else if(windDirDeg > 90 && windDirDeg < 180){
            windDirStr.setText("SE");
        }else if(windDirDeg > 180 && windDirDeg < 270){
            windDirStr.setText("SW");
        }else if(windDirDeg > 270 && windDirDeg < 360){
            windDirStr.setText("NW");
        }
        //cloudCoveragePer.setText(cloudCoverage +"%");
        System.out.println("\n *********  End of WeatherTabController Output   **********");
    }

}
