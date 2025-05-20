package intern.patterns.intervals;

import inter.patterns.intervals.LargestOverlap;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LargestOverlapTest {


    LargestOverlap largestOverlap = new LargestOverlap();

    @Test
    public void test1() {

        List<LargestOverlap.Interval> intervals =
                List.of(new LargestOverlap.Interval(1, 3),
                        new LargestOverlap.Interval(2, 6),
                        new LargestOverlap.Interval(4, 8),
                        new LargestOverlap.Interval(6, 7),
                        new LargestOverlap.Interval(5, 7)
                );

        var result = largestOverlap.largestOverlap(intervals);

        Assert.assertEquals(result, 3);

    }


}
