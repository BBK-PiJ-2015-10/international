package intern.patterns.dynamic;

import inter.patterns.dynamic.LargestSubArraySum;
import inter.patterns.stacks.ValidExpressionValidator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LargestSubArraySumTest {

    private LargestSubArraySum calculator = new LargestSubArraySum();

    @Test
    public void test1() {

        int[] input = {3, 1, -6, 2, -1, 4, -9};

        var result = calculator.getLargestSubArraySum(input);

        var other = Arrays.stream(result).boxed().toList();

        System.out.println(other);


    }
}
