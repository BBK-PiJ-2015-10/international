package codility.deutsche;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PointsAndEdgesImpl implements PointsAndEdges {

    @Override
    public int distanceToTouch(int[] X, int[] Y) {
        var size = X.length;
        List<Point> points = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            var point = new Point(X[i], Y[i]);
            points.add(point);
        }
        return evaluatedPoints(points);
    }


    private int evaluatedPoints(List<Point> points) {
        var inProcess = true;
        int maxDistance = 0;
        while (inProcess) {
            int finalMaxDistance = maxDistance;
            List<Edges> edges = points.stream()
                    .flatMap(p -> p.getEdges(finalMaxDistance).stream())
                    .collect(Collectors.toList());
            inProcess = edges.stream().filter(i -> Collections.frequency(edges, i) > 1).collect(Collectors.toSet()).isEmpty();
            maxDistance = maxDistance + 1;
        }
        return maxDistance;
    }

}
