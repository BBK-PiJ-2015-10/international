package intern.patterns.intervals;

import inter.patterns.sliding.LongestUniformSubstring;
import org.junit.Assert;
import org.junit.Test;

public class LongestUniformSubstringTest {

    private LongestUniformSubstring calculator = new LongestUniformSubstring();

    @Test
    public void test1(){

        String input = "aabcdcca";
        var result = calculator.longestUniformSubstring(input,2);
        Assert.assertEquals(5,result);

    }

}
