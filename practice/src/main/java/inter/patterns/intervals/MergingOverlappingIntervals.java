package inter.patterns.intervals;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergingOverlappingIntervals {

    public Interval mergeInterval(Interval first, Interval second) {
        var beginning = first.beginning <= second.beginning ? first.beginning : second.beginning;
        var end = first.end >= second.end ? first.end : second.end;
        return new Interval(beginning, end);
    }

    public class Interval {

        public Interval(Integer beginning, Integer end) {
            this.beginning = beginning;
            this.end = end;
        }

        public Integer beginning;
        public Integer end;

        public boolean overlap(Interval other) {
            return this.end >= other.beginning;
        }

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
        Comparator<Interval> sortByBeginning = (o1, o2) -> o1.beginning.compareTo(o2.beginning);
        intervalList.sort(sortByBeginning);
        for (Interval interval : intervalList) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(interval);
            } else {
                var lastInterval = mergedIntervals.getLast();
                if (lastInterval.overlap(interval)) {
                    var removed = mergedIntervals.removeLast();
                    var mergedInterval = mergeInterval(removed, interval);
                    mergedIntervals.add(mergedInterval);
                }
            }
        }
        return mergedIntervals;
    }
}
