package inter.patterns.sorting;

public class QuickSort {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        return quickSort(array, 0, array.length - 1);
    }

    private int[] quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }
        int partitionIndex = partition(array, left, right);
        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
        return array;
    }

    private int partition(int[] array, int left, int right) {
        var lowerPointer = left;
        var pivotValue = array[right];
        for (int i = left; i < right; i++) {
            var iValue = array[i];
            if (iValue < pivotValue) {
                var valueAtlower = array[lowerPointer];
                array[lowerPointer] = iValue;
                array[i] = valueAtlower;
                lowerPointer++;
            }
        }
        var valueAtLower = array[lowerPointer];
        array[lowerPointer] = pivotValue;
        array[right] = valueAtLower;
        return lowerPointer;
    }


}
