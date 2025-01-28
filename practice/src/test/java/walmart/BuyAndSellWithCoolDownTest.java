package walmart;

import org.junit.Assert;
import org.junit.Test;

public class BuyAndSellWithCoolDownTest {

    private BuyAndSellWithCoolDown calculator = new BuyAndSellWithCoolDown();


    @Test
    public void test1() {

        var prices = new int[]{1, 2, 3, 0, 2};
        var maxProfit = calculator.maxProfit(prices);
        Assert.assertEquals(3, maxProfit);

    }

    @Test
    public void test205() {

        var prices = new int[]{48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
        var maxProfit = calculator.maxProfit(prices);
        Assert.assertEquals(3, maxProfit);

    }
}
