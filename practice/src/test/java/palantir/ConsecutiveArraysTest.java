package palantir;

import org.junit.Assert;
import org.junit.Test;

public class ConsecutiveArraysTest {

    private ConsecutiveArrays consecutiveArrays = new ConsecutiveArrays();


    @Test
    public void test1() {

        var input = new int[]{1, 2, 3, 4};
        var longestConsecutive = consecutiveArrays.longestConsecutive(input);
        Assert.assertEquals(4, longestConsecutive);

    }


}
