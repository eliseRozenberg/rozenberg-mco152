package rozenberg.math;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositive() {
		QuadraticEquation q = new QuadraticEquation(1, 3, -4);
		
		Assert.assertEquals(1, q.getPositive(), 0.01);
	}
	
	@Test
	public void testGetNegative(){
		QuadraticEquation q= new QuadraticEquation(1,3,-4);
		Assert.assertEquals(-4,q.getNegative(), 0.01);
	}
}
