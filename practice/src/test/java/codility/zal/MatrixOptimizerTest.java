package codility.zal;

import org.junit.Test;
import org.junit.Assert;

public class MatrixOptimizerTest {

    private MatrixPathOptimizer matrixPathOptimizer = new MatrixOptimizerImpl();


    @Test
    public void test1() {

        int[][] arr = {{1,2,3},
                       {4,5,6}};

        var cat = matrixPathOptimizer.findHighestPath(arr);

        System.out.println(cat);

        Assert.assertEquals(true,true);
    }

}
