package codility.doublehanoi;

import org.junit.Assert;
import org.junit.Test;

public class DoubleHanoieTest {

    private DoubleHanoi doubleHanoi = new DoubleHanoiImpl();

    @Test
    public void test1() {

        int[] x = new int[]{2, 3, 3,4};
        int L = 3;
        int R = 1;

        var maxDisks = doubleHanoi.maxNumberOfDisk(x, L, R);

        System.out.println(maxDisks);

        Assert.assertEquals(3,maxDisks);
    }

    @Test
    public void test2() {

        int[] x = new int[]{1, 4, 5,5};
        int L = 6;
        int R = 4;

        var maxDisks = doubleHanoi.maxNumberOfDisk(x, L, R);

        System.out.println(maxDisks);

        Assert.assertEquals(4,maxDisks);
    }

    @Test
    public void test3() {

        int[] x = new int[]{5, 2, 5,2};
        int L = 8;
        int R = 1;

        var maxDisks = doubleHanoi.maxNumberOfDisk(x, L, R);

        System.out.println(maxDisks);

        Assert.assertEquals(4,maxDisks);
    }

    @Test
    public void test4() {

        int[] x = new int[]{1, 5, 5};
        int L = 2;
        int R = 4;

        var maxDisks = doubleHanoi.maxNumberOfDisk(x, L, R);

        System.out.println(maxDisks);

        Assert.assertEquals(2,maxDisks);
    }








}
