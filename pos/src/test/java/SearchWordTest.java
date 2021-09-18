import org.junit.Assert;
import org.junit.Test;

public class SearchWordTest {

    @Test
    public void test1(){

        SearchWord searchWord = new SearchWord();

        String input1 = "hello";
        String input2 = "mellow";
        String input3 = "yellow";
        String input4 = "coolio";

        searchWord.addWord(input1);
        searchWord.addWord(input2);
        searchWord.addWord(input3);
        searchWord.addWord(input4);

        boolean result1 = searchWord.searchWord(input1);
        Assert.assertTrue(result1);


        boolean result2 = searchWord.searchWord(input2);
        Assert.assertTrue(result2);

        boolean result3 = searchWord.searchWord("cool");
        Assert.assertFalse(result3);

        boolean result4 = searchWord.searchWord(".ellow");
        Assert.assertTrue(result4);

        boolean result5 = searchWord.searchWord("yell..");
        Assert.assertTrue(result5);

        boolean result6 = searchWord.searchWord("cool");
        Assert.assertFalse(result6);

        boolean result7 = searchWord.searchWord("he..o");
        Assert.assertTrue(result7);


    }


}
