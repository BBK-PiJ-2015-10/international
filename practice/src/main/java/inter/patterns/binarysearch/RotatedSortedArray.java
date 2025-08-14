package inter.patterns.binarysearch;

import java.util.logging.Logger;

public class RotatedSortedArray {

    private Logger logger = Logger.getLogger(this.toString());

    public int findTarget(int[] array, int target) {
        return findTarget(array, target, 0, array.length - 1);
    }

    private int findTarget(int[] array, int target, int begIndex, int endIndex) {
        int middleIndex = (endIndex - begIndex) / 2;
        logger.info(String.format("Searching fromPos %d toPos %d middlePos %d", begIndex, endIndex, middleIndex));
        if (begIndex > endIndex) {
            return -1;
        }
        int midValue = array[middleIndex];
        if (midValue == target) {
            return middleIndex;
        }
        int begValue = array[begIndex];
        if (begValue == target) {
            return begIndex;
        }
        int endValue = array[endIndex];
        if (endValue == target) {
            return endIndex;
        }
        // is righSorted
        if (midValue < endValue) {
            // is value withinRightRange
            if (midValue < target && target < endValue) {
                logger.info(String.format("RightSorted - Search RIGHT - Will search fromPos %d toPos %d", middleIndex + 1, endIndex));
                return findTarget(array, target, middleIndex + 1, endIndex);
                // else search on the left
            } else {
                logger.info(String.format("RightSorted - Search LEFT - Will search fromPos %d toPos %d", begIndex, middleIndex - 1));
                return findTarget(array, target, begIndex, middleIndex - 1);
                // not in between try left
            }
        }
        // is leftSorted
        if (begValue < midValue) {
            // is value withinLeftRange
            if (begValue < target && target < midValue) {
                // cound be inside
                logger.info(String.format("LeftSorted - Search LEFT - Will search fromPos %d toPos %d", begIndex, middleIndex - 1));
                return findTarget(array, target, begIndex, middleIndex - 1);
            } else {
                // searchOnTheRight
                logger.info(String.format("LeftSorted - Search RIGHT - Will search fromPos %d toPos %d", middleIndex + 1, endIndex));
                return findTarget(array, target, middleIndex + 1, endIndex);
            }
        }
        return -1;
    }

}
