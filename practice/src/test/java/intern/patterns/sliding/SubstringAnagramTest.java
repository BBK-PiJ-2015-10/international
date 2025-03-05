package intern.patterns.sliding;

import inter.patterns.sliding.SubstringAnagram;
import org.junit.Assert;
import org.junit.Test;

public class SubstringAnagramTest {

    private SubstringAnagram calculator = new SubstringAnagram();

    @Test
    public void test2() {

        String input = "caabab";
        String target = "aba";

        var result = calculator.getSubstringAnagrams(input, target);


        Assert.assertEquals(2, result);

    }

}
