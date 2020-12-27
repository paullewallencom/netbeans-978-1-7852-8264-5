package com.davidsalter.masteringnb.factorial;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class Factorial {

    public long calculate(int number) {
        
        if (0 == number) {
            return 1;
        }
        
        if (number < 0 ) {
            return 0;
        }
        
        long result = 1;
        for ( int i = number; i > 0; i--) {
            result = result * i;
        }
        
        return result;
    }

}
