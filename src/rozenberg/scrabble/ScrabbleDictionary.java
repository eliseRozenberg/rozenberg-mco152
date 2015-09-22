package rozenberg.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {
	private HashSet<String> words;

	public ScrabbleDictionary() throws FileNotFoundException {
		// scan file into an array into the constructor
		words = new HashSet<String>();
		Scanner input = new Scanner(new File("./US.dic"));
		while (input.hasNext()) {
			words.add(input.next());
		}
		input.close();
	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */
	public boolean contains(String word) {
		return words.contains(word);
	}
}
