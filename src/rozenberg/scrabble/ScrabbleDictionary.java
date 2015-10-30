package rozenberg.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {
	private HashSet<String> words;
	/*private static ScrabbleDictionary singleton;


	public static ScrabbleDictionary getInstance() throws IOException {
		if (singleton == null) {
			singleton = new ScrabbleDictionary();
		}
		return singleton;
	}
	private ScrabbleDictionary() throws IOException{
	*/
	public ScrabbleDictionary() throws IOException {
		// scan file into an array into the constructor
		words = new HashSet<String>();
		BufferedReader input = new BufferedReader(new FileReader("./US.dic"));
		String line;
		while ((line = input.readLine()) != null) {
			words.add(line);
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
