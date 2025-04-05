package veinteream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SearchValueTest {

    public SearchValue searchValue = new SearchValue();


    @Test
    public void test1(){

        int value = 1;
        var numbers = List.of(1,2,3,4);

        var result = searchValue.searchValue(numbers,value);


        Assert.assertEquals(List.of(1,0,1,0),result);
    }

}
