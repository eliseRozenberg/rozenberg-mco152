package rozenberg.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testDecode() {
		MorseCode q = new MorseCode();
		String temp = q.decode(".... ..   -- -.--   -. .- -- .   .. ...   . .-.. .. ... .");
		Assert.assertEquals("hi my name is elise", temp);
		temp = q.decode(
				".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..");
		Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", temp);
	}

	@Test
	public void testEncode() {
		MorseCode q = new MorseCode();
		String temp = q.encode("elisE Is");
		Assert.assertEquals(". .-.. .. ... .   .. ...", temp);

		temp = q.encode("abcdefghijklmnopqrstuvwxyz");
		Assert.assertEquals(
				".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..",
				temp);
	}

}
