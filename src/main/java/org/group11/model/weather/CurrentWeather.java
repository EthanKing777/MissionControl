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

 The current weather data are the first lot of elements in the object. The next
 element is the hourly array.
**/
public class CurrentWeather {
}
