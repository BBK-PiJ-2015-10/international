package arraysstrings;


import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubStringWithoutRepeatingCharacters calculator = new LongestSubStringWithoutRepeatingCharacters();

    @Test
    public void test1(){

        String name = "yasser";

        int result = calculator.longest(name);

        Assert.assertEquals(3,result);

    }

    @Test
    public void test2(){

        String name = "aaa";

        int result = calculator.longest(name);

        Assert.assertEquals(1,result);

    }

    @Test
    public void test3(){

        String name = "abcdefabcbb";

        int result = calculator.longest(name);

        Assert.assertEquals(6,result);

    }

    @Test
    public void test4(){

        String name = "geeksforgeeks";

        int result = calculator.longest(name);

        Assert.assertEquals(7,result);

    }




}
