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

    public int[] productArrayWithoutCurrentLeftAndRight(int[] array) {
        var result = new int[array.length];
        var leftProducts = new int[array.length];
        var rightProducts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                leftProducts[i] = 1;
            } else {
                leftProducts[i] = leftProducts[i - 1] * array[i - 1];
            }
        }
        for (int k = array.length - 1; k >= 0; k--) {
            if (k == array.length - 1) {
                rightProducts[k] = 1;
            } else {
                rightProducts[k] = rightProducts[k + 1] * array[k + 1];
            }
        }
        for (int l = 0; l < array.length; l++) {
            result[l] = leftProducts[l] * rightProducts[l];
        }
        return result;
    }

    public int[] productArrayWithoutCurrentLeftAndRightLessSpace(int[] array) {
        var result = new int[array.length];
        var leftProducts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                leftProducts[i] = 1;
            } else {
                leftProducts[i] = leftProducts[i - 1] * array[i - 1];
            }
            result[i] = leftProducts[i];
        }
        var runningProduct = 1;
        for (int k = array.length - 1; k >= 0; k--) {
            if (k == array.length - 1) {
                runningProduct = 1;
            } else {
                runningProduct = runningProduct * array[k + 1];
                result[k] = result[k] * runningProduct;
            }
        }
        return result;
    }


}
