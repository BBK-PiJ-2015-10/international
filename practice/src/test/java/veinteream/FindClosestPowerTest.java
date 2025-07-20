package veinteream;

import org.junit.Assert;
import org.junit.Test;

public class FindClosestPowerTest {

    private FindClosestPower findClosestPower = new FindClosestPower();

    @Test
    public void test1() {

        var maxValue = 8;
        var base = 2;

        var closestPower = findClosestPower.findPower(maxValue, base);

        Assert.assertEquals(3, closestPower);

    }

    @Test
    public void test2() {

        var maxValue = 9;
        var base = 2;

        var closestPower = findClosestPower.findPower(maxValue, base);

        Assert.assertEquals(3, closestPower);

    }

    @Test
    public void test3() {

        var maxValue = 15;
        var base = 2;

        var closestPower = findClosestPower.findPower(maxValue, base);

        Assert.assertEquals(3, closestPower);

    }

    @Test
    public void test4() {

        var maxValue = 15;
        var base = 2;

        var closestPower = findClosestPower.findClosestPower(maxValue, base);

        Assert.assertEquals(3, closestPower);

    }

    @Test
    public void test5() {

        var maxValue = 8;
        var base = 2;

        var closestPower = findClosestPower.findClosestPower(maxValue, base);

        Assert.assertEquals(3, closestPower);

    }

    @Test
    public void test6() {

        var maxValue = 9;
        var base = 2;

        var closestPower = findClosestPower.findClosestPower(maxValue, base);

        Assert.assertEquals(3, closestPower);

    }


}
