package intern.patterns.binarysearch;

import inter.patterns.binarysearch.FindInsertionIndex;
import org.junit.Assert;
import org.junit.Test;

public class FindInsertionIndexTest {

    private FindInsertionIndex calculator = new FindInsertionIndex();

    @Test
    public void test1(){

        int target = 4;
        int[] array = {1,2,4,5,7,8,9};

        var result = calculator.findInsertionIndex(array,target);

        Assert.assertEquals(2,result);

    }

    @Test
    public void test2(){

        int target = 6;
        int[] array = {1,2,4,5,7,8,9};

        var result = calculator.findInsertionIndex(array,target);

        Assert.assertEquals(4,result);

    }

    @Test
    public void test3(){

        int target = 6;
        int[] array = {1,2,4};

        var result = calculator.findInsertionIndex(array,target);

        Assert.assertEquals(3,result);

    }

}
