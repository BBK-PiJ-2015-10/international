package intern.patterns.sorting;

import inter.patterns.sorting.QuickSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuickSortTest {

    private QuickSort sorter = new QuickSort();

    @Test
    public void test1() {

        int[] input = {1, 2, 3, 4, 5};

        var result = sorter.sort(input);

        Assert.assertEquals(List.of(1, 2, 3, 4, 5), Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test2() {

        int[] input = {5, 4, 3, 2, 1};

        var result = sorter.sort(input);

        Assert.assertEquals(List.of(1, 2, 3, 4, 5), Arrays.stream(result).boxed().toList());

    }

    @Test
    public void test3() {

        int[] input = {5, 20, 6, 1};

        var result = sorter.sort(input);

        Assert.assertEquals(List.of(1, 5, 6, 20), Arrays.stream(result).boxed().toList());

    }
}
