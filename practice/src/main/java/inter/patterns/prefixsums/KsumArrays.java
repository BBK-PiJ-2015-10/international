package inter.patterns.prefixsums;

public class KsumArrays {

    public int findNumberOfSubArrays(int[] array, int target) {
        var cumulativeArray = new int[array.length];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            var value = array[i];
            if (i == 0) {
                cumulativeArray[i] = value;
            } else {
                var priorValue = cumulativeArray[i - 1];
                var cumValue = priorValue + value;
                cumulativeArray[i] = cumValue;
            }
        }
        for (int i = 0; i < cumulativeArray.length; i++) {
            for (int k = i; k < cumulativeArray.length; k++) {
                if (i == k) {
                    var cum = cumulativeArray[i];
                    if (target == cum) {
                        result++;
                    }
                } else {
                    var cum = cumulativeArray[k] - cumulativeArray[i];
                    if (target == cum) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
