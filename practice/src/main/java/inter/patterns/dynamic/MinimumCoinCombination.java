package inter.patterns.dynamic;

import java.util.Arrays;
import java.util.logging.Logger;

public class MinimumCoinCombination {

    private Logger logger = Logger.getLogger(MinimumCoinCombination.class.getCanonicalName());

    public int minimumCoinCombination(int[] coins, int target) {
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
