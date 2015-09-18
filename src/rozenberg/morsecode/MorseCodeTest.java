package rozenberg.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testDecode() {
		MorseCode q = new MorseCode();
		String temp = q.decode(".... ..   __ _.__   _. ._ __ .   .. ...   . ._.. .. ... .");
		Assert.assertEquals("hi my name is elise", temp);
		temp = q.decode("._ _... _._. _.. . .._. __. .... .. .___ _._ ._.. __ _. ___ .__. __._ ._. ... _ .._ ..._ .__ _.._ _.__ __..");
		Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", temp);
	}

	@Test
	public void testEncode() {
		MorseCode q = new MorseCode();
		String temp = q.encode("elisE Is");
		Assert.assertEquals(". ._.. .. ... .   .. ...", temp);

		temp = q.encode("abcdefghijklmnopqrstuvwxyz");
		Assert.assertEquals(
				"._ _... _._. _.. . .._. __. .... .. .___ _._ ._.. __ _. ___ .__. __._ ._. ... _ .._ ..._ .__ _.._ _.__ __..",
				temp);
	}

}
