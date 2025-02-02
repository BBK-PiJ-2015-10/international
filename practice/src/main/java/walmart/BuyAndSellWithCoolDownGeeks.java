package walmart;

import java.util.logging.Logger;


//https://takeuforward.org/data-structure/buy-and-sell-stocks-with-cooldown-dp-39/

//https://medium.com/@techiecontent/walmart-interview-experience-sde-iii-6f05a1fda937
public class BuyAndSellWithCoolDownGeeks {

    private Logger logger = Logger.getLogger("BuyAndSellApp");

    public BuyAndSellWithCoolDownGeeks() {
    }


    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[] cur = new int[2];
        int[] front1 = new int[2];
        int[] front2 = new int[2];

        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + front1[0], -prices[ind] + front1[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + front1[1], prices[ind] + front2[0]);
                }

                cur[buy] = profit;
            }

            // Update front1 and front2 arrays
            System.arraycopy(front1, 0, front2, 0, 2);
            System.arraycopy(cur, 0, front1, 0, 2);
        }

        // The maximum profit is stored in cur[0]
        return cur[0];
    }


}
