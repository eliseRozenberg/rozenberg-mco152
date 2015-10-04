package rozenberg.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() throws IOException {
		ScrabbleDictionary q = new ScrabbleDictionary();

		boolean contains = q.contains("herringbone");
		Assert.assertTrue(contains);

		contains = q.contains("ambfg");
		Assert.assertFalse(contains);
	}
}
