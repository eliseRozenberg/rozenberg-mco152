package rozenberg.morsecode;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {

	private Map<String, String> map;

	public MorseCode() {
		map = new HashMap<String, String>(26);
		// ".-,-...,-.-.,-..,.,..-.,--.,....,..,.---,-.-,.-..,--,-.,---,.--.,--.-,.-.,...,-,..-,...-,.--,-..-,-.--,--..")
		map.put("a", ".-");
		map.put("b", "-...");
		map.put("c", "-.-.");
		map.put("d", "-..");
		map.put("e", ".");
		map.put("f", "..-.");
		map.put("g", "--.");
		map.put("h", "....");
		map.put("i", "..");
		map.put("j", ".---");
		map.put("k", "-.-");
		map.put("l", ".-..");
		map.put("m", "--");
		map.put("n", "-.");
		map.put("o", "---");
		map.put("p", ".--.");
		map.put("q", "--.-");
		map.put("r", ".-.");
		map.put("s", "...");
		map.put("t", "-");
		map.put("u", "..-");
		map.put("v", "...-");
		map.put("w", ".--");
		map.put("x", "-..-");
		map.put("y", "-.--");
		map.put("z", "--..");
		map.put("1", ".----");
		map.put("2", "..---");
		map.put("3", "...--");
		map.put("4", "....-");
		map.put("5", ".....");
		map.put("6", "-....");
		map.put("7", "--...");
		map.put("8", "---..");
		map.put("9", "----.");
		map.put("0", "-----");
		map.put(".-", "a");
		map.put("-...", "b");
		map.put("-.-.", "c");
		map.put("-..", "d");
		map.put(".", "e");
		map.put("..-.", "f");
		map.put("--.", "g");
		map.put("....", "h");
		map.put("..", "i");
		map.put(".---", "j");
		map.put("-.-", "k");
		map.put(".-..", "l");
		map.put("--", "m");
		map.put("-.", "n");
		map.put("---", "o");
		map.put(".--.", "p");
		map.put("--.-", "q");
		map.put(".-.", "r");
		map.put("...", "s");
		map.put("-", "t");
		map.put("..-", "u");
		map.put("...-", "v");
		map.put(".--", "w");
		map.put("-..-", "x");
		map.put("-.--", "y");
		map.put("--..", "z");
		map.put(".----", "1");
		map.put("..---", "2");
		map.put("...--", "3");
		map.put("....-", "4");
		map.put(".....", "5");
		map.put("-....", "6");
		map.put("--...", "7");
		map.put("---..", "8");
		map.put("----.", "9");
		map.put("-----", "0");
	}

	public String encode(String message) {
		String[] words = message.split(" ");
		String[] letters;
		StringBuilder builder = new StringBuilder();

		// go through every word
		for (int i = 0; i < words.length; i++) {

			// put each word into an array
			letters = words[i].split("");
			for (int j = 0; j < letters.length; j++) {
				builder.append(map.get(letters[j].toLowerCase()) + " ");
			}
			// add 3 spaces if more words after
			builder.append("  ");
		}
		return builder.toString().trim();
	}// end encode

	public String decode(String code) {
		String[] morseWords = code.split("   ");
		String[] morseLetters;
		StringBuilder builder = new StringBuilder();

		// go through every morse word
		for (int i = 0; i < morseWords.length; i++) {

			// put each word into an array
			morseLetters = morseWords[i].split(" ");

			// go through the letters in the word
			for (int j = 0; j < morseLetters.length; j++) {
				builder.append(map.get(morseLetters[j]));
			}
			builder.append(" ");
		}

		return builder.toString().trim();
	}// end decode
}
