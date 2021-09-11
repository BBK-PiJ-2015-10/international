package arraysstrings;

import org.junit.Test;
import org.junit.Assert;

public class BuyingSellingStockTest {

    private BuyingSellingStock buyingSellingStock= new BuyingSellingStock();


    @Test
    public void test1(){

        int[] prices = {40,20,80,200,10};
        int result = buyingSellingStock.maxProfit(prices);
        Assert.assertEquals(180,result);

    }

    @Test
    public void test2(){

        int[] prices = {200,500,1000,700,30,400,900,400,550};
        int result = buyingSellingStock.maxProfit(prices);
        Assert.assertEquals(870,result);

    }

    @Test
    public void test3(){

        int[] prices = {200,500,1000,700,30,400,900,400,550};
        int result = buyingSellingStock.maxProfitTwoSales(prices);
        Assert.assertEquals(1670,result);

    }

    @Test
    public void test4(){

        int[] prices = {200,500,1000,700,30,400,900,400,550};
        int result = buyingSellingStock.maxProfitUnlimited(prices);
        Assert.assertEquals(1820,result);

    }

}
