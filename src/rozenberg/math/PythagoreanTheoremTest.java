package rozenberg.math;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {
	@Test
	public void testSetAB() {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAB(2, 2);
		Assert.assertEquals(2.83, p.getC(), 0.01);
	}

	@Test
	public void testSetAC() {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAC(10, 55);
		Assert.assertEquals(54.08, p.getB(), 0.01);

	}

	@Test
	public void testSetBC() {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setBC(7, 34);
		Assert.assertEquals(33.27, p.getA(), 0.01);

	}

	// check if separate or not
	@Test
	public void testInvalidDataException() {
		try {
			PythagoreanTheorem p = new PythagoreanTheorem();
			p.setAB(0, 2);
		} catch (InvalidDataException ex1) {
		}

		try {
			PythagoreanTheorem p = new PythagoreanTheorem();
			p.setBC(0, 2);
		} catch (InvalidDataException ex1) {
		}

		try {
			PythagoreanTheorem p = new PythagoreanTheorem();
			p.setAC(0, 2);
		} catch (InvalidDataException ex1) {
		}
	}

}
