package inter.patterns.dynamic;

import com.mysql.cj.log.Log;

import java.util.logging.Logger;

public class MaximumSubarraySum {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int maxSubArraySum(int[] input) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < input.length; i++) {
            int valueAtI = input[i];
            currentSum = currentSum + input[i];
            if (currentSum < valueAtI) {
                currentSum = valueAtI;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
