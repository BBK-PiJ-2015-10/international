package codility.str;

import org.junit.Test;
import org.junit.Assert;

public class StringAlgosTest {

    private StringAlgos stringAlgos = new StringAlgosImpl();


    @Test
    public void test1() {

        String input = "ABCDE";

        var result = stringAlgos.longestSubStringWithOutRepeatingCharacters(input);

        Assert.assertEquals(5, result);
    }

    @Test
    public void test2() {

        String input = "ABCDEFGABEF";

        var result = stringAlgos.longestSubStringWithOutRepeatingCharacters(input);

        Assert.assertEquals(7, result);

    }

    @Test
    public void test3() {

        String input = "GEEKSFORGEEKS";

        var result = stringAlgos.longestSubStringWithOutRepeatingCharacters(input);

        Assert.assertEquals(7, result);

    }


}
