package oop;

import org.junit.Test;
import org.junit.Assert;

public class MyHashTableTest {

    @Test
    public void test1(){

        MyHashTable<String,Integer> table = new MyHashTable<>();

        Integer input = 1;
        table.put("one",input);

        Integer result = table.get("one");

        Assert.assertEquals(input,result);

    }

    @Test
    public void test2(){

        MyHashTable<String,Integer> table = new MyHashTable<>();

        table.put("five",4);
        Integer input = 5;
        table.put("five",input);

        Integer result = table.get("five");

        Assert.assertEquals(input,result);

    }

    @Test
    public void test6(){

        MyHashTable<String,Integer> table = new MyHashTable<>();

        Integer result = table.get("six");

        Assert.assertEquals(null,result);

    }

}
