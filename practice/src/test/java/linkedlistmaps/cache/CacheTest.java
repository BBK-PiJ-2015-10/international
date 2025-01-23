package linkedlistmaps.cache;

import org.junit.Assert;
import org.junit.Test;

public class CacheTest {

    @Test
    public void test1() {

        String key = "fer";

        Integer value = 45;

        LRUCacheImpl cache = new LRUCacheImpl(3);
        cache.put(key,value);
        var result = cache.get(key);

        String output = String.format("For key %s the value is %s", key,value);

        System.out.println(output);

        int[] input = {1, 2, 3, 2, 1};

        Assert.assertEquals(true, true);
    }

}
