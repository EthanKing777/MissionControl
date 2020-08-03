package org.group11.model.weather;

/**
{
    "lat": 41.29,
    "lon": 174.78,
    "timezone": "Etc/GMT-12",
    "timezone_offset": 43200,
    "current": {
    "dt": 1596414564,
    "sunrise": 1596388671,
    "sunset": 1596440173,
    "temp": 289.8,
    "feels_like": 289.07,
    "pressure": 1025,
    "humidity": 86,
    "dew_point": 287.45,
    "uvi": 8.48,
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
    ]
 },

 The current weather data is the 'current' object. The next object
 element is the hourly array.
**/
public class CurrentWeather {

    private double unixTime;
    private double temperature;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDegrees; // meteorological
    private GeneralWeather generalWeather;


    public CurrentWeather(double unixTime, double temperature, double pressure, double humidity, double windSpeed, double windDegrees, GeneralWeather generalWeather) {
        this.unixTime = unixTime;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
        this.generalWeather = generalWeather

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

}

