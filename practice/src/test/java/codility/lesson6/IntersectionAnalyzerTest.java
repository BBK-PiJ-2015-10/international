package codility.lesson6;

import org.junit.Assert;
import org.junit.Test;

public class IntersectionAnalyzerTest {

    private IntersectionAnalyzer intersectionAnalyzer = new IntersectionAnalyzer();

    @Test
    public void test1() {

        int[] A = new int[]{1, 5, 2, 1, 4, 0};

        var numberOfIntersections = intersectionAnalyzer.numberOfIntersections(A);

        System.out.println(numberOfIntersections);

        Assert.assertEquals(11,numberOfIntersections);
    }

    @Test
    public void test2() {

        int[] A = new int[]{1,  2147483647, 0};

        var numberOfIntersections = intersectionAnalyzer.numberOfIntersections(A);

        System.out.println(numberOfIntersections);

        Assert.assertEquals(0,numberOfIntersections);
    }

}
