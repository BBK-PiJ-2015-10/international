package intern.patterns.twopointers;

import inter.patterns.twopointers.ShiftZeroesToEnd;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShiftZeroesToEndTest {

    private ShiftZeroesToEnd shiftZeroesToEnd = new ShiftZeroesToEnd();

    @Test
    public void test1() {

        int[] nums = {0, 1, 0, 3, 2};

        var result = shiftZeroesToEnd.shiftZerosToEnd(nums);

        var printableResult = Arrays.stream(result).boxed().collect(Collectors.toList());

        Assert.assertEquals(List.of(1, 3, 2, 0, 0), printableResult);

        System.out.println(printableResult);


    }

}
