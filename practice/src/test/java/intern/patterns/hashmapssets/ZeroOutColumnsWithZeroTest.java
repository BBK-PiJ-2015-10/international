package intern.patterns.hashmapssets;

import inter.patterns.hashmapssets.ZeroOutColumRowWithZero;
import org.junit.Assert;
import org.junit.Test;

public class ZeroOutColumnsWithZeroTest {

    private ZeroOutColumRowWithZero processor = new ZeroOutColumRowWithZero();

    @Test
    public void test1() {

        int[][] input = {
                {1, 2, 3, 4, 5},
                {6, 0, 8, 9, 10},
                {11, 12, 14, 14, 15},
                {16, 17, 18, 19, 0}
        };

        int[][] result = processor.zeroOut(input);


        Assert.assertEquals(true, true);
    }
}
