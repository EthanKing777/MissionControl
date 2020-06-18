import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDownloader {
	private static final String WEATHER_API = "https://api.openweathermap.org/data/2.5/onecall?units=metric";
	private final static String API_KEY = "26b3148a49fb064524db01c060d26f3f";

	private double lat; //Latitude
	private double lng; //Longitude

	public static void main(String[] args) throws IOException {
		System.out.println(new WeatherDownloader().downloadWeatherData());
	}

	private String downloadWeatherData() throws IOException {
		String requestURL = WEATHER_API + "&lat=" + lat + "&lon=" + lng + "&appid=" + API_KEY;

		HttpURLConnection connection = (HttpURLConnection)new URL(requestURL).openConnection();
		String weatherData = readInputStream(connection.getInputStream()); //Read the data returned by the API


		return weatherData;
	}

	public String readInputStream(InputStream stream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String output = "";
		String currentLine;

		//Read the entire input stream
		while ((currentLine = reader.readLine()) != null) {
			output += currentLine;
		}

		return output;
	}

	public void updateLocation(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
}
