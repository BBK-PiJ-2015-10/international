package intern.patterns.binarysearch;

import inter.patterns.binarysearch.FindFirstAndLastOccurrences;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindFirstAndLastOccurrencesTest {

    private FindFirstAndLastOccurrences calculator = new FindFirstAndLastOccurrences();

    @Test
    public void test1() {

        int target = 4;
        int[] array = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11};

        var result = calculator.findFirstAndLastOccurrences(array, target);

        int[] expected = {3, 5};
        var expectedResult = Arrays.stream(expected).boxed().toList();

        Assert.assertEquals(expectedResult, Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test2() {

        int target = 5;
        int[] array = {1, 2, 3, 4, 4, 4, 4, 6, 7, 8, 9, 10, 11};

        var result = calculator.findFirstAndLastOccurrences(array, target);

        int[] expected = {-1, -1};
        var expectedResult = Arrays.stream(expected).boxed().toList();

        Assert.assertEquals(expectedResult, Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test3() {

        int target = 5;
        int[] array = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11};

        var result = calculator.findFirstAndLastOccurrences(array, target);

        int[] expected = {6, 6};
        var expectedResult = Arrays.stream(expected).boxed().toList();

        Assert.assertEquals(expectedResult, Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test4() {

        int target = 1;
        int[] array = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11};

        var result = calculator.findFirstAndLastOccurrences(array, target);

        int[] expected = {0, 0};
        var expectedResult = Arrays.stream(expected).boxed().toList();

        Assert.assertEquals(expectedResult, Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test5() {

        int target = 3;
        int[] array = {1, 2, 3};

        var result = calculator.findFirstAndLastOccurrences(array, target);

        int[] expected = {2,2};
        var expectedResult = Arrays.stream(expected).boxed().toList();

        Assert.assertEquals(expectedResult, Arrays.stream(result).boxed().toList());

    }




}
