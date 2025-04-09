package intern.patterns.twopointers;

import inter.patterns.twopointers.LargestContainer;
import org.junit.Assert;
import org.junit.Test;

public class LargestContainerTest {

    private LargestContainer container = new LargestContainer();

    @Test
    public void test1() {

        int[] heights = {2, 7, 8, 3, 7, 6};

        var result = container.largestContainer(heights);

        Assert.assertEquals(24, result);

    }

    @Test
    public void test2() {

        int[] heights = {};

        var result = container.largestContainer(heights);

        Assert.assertEquals(0, result);

    }

    @Test
    public void test3() {

        int[] heights = {1};

        var result = container.largestContainer(heights);

        Assert.assertEquals(0, result);

    }

    @Test
    public void test4() {

        int[] heights = {0, 1, 0};

        var result = container.largestContainer(heights);

        Assert.assertEquals(0, result);

    }

    @Test
    public void test5() {

        int[] heights = {3, 3, 3, 3};

        var result = container.largestContainer(heights);

        Assert.assertEquals(9, result);

    }

    @Test
    public void test6() {

        int[] heights = {1, 2, 3};

        var result = container.largestContainer(heights);

        Assert.assertEquals(2, result);

    }

    @Test
    public void test7() {

        int[] heights = {3, 2, 1};

        var result = container.largestContainer(heights);

        Assert.assertEquals(2, result);

    }


}
