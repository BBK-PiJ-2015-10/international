package inter.patterns.twopointers;


import java.util.logging.Logger;

public class ShiftZeroesToEnd {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int[] shiftZerosToEnd(int[] array) {
        // Pointer to track zero elements
        int i = 0;
        int j = 0;
        while (i < array.length) {
            var existingZero = array[i];
            if (existingZero == 0) {
                logger.info(String.format("Found 0 at position with i %d with j is %d", i, j));
                while (j < array.length && array[j] == 0) {
                    j++;
                }
                if (j < array.length) {
                    logger.info(String.format("Found NonZero at position %d", j));
                    var existingNonZero = array[j];
                    array[i] = existingNonZero;
                    array[j] = existingZero;
                }
            } else {
                j++;
            }
            i++;
        }

        return array;
    }

}
