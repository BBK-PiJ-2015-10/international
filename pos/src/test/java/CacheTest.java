import org.junit.Assert;
import org.junit.Test;

public class CacheTest {

    private Cache cache = new Cache(2);

    @Test
    public void givenSingleAccessThenUpdateOldestYoungest() {
        //set-up
        String key1 = "key1";
        String value1 = "aa";

        //execute
        cache.put(key1, value1);

        //verity
        Assert.assertEquals(key1, cache.getOldest());
        Assert.assertEquals(key1, cache.getYoungest());
        Assert.assertEquals(value1, cache.get(key1));
    }

    @Test
    public void givenNewAccessThenUpdateOldestYoungest() {
        //set-up
        String key1 = "key1";
        String value1 = "aa";

        String key2 = "key2";
        String value2 = "bb";

        //execute
        cache.put(key1, value1);
        cache.put(key2, value2);

        //verity
        Assert.assertEquals(key1, cache.getOldest());
        Assert.assertEquals(key2, cache.getYoungest());
        Assert.assertEquals(value1, cache.get(key1));
        Assert.assertEquals(value2, cache.get(key2));

    }

    @Test
    public void givenRepeatedAccessThenUpdateOldestYoungest() {
        //set-up
        String key1 = "key1";
        String value1 = "aa";

        String key2 = "key2";
        String value2 = "bb";

        //execute
        cache.put(key1, value1);
        cache.put(key2, value2);
        cache.get(key1);

        //verity
        Assert.assertEquals(key2, cache.getOldest());
        Assert.assertEquals(key1, cache.getYoungest());
        Assert.assertEquals(value1, cache.get(key1));
        Assert.assertEquals(value2, cache.get(key2));

    }


    @Test
    public void givenCapacityReachedWhenPutThenRemoveOldest() {
        //set-up
        String key1 = "key1";
        String value1 = "aa";

        String key2 = "key2";
        String value2 = "bb";

        String key3 = "key3";
        String value3 = "cc";

        //execute
        cache.put(key1, value1);

        Assert.assertEquals(key1, cache.getOldest());

        cache.put(key2, value2);
        cache.put(key3, value3);

        //verify
        Assert.assertEquals(key2, cache.getOldest());
        Assert.assertEquals(key3, cache.getYoungest());
        Assert.assertEquals(null, cache.get(key1));
        Assert.assertEquals(value2, cache.get(key2));
        Assert.assertEquals(value3, cache.get(key3));

    }


    @Test
    public void givenNoCacheThenWhenGetThenReturnNull() {
        //set-up
        String key1 = "key1";

        //verify
        Assert.assertEquals(null, cache.getOldest());
        Assert.assertEquals(null, cache.getYoungest());
    }

}
