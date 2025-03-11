package intern.patterns.intervals;

import org.junit.Assert;
import org.junit.Test;

public class MergingOverlappingIntervalsTest {

    @Test
    public void test1(){

        int[][] cat = new int[5][2];
        cat[0][0] = 3;
        cat[4][1] = 4;

        var dog = cat[0];

        System.out.println(cat.length);
        System.out.println(dog.length);


        Assert.assertEquals(true,true);
    }

}
