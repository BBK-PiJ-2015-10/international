package codility.dinner;

import org.junit.Assert;
import org.junit.Test;

public class ShortestRotationTest {

    private ShortestRotation shortestRotationEvaluator = new ShortestRotation();


    @Test
    public void test1() {

        int[] A = new int[]{1, 3, 5, 2, 8, 7};
        int[] B = new int[]{7, 1, 9, 8, 5, 7};

        var shortestRotation = shortestRotationEvaluator.solution(A, B);

        System.out.println(shortestRotation);

        Assert.assertEquals(2, shortestRotation);
    }

    @Test
    public void test2() {

        int[] A = new int[]{1, 1, 1, 1};
        int[] B = new int[]{1, 2, 3, 4};

        var shortestRotation = shortestRotationEvaluator.solution(A, B);

        System.out.println(shortestRotation);

        Assert.assertEquals(-1, shortestRotation);
    }

    @Test
    public void test3() {

        int[] A = new int[]{3, 5, 0, 2, 4};
        int[] B = new int[]{1, 3, 10, 6, 7};

        var shortestRotation = shortestRotationEvaluator.solution(A, B);

        System.out.println(shortestRotation);

        Assert.assertEquals(0, shortestRotation);
    }

    @Test
    public void test4() {

        int[] A = new int[]{3};
        int[] B = new int[]{3};

        var shortestRotation = shortestRotationEvaluator.solution(A, B);

        System.out.println(shortestRotation);

        Assert.assertEquals(-1, shortestRotation);
    }
}
