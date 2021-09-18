package patterns;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    @Test
    public void test1(){

        Pattern pattern = Pattern.compile("dog");
        String input = "dog";

        Matcher matcher = pattern.matcher(input);

        Assert.assertTrue(matcher.find());

    }

    @Test
    public void test2(){

        Pattern pattern = Pattern.compile("dog");
        String input = "dogdog";
        Matcher matcher = pattern.matcher(input);

        int matches = 0;
        while(matcher.find()){
            matches ++;
        }

        Assert.assertEquals(2,matches);

    }






}
