import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
    Model model = new Model();

    @Test
    public void testCalculateExponent() {

        double exponentValue = model.calculateExponent(4.0, 2.0);
        assertEquals(16.0, exponentValue,0);

    }
    
    @Test
    public void testCalculateExponentFraction() {

        double exponentValue = model.calculateExponent(4.0, 0.5);
        assertEquals(2.0, exponentValue,0);

    }

    @Test
    public void testCalculateExponentNegative() {

    	double exponentValue = model.calculateExponent(4.0, -2);
    	assertEquals(0.0625, exponentValue,0);

    }
    
    @Test
    public void testCalculateExponentZero() {

    	double exponentValue = model.calculateExponent(4.0, 0);
    	assertEquals(1, exponentValue,0);

    }
    
    @Test
    public void testCalculateExponentOne() {

    	double exponentValue = model.calculateExponent(4.0, 1);
    	assertEquals(4.0, exponentValue,0);

    }
    
    @Test
    public void testExpression() {

    	double expressionValue = model.calculateExpression("4*5^2");
    	assertEquals(100, expressionValue,0);

    }

}
