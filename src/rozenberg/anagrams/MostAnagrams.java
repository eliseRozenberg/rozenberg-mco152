package rozenberg.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagrams {

	public static void main(String[] args) throws FileNotFoundException {

		HashMap<String, Integer> mapSorted = new HashMap<String, Integer>();
		HashMap<String, String> map = new HashMap<String, String>();
		char[] word;
		String key;
		String temp = null;
		Scanner input = new Scanner(new File("./US.dic"));

		// go through file
		while (input.hasNext()) {
			temp = input.next();
			// put into array of characters
			word = temp.toCharArray();

			// sort characters
			char holder;
			boolean swapped;
			do {
				swapped = false;
				for (int start = 0; start < word.length - 1; start++) {
					if (word[start] > word[start + 1]) {
						holder = word[start];
						word[start] = word[start + 1];
						word[start + 1] = holder;
						swapped = true;
					} // end if
				} // end for

			} while (swapped);
			// end sort

			// put char array into String
			key = String.valueOf(word);
			// put into map with unsorted word version
			map.put(temp, key);
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
		temp = null;
		//run through sorted for most common anagram
		for (Map.Entry<String, Integer> entry : mapSorted.entrySet()) {
			if (entry.getValue() > largest) {
				largest = entry.getValue();
				temp = entry.getKey();
			}
		}
		//run through to find words of most common anagram
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue().equals(temp)) {
				System.out.println(entry.getKey());
			}
		}

	}// end main
}// end class
