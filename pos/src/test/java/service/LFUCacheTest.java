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
        String name1 = "aa";

        //execute
        lfuCache.put(id1, name1);

        //verity
        var cachedValue = lfuCache.get(id1);
        Assert.assertEquals(cachedValue.get(), name1);
    }

    @Test
    public void givenNewElementWhenCachedIsFullThenEvictEarliest() {
        //set-up
        var lfuCache = new LFUCacheImpl(2);

        int id1 = 123;
        String name1 = "aa";
        int id2 = 456;
        String name2 = "bb";
        int id3 = 789;
        String name3 = "bb";

        //execute
        lfuCache.put(id1, name1);
        lfuCache.put(id2, name2);
        lfuCache.put(id3, name3);

        //verity
        var cachedValue = lfuCache.get(id1);
        Assert.assertEquals(cachedValue.isEmpty(), true);
        Assert.assertEquals(lfuCache.get(id2).get(), name2);
        Assert.assertEquals(lfuCache.get(id3).get(), name3);

    }

    @Test
    public void givenNewElementWhenCachedIsFullThenEvictLeastUsed() {
        //set-up
        var lfuCache = new LFUCacheImpl(2);

        int id1 = 123;
        String name1 = "aa";
        int id2 = 456;
        String name2 = "bb";
        int id3 = 789;
        String name3 = "bb";

        //execute
        lfuCache.put(id1, name1);
        lfuCache.get(id1);
        lfuCache.put(id2, name2);
        lfuCache.put(id3, name3);

        //verity
        var cachedValue = lfuCache.get(id1);
        Assert.assertEquals(lfuCache.get(id1).get(), name1);
        Assert.assertEquals(lfuCache.get(id2).isEmpty(), true);
        Assert.assertEquals(lfuCache.get(id3).get(), name3);

    }


}
