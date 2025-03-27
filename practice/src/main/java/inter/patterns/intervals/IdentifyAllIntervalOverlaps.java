package inter.patterns.intervals;

import java.util.LinkedList;
import java.util.List;

public class IdentifyAllIntervalOverlaps {

    public record Interval(int from, int to) {

    }

    public List<Interval> getAllIntervalOverlaps(List<Interval> intervals1, List<Interval> intervals2) {
        int i = 0;
        int j = 0;
        List<Interval> overlaps = new LinkedList<>();
        while (i < intervals1.size() && j < intervals2.size()) {
            var interFrom1 = intervals1.get(i);
            var interFrom2 = intervals2.get(j);
            Interval first;
            Interval second;
            if (interFrom1.from < interFrom2.from) {
                first = interFrom1;
                second = interFrom2;
            } else {
                first = interFrom2;
                second = interFrom1;
            }
            if (first.to > second.from) {
                Interval overLapInterval = new Interval(second.from, Math.min(first.to, second.to));

                overlaps.add(overLapInterval);
            }
            if (first.to < second.to) {
                i++;
            } else {
                j++;
            }
        }
        return overlaps;
    }

}
