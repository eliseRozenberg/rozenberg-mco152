package rozenberg.contactList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import rozenberg.weather.InvalidZipException;
import rozenberg.weather.WeatherInfo;

public class ContactConnect {
	private ContactList list;
	
	public void getContactInfo() throws IOException{
		URL url = new URL("http://jsonplaceholder.typicode.com/users");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		list = gson.fromJson(reader, WeatherInfo.class);
	}
	
	

}
