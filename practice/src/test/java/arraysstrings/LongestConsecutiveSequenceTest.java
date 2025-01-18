package arraysstrings;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequenceTest {

    private LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

    @Test
    public void test1(){

        int[] sequence = {100,4,200,1,3,2};
        int result = longestConsecutiveSequence.longestConsecutive(sequence);
        Assert.assertEquals(4,result);

    }

    @Test
    public void test2(){

        int[] sequence = {0,-3,5,-1,7,-2,-4,1,3};
        int result = longestConsecutiveSequence.longestConsecutive(sequence);
        Assert.assertEquals(6,result);

    }



}
