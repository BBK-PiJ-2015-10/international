package inter.patterns.dynamic;

import inter.patterns.heaps.KMostFrequentString;

import java.util.logging.Logger;

public class LargestSubArraySum {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int[] getLargestSubArraySum(int[] input) {
        int maxSum = 0;
        int maxBeg = 0;
        int maxEnd = 0;
        int localCum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int k = i; k < input.length; k++) {
                if (i == k) {
                    localCum = 0;
                }
                int newElemValue = input[k];
                int localSum = localCum + newElemValue;
                logger.info(String.format("On i %d, k %d localCum %d localSum %d maxSum %d", i, k, localCum, localSum, maxSum));
                if (localSum > maxSum) {
                    maxSum = localSum;
                    maxBeg = i;
                    maxEnd = k;
                    logger.info(String.format("Updating maxBeg %d and maxEnd %d", maxBeg, maxEnd));
                }
                localCum = localSum;
            }
        }
        logger.info(String.format("SOLUTION maxBeg %d and maxEnd %d", maxBeg, maxEnd));
        return getSubArray(input, maxBeg, maxEnd);
    }


    private int[] getSubArray(int[] input, int beg, int end) {
        int size = end - beg + 1;
        int[] response = new int[size];
        for (int i = 0; i < size; i++) {
            response[i] = input[beg + i];
        }
        return response;
    }

    public int getLargestSubArraySumKadaneAlgorithm(int[] input) {
        int currSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            var current = input[i];
            currSum = Math.max(currSum + current, current);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }


}
