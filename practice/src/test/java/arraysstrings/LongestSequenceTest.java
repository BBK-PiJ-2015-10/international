package arraysstrings;

import org.junit.Assert;
import org.junit.Test;

public class LongestSequenceTest {

    private LongestSequence longestSequence = new LongestSequence();

    @Test
    public void test1(){

        int[] sequence = {1,2,3};

        int result = longestSequence.calculateLongestSequence(sequence);

        Assert.assertEquals(3,result);

    }


    @Test
    public void test2(){

        int[] sequence = {2,2,2};

        int result = longestSequence.calculateLongestSequence(sequence);

        Assert.assertEquals(1,result);

    }

    @Test
    public void test3(){

        int[] sequence = {4,2,9,5,12,6,8};

        int result = longestSequence.calculateLongestSequence(sequence);

        Assert.assertEquals(3,result);

    }

    @Test
    public void test4(){

        int[] sequence = {2,0,6,1,4,3,8};

        int result = longestSequence.calculateLongestSequence(sequence);

        Assert.assertEquals(5,result);

    }




}
