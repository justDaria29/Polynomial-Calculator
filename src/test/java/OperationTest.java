

import logic.Operation;
import model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OperationTest {
    //@Test
    /*public void testAddCorrect(){

        String poly1="x^3-4x^1";
        String poly2="x^3";
        String poly3="x^3+x^2-4x^1";
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.add(p1,p2);

        assertEquals(result.toString(),expected.toString());
    }
*/
    @Test
    public void testAddFalse(){

        String poly1="x^3-4x^1";
        String poly2="x^2";
        String poly3="x^3";
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.add(p1,p2);

        assertNotEquals(result.toString(),expected.toString());
    }

    @Test
    public void testSubstractCorrect(){

        String poly1="x^3-4x^1+12";
        String poly2="x^2+1";
        String poly3="x^3-x^2-4x^1+11";
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.subtract(p1,p2);

        assertEquals(result.toString(),expected.toString());
    }

    @Test
    public void testSubstractFalse(){

        String poly1="x^3-4x^1+12";
        String poly2="x^2+1";
        String poly3="x^3+4x^1+111";
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.subtract(p1,p2);

        assertNotEquals(result.toString(),expected.toString());
    }

    @Test
    public void testMultiplyCorrect(){

        String poly1="x^3-4x^1+12";
        String poly2="x^2+1";
        String poly3="x^5-3x^3+12x^2-4x^1+12";
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.multiply(p1,p2);

        assertEquals(result.toString(),expected.toString());
    }

    @Test
    public void testMultiplyFalse(){

        String poly1="x^3-4x^1+12";
        String poly2="x^2+1";
        String poly3="-3x^3+12x^2";
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.multiply(p1,p2);

        assertNotEquals(result.toString(),expected.toString());
    }

    @Test
    public void testDerivativeCorrect(){

        String poly1="x^3-4x^1+12";
        String poly3="3x^2-4";
        Polynomial p1 = new Polynomial();
        p1.parsePolynomial(poly1);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.derivative(p1);

        assertEquals(result.toString(),expected.toString());
    }

    @Test
    public void testDerivativeFalse(){

        String poly1="x^3-4x^1+12";
        String poly3="-4";
        Polynomial p1 = new Polynomial();
        p1.parsePolynomial(poly1);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.derivative(p1);

        assertNotEquals(result.toString(),expected.toString());
    }

    @Test
    public void testIntegrateCorrect(){

        String poly1="4x^3";
        String poly3="x^4";
        Polynomial p1 = new Polynomial();
        p1.parsePolynomial(poly1);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.integration(p1);

        assertEquals(result.toString(),expected.toString());
    }

    @Test
    public void testIntegrateFalse(){

        String poly1="4x^3";
        String poly3="12";
        Polynomial p1 = new Polynomial();
        p1.parsePolynomial(poly1);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.integration(p1);

        assertNotEquals(result.toString(),expected.toString());
    }

   /* @Test
    public void testDevideCorrect(){

        String poly1="x^4+1";
        String poly2="x^2";
        String poly3="x^2";
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial expected= new Polynomial();
        expected.parsePolynomial(poly3);
        Polynomial result= Operation.divide(p1,p2);

        assertEquals(result.toString(),expected.toString());
    }*/

}

