package rozenberg.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContainsTrue() throws IOException {
		ScrabbleDictionary q = new ScrabbleDictionary();

		boolean contains = q.contains("herringbone");
		Assert.assertTrue(contains);
	}
	@Test
	public void testContainsFalse() throws IOException {
		ScrabbleDictionary q = new ScrabbleDictionary();

		boolean contains = q.contains("amfg");
		Assert.assertFalse(contains);
	}
}
