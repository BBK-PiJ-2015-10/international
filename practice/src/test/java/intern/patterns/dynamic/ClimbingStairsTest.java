package intern.patterns.dynamic;

import inter.patterns.dynamic.ClimbingStairs;
import org.junit.Assert;
import org.junit.Test;

public class ClimbingStairsTest {

    private ClimbingStairs calculator = new ClimbingStairs();


    @Test
    public void test1() {
        int height = 2;
        var result = calculator.waysOfClimbingStairs(height);

        Assert.assertEquals(2, result);
    }

    @Test
    public void test2() {
        int height = 3;
        var result = calculator.waysOfClimbingStairs(height);

        Assert.assertEquals(3, result);
    }

    @Test
    public void test4() {
        int height = 4;
        var result = calculator.waysOfClimbingStairs(height);

        Assert.assertEquals(5, result);
    }

    @Test
    public void test5() {

        int height = 6;
        var result = calculator.waysOfClimbingStairs(height);

        Assert.assertEquals(13, result);
    }

}
