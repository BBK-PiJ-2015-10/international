package inter.patterns.binarysearch;

import java.util.logging.Logger;

public class FindInsertionIndex {

    private Logger logger = Logger.getLogger(FindInsertionIndex.class.getCanonicalName());

    // The array is sorted
    public int findInsertionIndex(int[] array, int target) {
        var insertionIndex = -1;
        var left = 0;
        var right = array.length - 1;
        while (left <= right) {
            if (left == right) {
                insertionIndex = left;
                break;
            }
            var mid = (right + left) / 2;
            var targetMid = array[mid];
            logger.info(String.format("Left %d, right %d, mid %d, target %d, targetMid %d", left, right, mid, target, targetMid));
            if (targetMid == target) {
                insertionIndex = mid;
                logger.info(String.format("Found target at mid position %d", mid));
                break;
            } else {
                if (targetMid > target) {
                    right = mid - 1;
                    logger.info(String.format("Target mid is > target, decreasing right to %d", right));
                } else {
                    left = mid + 1;
                    logger.info(String.format("Target mid is < target, increasing left to %d", left));
                }
            }
        }
        return insertionIndex;
    }

}
