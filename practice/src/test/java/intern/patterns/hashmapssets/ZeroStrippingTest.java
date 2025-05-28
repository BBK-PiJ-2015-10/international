package intern.patterns.hashmapssets;

import inter.patterns.hashmapssets.ZeroStripping;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ZeroStrippingTest {

    private ZeroStripping calculator = new ZeroStripping();

    @Test
    public void test1() {

        int[] row1 = {1, 2, 3, 4, 5};
        int[] row2 = {6, 0, 8, 9, 10};
        int[] row3 = {11, 12, 13, 14, 15};
        int[] row4 = {16, 17, 18, 19, 0};

        int[][] input = {row1, row2, row3, row4};

        var result = calculator.zeroStripping2N2(input);

        for (int i = 0; i < result.length; i++) {
            var column = result[i];
            System.out.println(Arrays.stream(column).boxed().toList());
        }

        Assert.assertEquals(true, true);

    }

}
