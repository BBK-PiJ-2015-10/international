package codility.deutsche;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PointsAndEdgesImpl implements PointsAndEdges {

    private PointAnalyzer pointAnalyzer = new PointAnalyzer();

    public PointsAndEdgesImpl() {
    }

    @Override
    public int distanceToTouch(int[] X, int[] Y) {
        var size = X.length;
        List<Point> points = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            var point = new Point(X[i], Y[i]);
            points.add(point);
        }
        return evaluateOverlaps(points);
    }

    private int evaluateOverlaps(List<Point> points) {
        var inProcess = true;
        int maxDistance = 0;
        while (inProcess) {
            int finalMaxDistance = maxDistance;
            System.out.println("Evaluating with distance " + finalMaxDistance);
            List<Optional<Boolean>> anyOverlaps = new LinkedList<>();
            for (int i = 0; i < points.size(); i++) {
                var firstPoint = points.get(i);
                points.stream().filter(p -> !p.equals(firstPoint))
                        .map(op -> pointAnalyzer.overlap(finalMaxDistance, op, firstPoint))
                        .filter(d -> d.isPresent())
                        .forEach(d -> anyOverlaps.add(d));
            }
            if (!anyOverlaps.isEmpty()) {
                var anyExceeds = anyOverlaps.stream().filter(d -> d.get() == true).collect(Collectors.toList());
                if (anyExceeds.isEmpty()) {
                    System.out.println("Found overlaps no exceeding breaking now with maxDistance " + maxDistance);
                    inProcess = false;
                    return maxDistance;
                } else {
                    maxDistance = maxDistance - 1;
                    System.out.println("Found overlaps exceeding breaking now with maxDistance " + maxDistance);
                    inProcess = false;
                    return maxDistance;
                }
            }
            maxDistance = maxDistance + 1;
        }
        return maxDistance;
    }

}
