package inter.patterns.sorting;

public class CountSort {

    // assumes as array values are positive
    // max value is 10 power 3 = 1000
    public int[] sort(int[] array, int maxSize) {
        int[] counter = new int[maxSize + 1];
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            counter[current] = counter[current] + 1;
        }
        int currentPos = 0;
        for (int j = 0; j < counter.length; j++) {
            int counterFreq = counter[j];
            if (counterFreq > 0) {
                for (int k = 1; k <= counterFreq; k++) {
                    array[currentPos] = j;
                    currentPos++;
                }
            }
        }
        return array;
    }
}
