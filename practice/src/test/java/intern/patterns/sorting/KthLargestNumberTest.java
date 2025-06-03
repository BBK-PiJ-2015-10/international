package intern.patterns.sorting;

import inter.patterns.sorting.KthLargestNumber;
import org.junit.Assert;
import org.junit.Test;

public class KthLargestNumberTest {

    private KthLargestNumber calculator = new KthLargestNumber();

    @Test
    public void test1() {

        int[] input = {5, 2, 4, 3, 1, 6};

        var result = calculator.getKthLargest(input, 3);

        Assert.assertEquals(result, 4);

    }
}
