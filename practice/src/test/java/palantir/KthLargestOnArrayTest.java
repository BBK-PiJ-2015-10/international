package palantir;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestOnArrayTest {

    //https://www.geeksforgeeks.org/kth-largest-element-in-an-array/

    KthLargestOnArray calculator = new KthLargestOnArray();

    @Test
    public void test1() {

        var k = 3;
        int[] array = {100, 2, 36, 450, 2000,0};

        var result = calculator.getKthLargestViaPriorityQueue(k, array);
        Assert.assertEquals(100, result);

    }

}
