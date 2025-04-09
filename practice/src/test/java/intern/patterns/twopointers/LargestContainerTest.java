package intern.patterns.twopointers;

import inter.patterns.twopointers.LargestContainer;
import org.junit.Assert;
import org.junit.Test;

public class LargestContainerTest {

    private LargestContainer container = new LargestContainer();

    @Test
    public void test1(){

        int[] numbers = {2,7,8,3,7,6};

        var result = container.largestContainer(numbers);

        Assert.assertEquals(24,result);


    }

}
