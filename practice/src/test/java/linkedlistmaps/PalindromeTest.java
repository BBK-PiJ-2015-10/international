package linkedlistmaps;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class PalindromeTest {

    private Palindrome palindrome = new Palindrome();

    @Test
    public void test1() {

        int[] input = {1, 2, 3, 2, 1};

        boolean result = palindrome.isPalindrome(input);

        Assert.assertEquals(true, result);
    }

    @Test
    public void test2() {

        int[] input = {1, 2, 2, 1};

        boolean result = palindrome.isPalindrome(input);

        Assert.assertEquals(true, result);
    }

    @Test
    public void test3() {

        int[] input = {1, 3, 2, 1};

        boolean result = palindrome.isPalindrome(input);

        Assert.assertEquals(false, result);
    }

    @Test
    public void test4() {

        int[] input = {1};

        boolean result = palindrome.isPalindrome(input);

        Assert.assertEquals(true, result);
    }

    @Test
    public void test5() {

        int[] input = {};

        boolean result = palindrome.isPalindrome(input);

        Assert.assertEquals(false, result);
    }

    @Test
    public void test7() {

        List<Integer> input = List.of(1,2,3,2,1);

        boolean result = palindrome.isPalindrome(input);

        Assert.assertEquals(true, result);
    }

    @Test
    public void test8() {

        List<Integer> input = List.of(1,2,3,2,2);

        boolean result = palindrome.isPalindrome(input);

        Assert.assertEquals(false, result);
    }
}
