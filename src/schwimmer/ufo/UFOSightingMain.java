package schwimmer.ufo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {
		// maven repository

		// final to indicate that it shouldnt be changed
		final BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));
		final Gson gson = new Gson();

		final UFOSightingList array = gson.fromJson(in, UFOSightingList.class);
		System.out.println(array.size());

		in.close();
	}
}
