package rozenberg.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
		ArrayList<String> largestList = new ArrayList<String>();
		// run through sorted for most common anagram
		for (Map.Entry<String, Integer> entry : mapSorted.entrySet()) {
			if (entry.getValue() > largest) {
				largestList.clear();
				largestList.add(entry.getKey());
				largest = entry.getValue();
			} else if (entry.getValue() == largest) {
				largestList.add(entry.getKey());
			}
		}

		// run through to find words of most common anagram
		for (int i = 0; i < largestList.size(); i++) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				if (entry.getValue().equals(largestList.get(i))) {
					System.out.print(entry.getKey() + " ");
				}
			}
			System.out.println();
		}

	}// end main
}// end class
