package sortingsearching.sorting;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    private Sort sorter = new MergeSort();

    @Test
    public void test1() {

        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        sorter.sort(actual);
        assertArrayEquals(expected, actual);

    }
}
