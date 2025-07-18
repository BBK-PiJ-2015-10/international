package inter.patterns;

import java.util.logging.Logger;

public class Practice {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int findInsertionIndexRecurs(int[] values, int target) {
        return findInsertionIndexRecurs(values, target, 0, values.length);
    }

    public int findInsertionIndexRecurs(int[] values, int target, int left, int right) {
        var result = 0;
        int mid = left + (right - left) / 2;
        int valueAtMid = values[mid];
        logger.info(String.format("Evaluating leftIndex: %d rightIndex: %d middleIndex: %d middleValue %d", left, right, mid, valueAtMid));
        if (valueAtMid == target) {
            result = mid;
            return result;
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
