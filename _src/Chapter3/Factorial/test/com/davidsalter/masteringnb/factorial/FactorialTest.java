package com.davidsalter.masteringnb.factorial;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class FactorialTest {
    
    public FactorialTest() {
    }
    
    @Test
    public void factorialOfZeroIsOne() {
        Factorial factorial = new Factorial();
        long result = factorial.calculate(0);
        assertEquals("0! should equal 1", 1, result);
    }
    
    @Test
    public void factorialOfNegativeNumberIsZero() {
        Factorial factorial = new Factorial();
        long result = factorial.calculate(-10);
        assertEquals("Factorial of -ve number should be 0.", 0, result);
    }
    
    @Test
    public void factorialOfNumberIsCalculatedCorrectly() {
        Factorial factorial = new Factorial();
        long result = factorial.calculate(5);
        assertEquals("5! should equal 120", 120, result);
    }
}
