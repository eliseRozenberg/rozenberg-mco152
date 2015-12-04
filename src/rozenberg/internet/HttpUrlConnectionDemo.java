package rozenberg.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpUrlConnectionDemo {

	public static void main(String[] args) throws IOException {
		// needs a URL- not s string - URL makes sure that what you put into
		// there is an actual URL
		// working on a level above sockets.

		// malformed URL exception - if not an actual url
		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/weather?zip=10952,us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		//using a buffered reader to read a file - can be on our computer or on a server anywhere in the world
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

}
