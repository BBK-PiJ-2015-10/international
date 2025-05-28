package intern.patterns.sorting;

import inter.patterns.sorting.MergeSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSortTest {

    private MergeSort mergeSort = new MergeSort();

    @Test
    public void test1(){

        int[] input = {3,7,2,23,11};

        var result = mergeSort.sort(input);

        var cat = Stream.of(result).flatMap(e -> Arrays.stream(e).boxed()).toList();

        System.out.println(cat);

    }
}
