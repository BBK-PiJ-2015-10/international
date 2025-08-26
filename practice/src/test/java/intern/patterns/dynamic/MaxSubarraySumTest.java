package intern.patterns.dynamic;


import inter.patterns.dynamic.MaximumSubarraySum;
import org.junit.Assert;
import org.junit.Test;

public class MaxSubarraySumTest {

    private MaximumSubarraySum calculator = new MaximumSubarraySum();

    @Test
    public void test1(){

        int [] input = {3,1,-6,2,-1,4,-9};

        int result = calculator.maxSubArraySum(input);

        Assert.assertEquals(5,result);

    }

}
