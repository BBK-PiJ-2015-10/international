package deutschebank;

import java.math.BigInteger;

public class FactorialFirst10Digits {

    public int factorial(int input) {
        return factorialCum(input, 1);
    }

    public int factorialCum(int input, Integer accum) {
        if (input == 1) {
            return accum;
        } else {
            var newAccum = accum * input;
            return factorialCum(input - 1, newAccum);
        }
    }
    
}
