package rozenberg.scrabble;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() throws FileNotFoundException {

		ScrabbleDictionary q = new ScrabbleDictionary();
		boolean contains = q.contains("herringbone");
		Assert.assertTrue(contains);

		contains = q.contains("ambfg");
		Assert.assertFalse(contains);
	}
}
