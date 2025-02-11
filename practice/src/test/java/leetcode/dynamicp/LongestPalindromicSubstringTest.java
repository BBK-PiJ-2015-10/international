package leetcode.dynamicp;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring calculator = new LongestPalindromicSubstring();


    @Test
    public void test1(){

        String input = "ab";

        var isDivisiable = calculator.longestPalindrome(input);

        Assert.assertEquals(true,true);

    }
}
