package intern.patterns.dynamic;

import inter.patterns.dynamic.LongestCommonSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence calculator = new LongestCommonSubsequence();

    @Test
    public void test1(){

        String word1 = "acabac";
        String word2 = "aebab";

        var longestCommonSubsequence = calculator.longestCommonSubsequence(word1,word2);

        Assert.assertEquals(3,longestCommonSubsequence);
    }
}
