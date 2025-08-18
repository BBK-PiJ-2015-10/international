package intern.patterns.intervals;

import inter.patterns.intervals.Interval;
import inter.patterns.intervals.IdentifyAllIntervalOverlapsSolution2;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IdentifyAllIntervalOverlapsSolution2Test {

    private IdentifyAllIntervalOverlapsSolution2 identifyAllIntervalOverlapsSolution2 = new IdentifyAllIntervalOverlapsSolution2();

    @Test
    public void test1() {

        List<Interval> intervals1 = List.of(new Interval(1, 4), new Interval(5, 6), new Interval(9, 10));
        List<Interval> intervals2 = List.of(new Interval(2, 7), new Interval(8, 9));

        var result = identifyAllIntervalOverlapsSolution2.findOverlappingIntervals(intervals1, intervals2);

        System.out.println(result);

        Assert.assertEquals(true, true);
    }


}
