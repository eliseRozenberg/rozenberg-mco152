package rozenberg.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostAnagrams {

	public static void main(String[] args) throws IOException {

		HashMap<String, Integer> mapSorted = new HashMap<String, Integer>();
		HashMap<String, String> map = new HashMap<String, String>();
		char[] word;
		String key;
		BufferedReader input = new BufferedReader(new FileReader("./US.dic"));
		String line;
		// go through file
		while ((line = input.readLine()) != null) {
			// put into array of characters
			word = line.toCharArray();
			Arrays.sort(word);

			// put char array into String
			key = String.valueOf(word);
			// put into map with unsorted word version
			map.put(line, key);
			// put into sorted - check for duplicate
			Integer value = mapSorted.get(key);
			if (value == null) {
				mapSorted.put(key, 1);
			} else {
				mapSorted.put(key, value + 1);
			}
		}
		input.close();

		int largest = 0;
		line = null;
		// run through sorted for most common anagram
		for (Map.Entry<String, Integer> entry : mapSorted.entrySet()) {
			if (entry.getValue() > largest) {
				largest = entry.getValue();
				line = entry.getKey();
			}
		}
		// run through to find words of most common anagram
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue().equals(line)) {
				System.out.print(entry.getKey() + " ");
			}
		}

	}// end main
}// end class
