package intern.patterns.stacks;

import inter.patterns.stacks.NextLargestNumberToTheRight;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NextLargestNumberToTheRightTest {

    private NextLargestNumberToTheRight calculator = new NextLargestNumberToTheRight();

    @Test
    public void test1() {

        int[] numbers = {5, 2, 4, 6, 1};

        var result = calculator.calculate(numbers);

        int[] expectedResult = {6, 4, 6, -1, -1};

        var expected = Arrays.stream(expectedResult).boxed().toList();

        Assert.assertEquals(expected, Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test2() {

        int[] numbers = {1, 1, 2, 3, 2, 3, 2, 4};

        var result = calculator.calculate(numbers);

        int[] expectedResult = {2, 2, 3, 4, 3, 4, 4, -1};

        var expected = Arrays.stream(expectedResult).boxed().toList();

        Assert.assertEquals(expected, Arrays.stream(result).boxed().toList());

    }


}
