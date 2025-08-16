package intern.patterns.heaps;

import inter.patterns.heaps.MedianOfIntegerStream;
import org.junit.Assert;
import org.junit.Test;

public class MedianOfIntegerStreamTest {

    @Test
    public void test1() {

        MedianOfIntegerStream stream = new MedianOfIntegerStream();
        stream.add(3);
        Double median = stream.getMedian();
        Assert.assertEquals(Double.valueOf(3), median);
        stream.add(6);
        median = stream.getMedian();
        Assert.assertEquals(Double.valueOf(4.5), median);
        stream.add(9);
        median = stream.getMedian();
        Assert.assertEquals(Double.valueOf(6), median);
        stream.add(6);
        median = stream.getMedian();
        Assert.assertEquals(Double.valueOf(6), median);
        stream.add(1);
        median = stream.getMedian();
        Assert.assertEquals(Double.valueOf(6), median);
        stream.add(0);
        median = stream.getMedian();
        Assert.assertEquals(Double.valueOf(4.5), median);
        stream.add(2);
        median = stream.getMedian();
        Assert.assertEquals(Double.valueOf(3), median);


    }
}
