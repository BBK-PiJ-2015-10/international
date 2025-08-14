package intern.patterns.binarysearch;

import inter.patterns.binarysearch.RotatedSortedArray;
import org.junit.Assert;
import org.junit.Test;

public class RotatedSortedArrayTest {

    private RotatedSortedArray sortedArray = new RotatedSortedArray();

    @Test
    public void test1() {

        int target = 1;
        int[] array = {8, 9, 1, 2, 3, 4, 5, 6, 7};

        int position = sortedArray.findTarget(array, target);

        Assert.assertEquals(2, position);

    }
}
