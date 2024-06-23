package codility.dinner;

import org.junit.Assert;
import org.junit.Test;

public class ShortestRotationTest {

    private ShortestRotation shortestRotationEvaluator = new ShortestRotation();


    @Test
    public void test1() {

        int[] A = new int[]{1,3,5,2,8,7};
        int[] B = new int[]{7,1,9,8,5,7};

        var shortestRotation = shortestRotationEvaluator.solution(A,B);

        System.out.println(shortestRotation);

        Assert.assertEquals(2,shortestRotation);
    }
}
