package intern.patterns.sorting;

import inter.patterns.sorting.CountSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CountSortTest {

    private CountSort counter = new CountSort();

    @Test
    public void test1() {

        int[] input = {6, 7, 0, 0, 5};

        var result = counter.sort(input, 7);

        Assert.assertEquals(List.of(0, 0, 5, 6, 7), Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test2() {

        int[] input = {6, 7, 0, 0, 5};

        var result = counter.sort(input, 1000);

        Assert.assertEquals(List.of(0, 0, 5, 6, 7), Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test3() {

        int[] input = {6, 1, 100, 5};

        var result = counter.sort(input, 1000);

        Assert.assertEquals(List.of(1, 5, 6, 100), Arrays.stream(result).boxed().toList());

    }


}
