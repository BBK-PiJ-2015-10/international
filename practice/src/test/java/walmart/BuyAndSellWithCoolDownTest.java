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
}
