package mathandpuzzles;

import org.junit.Assert;
import org.junit.Test;

public class DivisableTest {

    private Divisable divisable = new Divisable();

    @Test
    public void test1(){

        int number = 412;

        boolean isDivisiable = divisable.divisibleByDigits(number);

        Assert.assertEquals(true,isDivisiable);

    }


    @Test
    public void test2(){

        int number = 142;

        boolean isDivisiable = divisable.divisibleByDigits(number);

        Assert.assertEquals(false,isDivisiable);

    }


    @Test
    public void test3(){

        int input = 213;

        int digit = input % 10;

        System.out.println(digit);



    }
}
