package rozenberg.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScrabbleDictionary {
	private ArrayList<String> words;

	public ScrabbleDictionary() throws FileNotFoundException {
		// scan file into an array into the constructor
		words = new ArrayList<String>();
		Scanner input = new Scanner(new File("./US.dic"));
		String temp;
		while (input.hasNext()) {
			temp = input.next();
			words.add(temp);
		}
		input.close();
		Collections.sort(words);
	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */
	public boolean contains(String word) {
		return words.contains(word);
	}
}
