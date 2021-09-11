package arraysstrings;

import org.junit.Assert;
import org.junit.Test;

public class UniqueCharacterCounterTest {

    private UniqueCharacterCounter ucc = new UniqueCharacterCounter();

    @Test
    public void test0(){

        String input = null;
        boolean unique = ucc.unique(input);
        Assert.assertEquals(true,unique);

    }

    @Test
    public void test1(){

        String input = "dog";
        boolean unique = ucc.unique(input);
        Assert.assertEquals(true,unique);

    }

    @Test
    public void test2(){

        String input = "dogo";
        boolean unique = ucc.unique(input);
        Assert.assertEquals(false,unique);

    }

    @Test
    public void test3(){

        String input = "";
        boolean unique = ucc.unique(input);
        Assert.assertEquals(true,unique);

    }

    @Test
    public void test4(){

        String input = " ";
        boolean unique = ucc.unique(input);
        Assert.assertEquals(true,unique);

    }

    @Test
    public void test5(){

        String input = "  ";
        boolean unique = ucc.unique(input);
        Assert.assertEquals(false,unique);

    }

    @Test
    public void test6(){

        String input = "a b c";
        boolean unique = ucc.unique(input);
        Assert.assertEquals(false,unique);

    }





}
