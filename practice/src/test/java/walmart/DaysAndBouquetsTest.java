package walmart;

import org.junit.Assert;
import org.junit.Test;


//https://medium.com/@techiecontent/walmart-interview-experience-sde-iii-6f05a1fda937
public class DaysAndBouquetsTest {

    private DaysAndBouquetsSolution daysAndBouquets = new DaysAndBouquetsSolution();

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

    @Test
    public void test4() {

        var bloomDays = new int[]{1,10,2,9,3,8,4,7,5,6};
        var numBouquetsRequired = 4;
        var numFlowersPerBouquetRequired = 2;


        var result = daysAndBouquets.minDays(bloomDays, numBouquetsRequired, numFlowersPerBouquetRequired);


        Assert.assertEquals(9, result);

    }

    @Test
    public void test5() {

        var bloomDays = new int[]{11,9,7,5,3,1};
        var numBouquetsRequired = 2;
        var numFlowersPerBouquetRequired = 3;


        var result = daysAndBouquets.minDays(bloomDays, numBouquetsRequired, numFlowersPerBouquetRequired);


        Assert.assertEquals(9, result);

    }



}
