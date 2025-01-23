package walmart;

import org.junit.Assert;
import org.junit.Test;


//https://medium.com/@techiecontent/walmart-interview-experience-sde-iii-6f05a1fda937
public class DaysAndBouquetsTest {

    private DaysAndBouquets daysAndBouquets = new DaysAndBouquets();

    @Test
    public void test1() {

        var bloomDays = new int[]{1, 10, 3, 10, 2};
        var numBouquetsRequired = 3;
        var numFlowersPerBouquetRequired = 1;


        var result = daysAndBouquets.minDays(bloomDays, numBouquetsRequired, numFlowersPerBouquetRequired);


        Assert.assertEquals(3, result);

    }

    @Test
    public void test2() {

        var bloomDays = new int[]{1, 10, 3, 10, 2};
        var numBouquetsRequired = 3;
        var numFlowersPerBouquetRequired = 2;


        var result = daysAndBouquets.minDays(bloomDays, numBouquetsRequired, numFlowersPerBouquetRequired);


        Assert.assertEquals(-1, result);

    }

    @Test
    public void test3() {

        var bloomDays = new int[]{7,7,7,7,12,7,7};
        var numBouquetsRequired = 2;
        var numFlowersPerBouquetRequired = 3;


        var result = daysAndBouquets.minDays(bloomDays, numBouquetsRequired, numFlowersPerBouquetRequired);


        Assert.assertEquals(12, result);

    }



}
