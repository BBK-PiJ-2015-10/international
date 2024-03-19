package sortingsearching.sorting;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        mergeSort(array);
    }

    private void mergeSort(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }


    private void merge(int[] array, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int leftPointer = 0, rightPointer = 0, arrayPointer = 0;
        while (leftPointer < leftLength && rightPointer < rightLength) {
            if (left[leftPointer] <= right[rightPointer]) {
                array[arrayPointer++] = left[leftPointer++];
            } else {
                array[arrayPointer++] = right[rightPointer++];
            }
        }
        while (leftPointer < leftLength) {
            array[arrayPointer++] = left[leftPointer++];
        }
        while (rightPointer < rightLength) {
            array[arrayPointer++] = right[rightPointer++];
        }
    }


}
