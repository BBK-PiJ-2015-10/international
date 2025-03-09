package intern.patterns.tries;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    @Test
    public void test1(){


        var input = "a";

        var cat  = input.substring(1,input.length());

        var bool = cat.isBlank();

        System.out.println(bool);

        System.out.println(cat);

        Assert.assertEquals(true,true);

    }


}
