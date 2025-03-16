package intern.patterns.hashmapssets;

import inter.patterns.hashmapssets.PairSumUnsorted;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PairSumUnsortedTest {

    private PairSumUnsorted calculator = new PairSumUnsorted();

    @Test
    public void test1() {

        int target = 3;
        int[] input = {-1, 3, 4, 2};

        var result = calculator.findPairSum(input, target);

        List<Integer> listResult = Arrays.stream(result).boxed().sorted().toList();

        Assert.assertEquals(List.of(0, 2), listResult);

    }

}
