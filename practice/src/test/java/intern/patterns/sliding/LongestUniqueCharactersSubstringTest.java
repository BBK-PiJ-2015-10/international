package intern.patterns.sliding;

import inter.patterns.sliding.LongestUniqueCharactersSubstring;
import org.junit.Assert;
import org.junit.Test;

public class LongestUniqueCharactersSubstringTest {

    private LongestUniqueCharactersSubstring calculator = new LongestUniqueCharactersSubstring();

    @Test
    public void test1(){

        String input = "abcba";

        var result = calculator.getLongestUniqueCharactersSubstring(input);

        Assert.assertEquals(3,result);

    }

    @Test
    public void test2(){

        String input = "bbbbb";

        var result = calculator.getLongestUniqueCharactersSubstring(input);

        Assert.assertEquals(1,result);

    }

    @Test
    public void test3(){

        String input = "pwwkew";

        var result = calculator.getLongestUniqueCharactersSubstring(input);

        Assert.assertEquals(3,result);

    }

}
