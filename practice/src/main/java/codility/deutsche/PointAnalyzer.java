package codility.deutsche;

import java.util.Optional;

public class PointAnalyzer {

    public static Optional<Boolean> overlap(int distance, Point a, Point b) {
        var xDelta = Math.abs(a.x - b.x);
        var yDelta = Math.abs(a.y - b.y);
        var largestDelta = Math.max(xDelta, yDelta);
        var doubleDistance = distance * 2;
        if (largestDelta == doubleDistance) {
            return Optional.of(false);
        }
        if (largestDelta < doubleDistance) {
            return Optional.of(true);
        } else {
            return Optional.empty();
        }
    }


}
