package intern.patterns.prefixsums;

import inter.patterns.prefixsums.KsumArrays;
import org.junit.Assert;
import org.junit.Test;


public class KsumArraysTest {

    private KsumArrays calculator = new KsumArrays();

    @Test
    public void test1() {

        int[] input = {1, 2, -1, 1, 2};
        int target = 3;

        var result = calculator.findNumberOfSubArrays(input, target);

        Assert.assertEquals(3, result);

    }

    @Test
    public void test2() {

        int[] input = {1, 1, 1};
        int target = 2;

        var result = calculator.findNumberOfSubArrays(input, target);

        Assert.assertEquals(2, result);

    }

    @Test
    public void test3() {

        int[] input = {1, 1, 1};
        int target = 2;

        var result = calculator.findNumberOfSubArraysOptimized(input, target);

        Assert.assertEquals(2, result);

    }

    @Test
    public void test4() {

        int[] input = {1, 2, -1, 1, 2};
        int target = 3;

        var result = calculator.findNumberOfSubArraysOptimized(input, target);

        Assert.assertEquals(3, result);

    }
}
