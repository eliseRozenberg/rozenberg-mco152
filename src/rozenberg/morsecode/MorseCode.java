

package rozenberg.morsecode;

import java.util.Arrays;

public class MorseCode {

	private char[] alphabet;
	private String[] morse;

	public MorseCode() {
		alphabet = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
		morse = ("._,_...,_._.,_..,.,.._.,__.,....,..,.___,_._,._..,__,_.,___,.__.,__._,._.,...,_,.._,..._,.__,_.._,_.__,__..")
				.split(",");
	}

	public String encode(String message) {
		String[] words = message.split(" ");
		char[] letters;
		String encodedMessage = "";

		// go through every word
		for (int i = 0; i < words.length; i++) {

			// put each word into an array
			letters = words[i].toCharArray();
			
			// go through the letters in the word
			for (int j = 0; j < letters.length; j++) {

				// compare each letter to the alphabet
				for (int r = 0; r < alphabet.length; r++) {

					if ((Character.toUpperCase(alphabet[r]) == letters[j])
							|| (alphabet[r] == letters[j])) {
						encodedMessage += (morse[r] + " ");
						break;
					}// end if

				}// end for

			}
			// add 3 spaces if more words after
			if (i < words.length) {
				encodedMessage = encodedMessage + "  ";
			}
		}
		return encodedMessage.trim();
	}// end encode
		// how do i make sure it has the required spaces

	public String decode(String code) {
		String[] morseWords = code.split("   ");
		String[] morseLetters;
		String decodedMessage = "";

		// go through every morse word
		for (int i = 0; i < morseWords.length; i++) {

			// put each word into an array
			morseLetters = morseWords[i].split(" ");
		
			// go through the letters in the word
			for (int j = 0; j < morseLetters.length; j++) {
				
				// compare each letter to the alphabet
				for (int r = 0; r < morse.length; r++) {

					if (morseLetters[j].equalsIgnoreCase(morse[r])) {
						decodedMessage = decodedMessage + (alphabet[r]);
						break;
					}

				}

			}
	
			if (i < morseWords.length) {
				decodedMessage = decodedMessage.concat(" ");
			}
		}
		return decodedMessage.trim();
	}// end encode

}
