package intern.patterns.dynamic;

import inter.patterns.dynamic.NeighborhoodBurglary;
import org.junit.Assert;
import org.junit.Test;

public class NeighborhoodBurglaryTest {

    private NeighborhoodBurglary calculator = new NeighborhoodBurglary();


    @Test
    public void test1(){

        int[] houses = {200,300,200,50};

        var result = calculator.maxProfit(houses);

        Assert.assertEquals(400,result);
    }

}
