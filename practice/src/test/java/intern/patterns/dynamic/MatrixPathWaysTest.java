package intern.patterns.dynamic;

import inter.patterns.dynamic.MatrixPathways;
import org.junit.Assert;
import org.junit.Test;

public class MatrixPathWaysTest {

    private MatrixPathways calculator = new MatrixPathways();

    @Test
    public void test1() {

        int rows = 3;
        int columns = 3;

        int uniqueWays = calculator.getMatrixPathWays(rows, columns);

        Assert.assertEquals(6, uniqueWays);
    }

}
