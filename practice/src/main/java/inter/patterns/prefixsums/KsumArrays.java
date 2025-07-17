package inter.patterns.prefixsums;

import java.util.HashMap;
import java.util.Map;

public class KsumArrays {

    public int findNumberOfSubArrays(int[] array, int target) {
        var prefixSum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                prefixSum[i] = array[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + array[i];
            }
        }
        int result = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i; j < prefixSum.length; j++) {
                if (i == j) {
                    var cum = prefixSum[i];
                    if (target == cum) {
                        result++;
                    }
                } else {
                    var cum = prefixSum[j] - prefixSum[i];
                    if (target == cum) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public int findNumberOfSubArraysOptimized(int[] array, int target) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        int counter = 0;
        int currentCum = 0;
        for (int i = 0; i < array.length; i++) {
            currentCum = currentCum + array[i];
            int expectedPriorCum = currentCum - target;
            var existingPriorCumCount = prefixSums.get(expectedPriorCum);
            if (existingPriorCumCount != null) {
                counter ++;
            }
            prefixSums.put(currentCum,1);
        }
        return counter;
    }
}
