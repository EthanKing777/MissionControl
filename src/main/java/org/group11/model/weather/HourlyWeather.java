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
 ]
 The hourly data is an array of each hour for 48 hours.
 **/
public class HourlyWeather {

    private final long unixTime;
    private final double temperature;
    private final long pressure;
    private final long humidity;
    private final double windSpeed;
    private final long windDegrees; // meteorological
    private final GeneralWeather generalWeather;

    public HourlyWeather(long unixTime, double temperature, long pressure, long humidity, double windSpeed, long windDegrees, GeneralWeather generalWeather) {
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
    public static class GeneralWeather {
        private final String main;
        private final String description;

        public GeneralWeather(String main, String description) {
            this.main = main;
            this.description = description;
        }

        @Override
        public String toString() {
            return "GeneralWeather{" +
                    "main='" + main + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    public long getUnixTime() {
        return unixTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public long getPressure() {
        return pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public long getWindDegrees() {
        return windDegrees;
    }

    public GeneralWeather getGeneralWeather() {
        return generalWeather;
    }

    @Override
    public String toString() {
        return "HourlyWeather{" +
                "unixTime=" + unixTime +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windDegrees=" + windDegrees +
                ", generalWeather=" + generalWeather +
                '}';
    }
}
