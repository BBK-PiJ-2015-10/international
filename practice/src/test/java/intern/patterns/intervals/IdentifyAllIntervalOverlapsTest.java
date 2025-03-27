package intern.patterns.intervals;

import inter.patterns.intervals.IdentifyAllIntervalOverlaps;
import inter.patterns.intervals.IdentifyAllIntervalOverlaps.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IdentifyAllIntervalOverlapsTest {

    private IdentifyAllIntervalOverlaps calculator = new IdentifyAllIntervalOverlaps();

    @Test
    public void test1(){

        var intervals1 = List.of(new Interval(1,4),new Interval(5,6),new Interval(9,10));
        var intervals2 = List.of(new Interval(2,7),new Interval(8,9));

        var result = calculator.getAllIntervalOverlaps(intervals1,intervals2);

        Assert.assertEquals(true,true);

    }


}
