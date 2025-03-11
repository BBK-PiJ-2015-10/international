package intern.patterns.intervals;

import inter.patterns.intervals.MergingOverlappingIntervals;
import org.junit.Assert;
import org.junit.Test;

public class MergingOverlappingIntervalsTest {

    private MergingOverlappingIntervals calculator = new MergingOverlappingIntervals();

    @Test
    public void test1() {

        int[][] intervals = new int[5][2];
        intervals[0][0] = 3;
        intervals[0][1] = 4;
        intervals[1][0] = 7;
        intervals[1][1] = 8;
        intervals[2][0] = 2;
        intervals[2][1] = 5;
        intervals[3][0] = 6;
        intervals[3][1] = 7;
        intervals[4][0] = 1;
        intervals[4][1] = 4;

        var result = calculator.findOverlappingIntervals(intervals);


        Assert.assertEquals(2, result.size());
    }

}
