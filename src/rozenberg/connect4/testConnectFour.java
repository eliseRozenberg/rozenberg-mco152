package rozenberg.connect4;

import org.junit.Assert;
import org.junit.Test;

public class testConnectFour {

	@Test
	public void testCheckCell() {
		Table table = new Table();
		table.setCell(0, 1);
		Assert.assertTrue(table.checkCell(0, 0, 1));
	}

	@Test
	public void testSetCell() {
		Table table = new Table();
		table.setCell(1, 1);
		table.setCell(2, 1);
		table.setCell(1, 1);
		Assert.assertTrue(table.checkCell(1, 1, 1));
	}

	@Test
	public void testCheckDiagNegTrue() {
		Table table = new Table();
		table.setCell(3, 1);
		table.setCell(2, 2);
		table.setCell(2, 1);
		table.setCell(1, 2);
		table.setCell(1, 1);
		table.setCell(1, 1);
		table.setCell(0, 2);
		table.setCell(0, 1);
		table.setCell(0, 2);
		table.setCell(0, 1);
		Assert.assertTrue(table.check(1));
		Assert.assertTrue(table.check(1));
	}

	@Test
	public void testCheckDiagNegFalse() {
		Table table = new Table();
		table.setCell(0, 2);
		table.setCell(0, 1);
		table.setCell(0, 2);
		table.setCell(1, 1);
		table.setCell(1, 2);
		table.setCell(2, 2);
		Assert.assertFalse(table.check(2));
	}

	@Test
	public void testCheckDiagPosTrue() {
		Table table = new Table();
		table.setCell(0, 1);
		table.setCell(1, 2);
		table.setCell(1, 1);
		table.setCell(2, 2);
		table.setCell(2, 1);
		table.setCell(2, 1);
		table.setCell(3, 2);
		table.setCell(3, 1);
		table.setCell(3, 2);
		table.setCell(3, 1);
		Assert.assertTrue(table.check(1));
		Assert.assertTrue(table.check(1));
	}

	@Test
	public void testCheckDiagPosFalse() {
		Table table = new Table();
		table.setCell(0, 2);
		table.setCell(1, 1);
		table.setCell(1, 2);
		table.setCell(2, 1);
		table.setCell(2, 2);
		table.setCell(2, 2);
		Assert.assertFalse(table.check(2));
	}

	@Test
	public void testCheckDownTrue() {
		Table table = new Table();
		table.setCell(1, 1);
		table.setCell(1, 1);
		table.setCell(1, 1);
		table.setCell(1, 1);
		Assert.assertTrue(table.check(1));
	}

	@Test
	public void testCheckDownFalse() {
		Table table = new Table();
		table.setCell(0, 2);
		table.setCell(0, 1);
		table.setCell(0, 1);
		table.setCell(0, 1);
		Assert.assertFalse(table.check(1));
	}

	@Test
	public void testCheckAcrossTrue() {
		Table table = new Table();
		table.setCell(0, 1);
		table.setCell(1, 1);
		table.setCell(2, 1);
		table.setCell(3, 1);
		Assert.assertTrue(table.check(1));
		Assert.assertTrue(table.check(1));
	}

	@Test
	public void testCheckAcrossFalse() {
		Table table = new Table();
		table.setCell(0, 1);
		table.setCell(1, 2);
		table.setCell(2, 1);
		Assert.assertFalse(table.check(1));
		Assert.assertFalse(table.check(1));
	}

	@Test
	public void testChangePlayer() {
		Table table = new Table();
		Assert.assertEquals(table.changePlayer(1), 2);
		Assert.assertEquals(table.changePlayer(2), 1);
	}

	@Test
	public void testClearTable() {
		Table table = new Table();
		table.setCell(6, 1);
		table.clearTable();
		Assert.assertTrue(table.checkCell(0, 6, 0));
	}

	@Test
	public void testDraw() {
		Table table = new Table();
		for (int i = 0; i < table.getCols(); i++) {
			for (int j = 0; j < table.getRows(); j++) {
				table.setCell(i, 1);
			}
		}
		Assert.assertTrue(table.draw());
	}
}
