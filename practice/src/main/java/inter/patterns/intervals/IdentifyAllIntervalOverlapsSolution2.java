package inter.patterns.intervals;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class IdentifyAllIntervalOverlapsSolution2 {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public List<Interval> findOverlappingIntervals(List<Interval> intervals1, List<Interval> intervals2) {
        List<Interval> overlappingIntervals = new LinkedList<>();
        int interval1Processed = 0;
        int interval2Processed = 0;
        while (interval1Processed < intervals1.size() && interval2Processed < intervals2.size()) {
            Interval interval1 = intervals1.get(interval1Processed);
            Interval interval2 = intervals2.get(interval2Processed);
            if (overlap(interval1, interval2)) {
                logger.info(String.format("Found overlapping intervals %s and %s", interval1, interval2));
                addOverlap(interval1, interval2, overlappingIntervals);
            }
            if (interval1.to < interval2.to) {
                interval1Processed++;
            } else {
                interval2Processed++;
            }
        }
        return overlappingIntervals;
    }

    private boolean overlap(Interval input1, Interval input2) {
        int b1 = input1.from;
        int e1 = input1.to;
        int b2 = input2.from;
        int e2 = input2.to;
        boolean input1BegOverlap = b1 >= b2 && b1 <= e2;
        boolean input1EndOverlap = e1 >= b2 && e1 <= e2;
        boolean input2BegOverlap = b2 >= b1 && b2 <= e1;
        boolean input2EndOverlap = e2 >= b1 && e2 <= e1;
        return input1BegOverlap || input1EndOverlap || input2BegOverlap || input2EndOverlap;
    }

    private void addOverlap(Interval input1, Interval input2, List<Interval> overlaps) {
        int from = input1.from > input2.from ? input1.from : input2.from;
        int to = input1.to < input2.to ? input1.to : input2.to;
        Interval overlap = new Interval(from, to);
        logger.info(String.format("Added overlap %s", overlap));
        overlaps.add(overlap);
    }
}
