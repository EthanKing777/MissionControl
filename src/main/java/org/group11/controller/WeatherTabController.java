package org.group11.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import org.group11.controller.weather.WeatherDataFetcherParser;
import org.group11.model.config.configData;
import org.group11.model.weather.HourlyWeather;
import org.group11.model.weather.WeatherData;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Controller for the weather tab. This controller will
 * have access to a weather api to fetch weather data and control
 * the GUI inside the weather tab.
 */
public class WeatherTabController {

    private configData configData;

    private double LAT;
    private double LOG;

    /* Weather Tab Parameters */
    @FXML
    private Polygon compassPoint;

    @FXML
    private Text windDir, windDirStr, cloudCoveragePer, latValue, longValue, cloudCoverage;

    @FXML
    private LineChart<String, Double> windSpeedChart;

    @FXML
    private LineChart<String, Long> windDirectionChart;



    // Gives access to the weather data.
    private WeatherData weatherData;


	public WeatherTabController() {
	}

	/* ==== Weather Tab Methods ==== */
    @FXML
    public void getWeatherData() {
        // NOTE: The lat and lon values will be obtained from a form.
        // Fetches and parses the weather data.
        WeatherDataFetcherParser wdfp = new WeatherDataFetcherParser(LAT, LOG);

        try {
            weatherData = wdfp.fetchWeatherData();
        } catch (IOException e) {
            System.err.println(e + ":: Error when fetching weather data.");
        }
    }

    @FXML
    public void displayWeatherData() {
        getWeatherData();
        System.out.println("Lat: " + getLat()+  " Log: " + getLog());
    	System.out.println("*********  Start of WeatherTabController Output  ********* \n");
        for (HourlyWeather hourlyWeather : weatherData.getHourlyData()) {
            System.out.println(hourlyWeather.toString());
        }
        HourlyWeather hourlyWeather =  weatherData.getHourlyData().get(0);
        Double windDirDeg = (double) hourlyWeather.getWindDegrees();
        Double cloudCoverageValue = hourlyWeather.getCloud();
        if(cloudCoverageValue >= 0 && cloudCoverageValue <= 5){
            cloudCoverage.setText("Clear");
        }else if( cloudCoverageValue >= 6 && cloudCoverageValue <= 25 ){
            cloudCoverage.setText("Mostly Clear");
        }else if (cloudCoverageValue >= 26 && cloudCoverageValue <= 50){
            cloudCoverage.setText("Partly Cloudy");
        }else if(cloudCoverageValue >= 51 && cloudCoverageValue <= 69){
            cloudCoverage.setText("Mostly Cloudy");
        }else if(cloudCoverageValue >= 70 && cloudCoverageValue <= 87){
            cloudCoverage.setText("Considerable Cloudiness");
        }else {
            cloudCoverage.setText("Overcast");
        }
        cloudCoveragePer.setText(cloudCoverageValue + "%");
        latValue.setText(getLat() + "");
        longValue.setText(getLog()+ "");
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

        windDirectionChart.getData().clear();
        windSpeedChart.getData().clear();

        populateWindSpeedChart();
        populateWindDirectionChart();
        System.out.println("\n *********  End of WeatherTabController Output   **********");
    }

    /**
     *
     */
    public void populateWindSpeedChart() {
        XYChart.Series<String, Double> windSpeedSeries = new XYChart.Series<>();

        List<Double> allWindSpeeds = new ArrayList<>();
        List<Long> allHours = new ArrayList<>();
        for(HourlyWeather hour : weatherData.getHourlyData()) {
            allWindSpeeds.add(hour.getWindSpeed());
            allHours.add(hour.getUnixTime());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        for(int i = 0; i < allHours.size(); i++) {
            windSpeedSeries.getData().add(new XYChart.Data<>(sdf.format(allHours.get(i)*1000), allWindSpeeds.get(i)));
            System.out.println(sdf.format(allHours.get(i)*1000) + " " + allWindSpeeds.get(i));
        }

        windSpeedChart.setAnimated(false);
        windSpeedChart.getData().add(windSpeedSeries);
    }

    /**
     *
     */
    public void populateWindDirectionChart() {
        XYChart.Series<String, Long> windDirectionSeries = new XYChart.Series<>();

        List<Long> allWindDirections = new ArrayList<>();
        List<Long> allHours = new ArrayList<>();
        for(HourlyWeather hour : weatherData.getHourlyData()) {
            allWindDirections.add(hour.getWindDegrees());
            allHours.add(hour.getUnixTime());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        for(int i = 0; i < allHours.size(); i++) {
            windDirectionSeries.getData().add(new XYChart.Data<>(sdf.format(allHours.get(i)*1000), allWindDirections.get(i)));
        }

        windDirectionChart.setAnimated(false);
        windDirectionChart.getData().add(windDirectionSeries);
    }



    public double getLog() {
        return LOG;
    }

    public double getLat() {
        return LAT;
    }

    public void setConfigData(org.group11.model.config.configData configData) {
        this.configData = configData;
    }

    public void setLAT(double LAT) {
        this.LAT = LAT;
    }

    public void setLOG(double LOG) {
        this.LOG = LOG;
    }

    public void setTime(){

    }
}
