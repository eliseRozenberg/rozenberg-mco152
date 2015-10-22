package rozenberg.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

public class TopTenLocation {

	public static void main(String[] args) throws IOException {

		final BufferedReader input = new BufferedReader(new FileReader("./ufo_awesome.json"));
		final Gson gson = new Gson();
		final UFOSightingList array = gson.fromJson(input, UFOSightingList.class);

		HashMap<String, Integer> unsortedMap = new HashMap<String, Integer>();
		for (UFOSighting sight : array) {
			String location = sight.getLocation();
			Integer value = unsortedMap.get(location);
			if (value == null) {
				unsortedMap.put(location, 1);
			} else {
				unsortedMap.put(location, value + 1);
			}
		}
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);

		// go threw a for loop to break after 10....
		int count = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			if (count == 10) {
				break;
			}
			System.out.println(entry.getValue() + " " + entry.getKey());
			count++;
		}
	}
}
