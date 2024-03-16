package service;

import lfu.service.LFUCacheImpl;
import org.junit.Assert;
import org.junit.Test;

public class LFUCacheTest {


    @Test
    public void givenANewElementWhenCachedIsEmtpyThenCachedNewElement() {
        //set-up
        var lfuCache = new LFUCacheImpl(2);

        int id1 = 1234;
        int name1 = 22;

        //execute
        lfuCache.put(id1, name1);

        //verity
        var cachedValue = lfuCache.get(id1);
        Assert.assertEquals(cachedValue, name1);
    }

    @Test
    public void givenNewElementWhenCachedIsFullThenEvictEarliest() {
        //set-up
        var lfuCache = new LFUCacheImpl(2);

        int id1 = 123;
        int name1 = 22;
        int id2 = 456;
        int name2 = 33;
        int id3 = 789;
        int name3 = 44;

        //execute
        lfuCache.put(id1, name1);
        lfuCache.put(id2, name2);
        lfuCache.put(id3, name3);

        //verity
        var cachedValue = lfuCache.get(id1);
        Assert.assertEquals(cachedValue, -1);
        Assert.assertEquals(lfuCache.get(id2), name2);
        Assert.assertEquals(lfuCache.get(id3), name3);

    }

    @Test
    public void givenNewElementWhenCachedIsFullThenEvictLeastUsed() {
        //set-up
        var lfuCache = new LFUCacheImpl(2);

        int id1 = 123;
        int name1 = 22;
        int id2 = 456;
        int name2 = 33;
        int id3 = 789;
        int name3 = 44;

        //execute
        lfuCache.put(id1, name1);
        lfuCache.get(id1);
        lfuCache.put(id2, name2);
        lfuCache.put(id3, name3);

        //verity
        var cachedValue = lfuCache.get(id1);
        Assert.assertEquals(lfuCache.get(id1), name1);
        Assert.assertEquals(lfuCache.get(id2), -1);
        Assert.assertEquals(lfuCache.get(id3), name3);

    }

    @Test
    public void leetExample() {
        //set-up
        var lfuCache = new LFUCacheImpl(2);

        int id1 = 3;
        int name1 = 1;
        int id2 = 2;
        int name2 = 1;
        int id3 = 2;
        int name3 = 2;
        int id4 = 4;
        int name4 = 4;
        int id5 = 3;


        //execute
        lfuCache.put(id1, name1);
        lfuCache.put(id2, name2);
        lfuCache.put(id3, name3);
        lfuCache.put(id4, name4);

        lfuCache.get(id1);
        lfuCache.put(id2, name2);
        lfuCache.put(id3, name3);

        //verity
        var cachedValue = lfuCache.get(id1);
        Assert.assertEquals(lfuCache.get(id1), name1);
        Assert.assertEquals(lfuCache.get(id2), -1);
        Assert.assertEquals(lfuCache.get(id3), name3);

    }


}
