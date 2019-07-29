import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases for Calculator App
 * @author rahls7
 *
 */
public class AppTest {
	Model model = new Model();
	
	/**
	 * Tests exponent function for double values
	 */
	@Test
	public void testCalculateExponent() {

		double exponentValue = model.calculateExponent(4.0, 2.0);
		assertEquals(16.0, exponentValue, 0);

	}
	
	/**
	 * Tests exponent for fractional values
	 */
	@Test
	public void testCalculateExponentFraction() {

		double exponentValue = model.calculateExponent(4.0, 0.5);
		assertEquals(2.0, exponentValue, 0);

	}
	
	/**
	 * Tests exponent for negative values
	 */
	@Test
	public void testCalculateExponentNegative() {

		double exponentValue = model.calculateExponent(4.0, -2);
		assertEquals(0.0625, exponentValue, 0);

	}
	/**
	 * Tests exponent for zero exponent
	 */
	@Test
	public void testCalculateExponentZero() {

		double exponentValue = model.calculateExponent(4.0, 0);
		assertEquals(1, exponentValue, 0);

	}
	
	/**
	 * Tests exponent for power 1
	 */
	@Test
	public void testCalculateExponentOne() {

		double exponentValue = model.calculateExponent(4.0, 1);
		assertEquals(4.0, exponentValue, 0);

	}
	
	/**
	 * Tests String expression for calculation
	 */
	@Test
	public void testExpression() {

		double expressionValue = model.calculateExpression("4*5^2");
		assertEquals(100, expressionValue, 0);
	}

}
