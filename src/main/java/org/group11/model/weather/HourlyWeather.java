package org.group11.model.weather;

/**
 "hourly": [
    {
        "dt": 1596412800,
        "temp": 289.8,
        "feels_like": 289.07,
        "pressure": 1025,
        "humidity": 86,
        "dew_point": 287.45,
        "clouds": 39,
        "visibility": 10000,
        "wind_speed": 3,
        "wind_deg": 3,
        "weather": [
            {
                "id": 802,
                "main": "Clouds",
                "description": "scattered clouds",
                "icon": "03d"
            }
            ],
        "pop": 0
    },

 The hourly data is an array of each hour for 48 hours.
 **/
public class HourlyWeather {

    private double unixTime;
    private double temperature;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDegrees; // meteorological
    private CurrentWeather generalWeather;

    public HourlyWeather(double unixTime, double temperature, double pressure, double humidity, double windSpeed, double windDegrees, CurrentWeather generalWeather) {
        this.unixTime = unixTime;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
        this.generalWeather = generalWeather;

    }

    /**
     * Contains basic weather information.
     */
    private static class GeneralWeather {

        private String main;
        private String description;

        public GeneralWeather(String main, String description) {
            this.main = main;
            this.description = description;
        }
    }

    public double getUnixTime() {
        return unixTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDegrees() {
        return windDegrees;
    }

    public CurrentWeather getGeneralWeather() {
        return generalWeather;
    }
}
