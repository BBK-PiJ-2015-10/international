package inter.patterns.intervals;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MergingOverlappingIntervals {

    private Logger logger = Logger.getLogger(MergingOverlappingIntervals.class.getName());

    public Interval mergeInterval(Interval first, Interval second) {
        var beginning = first.beginning <= second.beginning ? first.beginning : second.beginning;
        var end = first.end >= second.end ? first.end : second.end;
        return new Interval(beginning, end);
    }

    public record Interval(Integer beginning, Integer end) {
    }

    // intervals, beg-end
    public List<Interval> findOverlappingIntervals(int[][] intervals) {
        List<Interval> intervalList = new LinkedList<>();
        List<Interval> mergedIntervals = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            var inter = intervals[i];
            var interval = new Interval(inter[0], inter[1]);
            intervalList.add(interval);
        }
        Comparator<Interval> sortByBeginning = Comparator.comparing(o -> o.beginning);
        intervalList.sort(sortByBeginning);
        for (Interval interval : intervalList) {
            logger.info(String.format("Processing %s", interval));
            if (mergedIntervals.isEmpty()) {
                logger.info(String.format("Adding to merged intervals %s", interval));
                mergedIntervals.add(interval);
            } else {
                var lastInterval = mergedIntervals.getLast();
                if (lastInterval.end >= interval.beginning) {
                    var removed = mergedIntervals.removeLast();
                    logger.info(String.format("Found overlap between %s and %s", removed, interval));
                    var mergedInterval = mergeInterval(removed, interval);
                    logger.info(String.format("Replacing overlap with %s", mergedInterval));
                    mergedIntervals.add(mergedInterval);
                } else {
                    mergedIntervals.add(interval);
                }
            }
        }
        return mergedIntervals;
    }
}
