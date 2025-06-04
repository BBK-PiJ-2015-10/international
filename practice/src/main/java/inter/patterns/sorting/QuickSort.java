package inter.patterns.sorting;

import com.sun.source.doctree.ValueTree;

public class QuickSort {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        return quickSortRandomPivot(array,0,array.length-1);
        //return quickSort(array, 0, array.length - 1);
    }

    private int[] quickSortRandomPivot(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }
        int randomPivot = (int) Math.random() * ((right - left) + 1) + left;
        var atRandom = array[randomPivot];
        var atRight = array[right];
        array[randomPivot] = atRight;
        array[right] = atRandom;
        int partitionIndex = partition(array, left, right);
        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
        return array;
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
