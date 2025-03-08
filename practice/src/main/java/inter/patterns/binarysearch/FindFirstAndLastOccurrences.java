package inter.patterns.binarysearch;

import java.util.logging.Logger;

public class FindFirstAndLastOccurrences {

    private Logger logger = Logger.getLogger(FindFirstAndLastOccurrences.class.getCanonicalName());

    public int[] findFirstAndLastOccurrences(int[] array, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = array[mid];
            logger.info(String.format("Evaluating target %d against value %d mid %d, left %d, right %d", target, midValue, mid, left, right));
            if (midValue == target) {
                logger.info(String.format("Found target at mid %d, left %d, right %d", mid, left, right));
                right = mid;
                left = mid;
                while (right < array.length - 1 && array[right] == target) {
                    right++;
                    logger.info(String.format("Moving solution right to %d", right));
                }
                while (left >= 0 && array[left] == target) {
                    left--;
                    logger.info(String.format("Moving solution left to %d", left));
                }
                result[0] = left + 1;
                result[1] = right - 1;
                logger.info(String.format("Returning solution %d and %d", result[0], result[1]));
                break;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
