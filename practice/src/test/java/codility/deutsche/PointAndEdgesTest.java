package codility.deutsche;

import org.junit.Assert;
import org.junit.Test;

public class PointAndEdgesTest {

    PointsAndEdges pointsAndEdges = new PointsAndEdgesImpl();


    @Test
    public void test1() {

        int[] x = new int[]{0, 0, 10,10};
        int[] y = new int[]{0, 10, 0,10};

        var maxDistance = pointsAndEdges.distanceToTouch(x,y);

        System.out.println(maxDistance);

        Assert.assertEquals(5,maxDistance);
    }

    @Test
    public void test2() {

        int[] x = new int[]{1, 1, 8};
        int[] y = new int[]{1, 6, 0};

        var maxDistance = pointsAndEdges.distanceToTouch(x,y);

        System.out.println(maxDistance);

        Assert.assertEquals(2,maxDistance);
    }

    @Test
    public void test3() {

        int[] x = new int[]{0, 2, 3};
        int[] y = new int[]{0, 0, 0};

        var maxDistance = pointsAndEdges.distanceToTouch(x,y);

        System.out.println(maxDistance);

        Assert.assertEquals(0,maxDistance);
    }


}
