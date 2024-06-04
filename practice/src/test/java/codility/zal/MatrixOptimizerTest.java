package codility.zal;

import org.junit.Test;
import org.junit.Assert;

public class MatrixOptimizerTest {

    private MatrixPathOptimizer matrixPathOptimizer = new MatrixOptimizerImpl();


    @Test
    public void test1() {

        int[][] arr = {{1, 2, 3},
                {4, 5, 6}};

        var maxNumber = matrixPathOptimizer.findHighestPath(arr);

        System.out.println(maxNumber);

        Assert.assertEquals(String.valueOf(1456), maxNumber);
    }

    @Test
    public void test2() {

        int[][] arr = {
                {1, 2, 9},
                {1, 5, 6}
        };

        var maxNumber = matrixPathOptimizer.findHighestPath(arr);

        System.out.println(maxNumber);

        Assert.assertEquals(String.valueOf(1296), maxNumber);
    }

    @Test
    public void test3() {

        int[][] arr = {
                {9, 9, 7},
                {9, 7, 2},
                {6, 9, 5},
                {9, 1, 2}
        };

        var maxNumber = matrixPathOptimizer.findHighestPath(arr);

        System.out.println(maxNumber);

        Assert.assertEquals(String.valueOf(997952), maxNumber);
    }

}
