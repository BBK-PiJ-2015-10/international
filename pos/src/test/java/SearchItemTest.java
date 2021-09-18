import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class SearchItemTest {

    public SearchItem searchItem = new SearchItem();

    @Test
    public void test1(){

        String [] input = {"hello","meld","many","yellow","all","blob","test"};

        Set<Item> result = searchItem.findMatch("ell",input);
        Set<Item> expected = Set.of(new Item("hello",1),new Item("yellow",1));

        Assert.assertEquals(expected,result);

    }

    @Test
    public void test2(){

        String [] input = {"hello","meld","many","yellow","all","blob","test"};

        Set<Item> result = searchItem.findMatch("l",input);
        Set<Item> expected = Set.of(new Item("hello",2),new Item("meld",1),new Item("yellow",2),new Item("all",2),
                new Item("blob",1));

        Assert.assertEquals(expected,result);

    }


}
