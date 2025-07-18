package inter.patterns.binarysearch;

import java.util.logging.Logger;

public class FindInsertionIndex {

    private Logger logger = Logger.getLogger(FindInsertionIndex.class.getCanonicalName());

    // The array is sorted
    public int findInsertionIndex(int[] array, int target) {
        var insertionIndex = -1;
        var left = 0;
        var right = array.length;
        while (left <= right) {
            if (left == right) {
                insertionIndex = left;
                break;
            }
            var mid = (right + left) / 2;
            logger.info(String.format("Left %d, right %d, mid %d, target %d, targetMid %d", left, right, mid, target, array[mid]));
            // We are finding the element equal or first greater than the target. Hence, we want to keep the mid
            if (array[mid] >= target) {
                right = mid;
                logger.info(String.format("Target mid is > target, decreasing right to %d", right));
            } else {
                left = mid + 1;
                logger.info(String.format("Target mid is < target, increasing left to %d", left));
            }
        }
        return insertionIndex;
    }

    public int findInsertionIndexRecurs(int[] values, int target) {
        return findInsertionIndexRecurs(values, target, 0, values.length);
    }

    public int findInsertionIndexRecurs(int[] values, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        int valueAtMid = values[mid];
        logger.info(String.format("Evaluating leftIndex: %d rightIndex: %d middleIndex: %d middleValue %d", left, right, mid, valueAtMid));
        if (valueAtMid == target) {
            return mid;
        }
        if (left == mid || right == mid) {
            return mid + 1;
        }
        if (valueAtMid > target) {
            return findInsertionIndexRecurs(values, target, left, mid);
        } else {
            return findInsertionIndexRecurs(values, target, mid, right);
        }
    }

}
