package leetcode.dynamicp;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring calculator = new LongestPalindromicSubstring();

    @Test
    public void test0(){

        String input = "ab";

        var left = input.substring(0,1);
        var right = input.substring(input.length()-1,input.length());
        var middle = input.substring(1,input.length()-1);
        var middleIsEmpty = middle.isEmpty();

        System.out.println(String.format("Left is %s",left));
        System.out.println(String.format("Right is %s", right));
        System.out.println(String.format("Middle is %s",middle));
        System.out.println(String.format("Middle is empty %s",middleIsEmpty));

        Assert.assertEquals(true,true);

    }


    @Test
    public void test1(){

        String input = "ab";

        var isDivisiable = calculator.longestPalindrome(input);

        Assert.assertEquals(true,true);

    }

    @Test
    public void test2(){

        String input = "abc";

        var isDivisiable = calculator.longestPalindrome(input);

        Assert.assertEquals(true,true);

    }

    @Test
    public void test4(){

        String input = "abcde";

        System.out.println(input.substring(0,1));

        //var isDivisiable = calculator.longestPalindrome(input);

        Assert.assertEquals(true,true);

    }
}
