package intern.patterns.dynamic;

import inter.patterns.dynamic.LongestPalindrome;
import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest {

    private LongestPalindrome palindrome = new LongestPalindrome();

    @Test
    public void test1(){


        String result = palindrome.longestPalindrome("rotator");

        Assert.assertTrue(true);

    }
}
