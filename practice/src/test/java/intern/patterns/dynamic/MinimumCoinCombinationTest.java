package intern.patterns.dynamic;

import inter.patterns.dynamic.MinimumCoinCombination;
import org.junit.Assert;
import org.junit.Test;

public class MinimumCoinCombinationTest {

    private MinimumCoinCombination calculator = new MinimumCoinCombination();

    @Test
    public void test1() {

        var target = 5;
        int[] coins = {1, 2, 3};

        var minimumCoins = calculator.minimumCoinCombinationBottomUp(coins, target);

        Assert.assertEquals(2, minimumCoins);

    }

    @Test
    public void test2() {

        var target = 2;
        int[] coins = {1, 1};

        var minimumCoins = calculator.minimumCoinCombinationBottomUp(coins, target);

        Assert.assertEquals(2, minimumCoins);

    }

    @Test
    public void test3() {

        var target = 5;
        int[] coins = {1, 2, 3};

        var minimumCoins = calculator.minimumCoinCombinationTopDown(coins, target);

        Assert.assertEquals(2, minimumCoins);

    }

}
