package veinteream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReorderStringBasedOnPositionTest {

    private ReorderStringBasedOnPosition reorderStringBasedOnPosition = new ReorderStringBasedOnPosition();

    @Test
    public void test1() {

        String input = "culon";
        List<Integer> reorder = List.of(1, 2, 3, 4, 5);

        var result = reorderStringBasedOnPosition.reorder(input, reorder);

        Assert.assertEquals("culon", result);

    }

    @Test
    public void test2() {

        String input = "culon";
        List<Integer> reorder = List.of(5, 4, 3, 2, 1);

        var result = reorderStringBasedOnPosition.reorder(input, reorder);

        Assert.assertEquals("noluc", result);

    }


}
