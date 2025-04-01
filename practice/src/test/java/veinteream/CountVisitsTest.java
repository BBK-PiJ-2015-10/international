package veinteream;

import org.junit.Assert;
import org.junit.Test;

public class CountVisitsTest {

    private CountVisits counter = new CountVisits();

    @Test
    public void test1(){

        String route = "^<>";

        var result =  counter.countVisits(route);

        Assert.assertEquals(result,2);

    }

}
