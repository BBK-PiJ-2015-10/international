package intern.patterns;

import inter.patterns.Practice;
import org.junit.Assert;
import org.junit.Test;

public class PracticeTest {

    private Practice practice = new Practice();

    @Test
    public void findInsertionIndex(){

        int target = 4;
        int[] input = {1,2,4,5,7,8,9};

        var result = practice.findInsertionIndexRecurs(input,target);

        Assert.assertEquals(result,2);
    }

    @Test
    public void findInsertionIndex2(){

        int target = 6;
        int[] input = {1,2,4,5,7,8,9};

        var result = practice.findInsertionIndexRecurs(input,target);

        Assert.assertEquals(4,result);
    }

    @Test
    public void findInsertionIndex3(){

        int target = 4;
        int[] input = {0,1,2,5,7,8,9};

        var result = practice.findInsertionIndexRecurs(input,target);

        Assert.assertEquals(3,result);
    }

}
