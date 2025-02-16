package intern.patterns.twopointers;

import inter.patterns.twopointers.PairSum;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class PairSumTest {

    private PairSum pairSum = new PairSum();

    @Test
    public void test1() {

        int[] input = {-5, -2, 3, 4, 6};
        int target = 7;

        var expectedResult = Optional.of(new PairSum.Pair(2, 3));

        Optional<PairSum.Pair> result = pairSum.getAnyPairSum(input, target);

        System.out.println(String.format("Result is %s", result));

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test2() {

        int[] input = {1, 1, 1};
        int target = 2;
        var expectedResults = List.of(
                Optional.of(new PairSum.Pair(1, 0)),
                Optional.of(new PairSum.Pair(0, 2)),
                Optional.of(new PairSum.Pair(2, 0)),
                Optional.of(new PairSum.Pair(1, 2)),
                Optional.of(new PairSum.Pair(2, 1))
        );

        Optional<PairSum.Pair> result = pairSum.getAnyPairSum(input, target);

        System.out.println(String.format("Result is %s", result));

        Assert.assertTrue(expectedResults.contains(result));

    }

}
