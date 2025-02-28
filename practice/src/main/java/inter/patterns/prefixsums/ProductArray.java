package inter.patterns.prefixsums;

import java.util.Arrays;

public class ProductArray {

    public int[] productArrayWithoutCurrent(int[] array) {
        var product = Arrays.stream(array).reduce((a, b) -> a * b).getAsInt();
        var result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = product / array[i];
        }
        return result;
    }

}
