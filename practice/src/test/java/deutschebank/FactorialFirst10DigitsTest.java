package deutschebank;

import org.junit.Assert;
import org.junit.Test;

public class FactorialFirst10DigitsTest {

    private FactorialFirst10Digits calculator = new FactorialFirst10Digits();

    @Test
    public void test1() {

        var input = 2;
        var factorial = calculator.factorial(input);
        Assert.assertEquals(2, factorial);

    }

    @Test
    public void test2() {

        var input = 3;
        var factorial = calculator.factorial(input);
        Assert.assertEquals(6, factorial);

    }

    @Test
    public void test3() {

        var input = 10;
        var factorial = calculator.factorial(input);
        Assert.assertEquals(3628800, factorial);

        Integer cat = 123456;


        var res = cat / 10000;

        System.out.println(res);




    }

    @Test
    public void test4() {

        var input = 10;
        var factorial = calculator.factorial(input);
        Assert.assertEquals(3628800, factorial);

    }


}

