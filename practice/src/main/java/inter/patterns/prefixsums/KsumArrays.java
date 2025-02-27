package inter.patterns.prefixsums;

public class KsumArrays {

    public int findNumberOfSubArrays(int[] array, int target) {
        var prefixSum = new int[array.length];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                prefixSum[i] = array[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + array[i];
            }
        }
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
}
