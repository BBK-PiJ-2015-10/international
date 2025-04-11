package intern.patterns.linkedlist;

import inter.patterns.linkedlist.LRUCacheO1;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheO1Test {


    @Test
    public void test1() {

        LRUCacheO1 cache = new LRUCacheO1(3);

        var result = cache.get(2);

        Assert.assertEquals(-1, result);

    }

    @Test
    public void test2() {

        LRUCacheO1 cache = new LRUCacheO1(3);

        cache.place(2, 6);

        var result = cache.get(2);

        Assert.assertEquals(6, result);

    }

    @Test
    public void test3() {

        LRUCacheO1 cache = new LRUCacheO1(3);

        cache.place(1, 100);
        cache.place(2, 250);

        var result = cache.get(2);

        Assert.assertEquals(250, result);

        cache.place(4, 300);
        cache.place(3, 200);

        result = cache.get(4);

        Assert.assertEquals(300, result);

        result = cache.get(1);
        Assert.assertEquals(-1, result);

    }


}
