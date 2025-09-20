package inter.patterns.twopointers;


import java.util.logging.Logger;

public class ShiftZeroesToEnd {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int[] shiftZerosToEnd(int[] array) {
        // Pointer to track zero elements
        int i = 0;
        // Pointer to track non-zero elements
        while (i < array.length - 1) {
            var existingZero = array[i];
            if (existingZero == 0) {
                int j = i;
                logger.info(String.format("Found 0 at position %d", i));
                while (j < array.length - 1 && array[j] == 0) {
                    j++;
                }
                logger.info(String.format("Found NonZero at position %d", j));
                var existingNonZero = array[j];
                array[i] = existingNonZero;
                array[j] = existingZero;
                //j =i+1;
            }
            i++;
        }

        return array;
    }

}
