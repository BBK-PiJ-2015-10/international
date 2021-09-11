package stacksqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



public class StockPlanTest {

    private StockSpan stockSpan = new StockSpan();


    @Test
    public void test1(){

        Integer[] input =  {55,34,22,23,27,88,70,42,51,100};
        Integer[] expectedOutput = {1,1,1,2,3,6,1,1,2,10};

        Integer[] actual = stockSpan.calculateSpan(input);

        Assert.assertEquals(Arrays.asList(expectedOutput),Arrays.asList(actual));

    }

}
