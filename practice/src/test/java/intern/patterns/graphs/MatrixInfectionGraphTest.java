package intern.patterns.graphs;

import inter.patterns.graphs.MatrixInfection;
import org.junit.Assert;
import org.junit.Test;

public class MatrixInfectionGraphTest {

    private MatrixInfection matrixInfection = new MatrixInfection();


    @Test
    public void test1() {

        int[][] matrix = {{1, 1, 1, 0}, {0, 0, 2, 1}, {0, 1, 1, 0}};

        var result = matrixInfection.numberOfSecondsAllInfected(matrix);


        Assert.assertEquals(3, result);

    }


}
