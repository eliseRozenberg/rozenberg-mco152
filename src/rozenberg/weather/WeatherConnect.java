package rozenberg.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherConnect {
	private WeatherInfo info;

	public void getWeatherInfo(String zip) throws IOException, InvalidZipException {

		StringBuilder builder = new StringBuilder();
		builder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zip);
		builder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		URL url = new URL(builder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		info = gson.fromJson(reader, WeatherInfo.class);
		if (info.getName() == null) {
			throw new InvalidZipException();
		}
	}

	public double getTemp() {
		return info.getMain().getTemp();
	}

	public double getHumidity() {
		return info.getMain().getHumidity();
	}

	public String getDescription() {
		return this.info.getWeather()[0].getDescription();
	}

	public String getIcon() {
		return this.info.getWeather()[0].getIcon();
	}

	public String getName() {
		return this.info.getName();
	}
}
