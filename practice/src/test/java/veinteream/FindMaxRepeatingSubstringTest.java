package veinteream;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxRepeatingSubstringTest {

    private FindMaxRepeatingSubstring calculator = new FindMaxRepeatingSubstring();

    @Test
    public void test1() {

        String input = "banana";

        var result = calculator.findMaxRepeatingSubstringWithOverlap(input);

        Assert.assertEquals("ana", result);

    }

    @Test
    public void test2() {

        String input = "abcd";

        var result = calculator.findMaxRepeatingSubstringWithOverlap(input);

        Assert.assertEquals("", result);

    }

    @Test
    public void test3() {

        String input = "banana";

        var result = calculator.findMaxRepeatingSubstringWithOverlapPrac(input);

        Assert.assertEquals("ana", result);

    }


}
