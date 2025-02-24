package inter.patterns.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MinimumCoinCombination {

    private Logger logger = Logger.getLogger(MinimumCoinCombination.class.getCanonicalName());

    public int minimumCoinCombinationTopDown(int[] coins, int target) {
        if (target == 0) {
            return -1;
        }
        if (coins.length == 0) {
            return 0;
        }
        Map<Integer, Integer> minCoinsSolutions = new HashMap<>();
        var result = minimumCoinCombinationTopDownHelper(coins, target, minCoinsSolutions);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    private int minimumCoinCombinationTopDownHelper(int[] coins, int target, Map<Integer, Integer> solutions) {
        if (target == 0) {
            return -1;
        }
        var existingSolution = solutions.get(target);
        if (existingSolution != null) {
            return existingSolution;
        } else {
            var minCoins = Integer.MAX_VALUE;
            for (int cp = 0; cp < coins.length; cp++) {
                var coin = coins[cp];
                if (coin <= target) {
                    minCoins = Math.min(minCoins, 1 + minimumCoinCombinationTopDownHelper(coins, target - coin, solutions));
                }
            }
            solutions.put(target, minCoins);
        }
        return solutions.get(target);
    }


    public int minimumCoinCombinationBottomUp(int[] coins, int target) {
        if (target == 0) {
            return -1;
        }
        if (coins.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 90);
        dp[0] = 0;
        for (int t = 1; t <= target; t++) {
            for (int cp = 0; cp < coins.length; cp++) {
                var coin = coins[cp];
                if (coin <= t) {
                    dp[t] = Math.min(dp[t], 1 + dp[t - coin]);
                }
            }
        }
        var dpTarget = dp[target];
        if (dpTarget == 90) {
            return -1;
        } else {
            return dpTarget;
        }
    }

}
