package intern.patterns.heaps;

import inter.patterns.heaps.CombinerSortedLinkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CombinerSortedLinkedListsTest {

    private CombinerSortedLinkedLists combiner = new CombinerSortedLinkedLists();

    @Test
    public void test1() {

        var l1 = List.of(1, 6);
        var l2 = List.of(1, 4, 6);
        var l3 = List.of(3, 7);

        var expectedResult = List.of(1, 1, 3, 4, 6, 6, 7);

        var result = combiner.combine(l1, l2, l3);


        Assert.assertEquals(expectedResult, result);

    }


}
