package inter.patterns.intervals;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class LargestOverlap {

    public record Interval(int from, int to) {
    }

    public record Position(int position, String type) {
    }

    public int largestOverlap(List<Interval> intervals) {
        var largestInterval = 0;
        var activeIntervals = 0;
        Comparator<Position> positionComparator =
                Comparator.comparing(Position::position)
                        .thenComparing(Position::type);
        List<Position> positions = intervals
                .stream()
                .flatMap(interval -> List.of(new Position(interval.from, "s"), new Position(interval.to, "e")).stream())
                .sorted(positionComparator)
                .collect(Collectors.toList());
        for (int i = 0; i < positions.size(); i++) {
            var position = positions.get(i);
            if (position.type.equals("s")) {
                activeIntervals++;
            } else {
                activeIntervals--;
            }
            largestInterval = Math.max(activeIntervals, largestInterval);
        }
        return largestInterval;
    }

}
