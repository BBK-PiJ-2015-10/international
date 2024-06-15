package codility.matrix;

import org.junit.Assert;
import org.junit.Test;

public class MatrixOpsTest {

    private MatrixOps matrixOps = new MatrixOpsImpl();

    @Test
    public void test1() {

        int[][] A = {
                {2, 10, 1, 3},
                {10, 5, 4, 5},
                {2, 10, 2, 1},
                {25, 2, 5, 1}
        };

        var minTrailingZeros = matrixOps.minTrailingZeros(A);

        System.out.println(minTrailingZeros);

        Assert.assertEquals(1,minTrailingZeros);

    }

    @Test
    public void test2() {

        int[][] A = {
                {10, 1, 10, 1},
                {1, 1, 1, 10},
                {10, 1, 10, 1},
                {1, 10, 1, 1}
        };

        var minTrailingZeros = matrixOps.minTrailingZeros(A);

        System.out.println(minTrailingZeros);

        Assert.assertEquals(2,minTrailingZeros);

    }

    @Test
    public void test3() {

        int[][] A = {
                {10, 10, 10},
                {10, 0, 10},
                {10, 10, 10}
        };

        var minTrailingZeros = matrixOps.minTrailingZeros(A);

        System.out.println(minTrailingZeros);

        Assert.assertEquals(1,minTrailingZeros);

    }


}
