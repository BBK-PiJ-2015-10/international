package intern.patterns.twopointers;

import inter.patterns.twopointers.PairSum;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PairSumTest {

    private PairSum pairSum = new PairSum();

    @Test
    public void test1() {

        int[] input = {-5, -2, 3, 4, 6};
        int target = 7;

        var result = pairSum.getAnyPairSum(input, target);

        System.out.println(String.format("Result is %s",result));

        Assert.assertEquals(true, result.isPresent());

    }

}
