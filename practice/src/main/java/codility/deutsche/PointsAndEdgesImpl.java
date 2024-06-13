package codility.deutsche;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PointsAndEdgesImpl implements PointsAndEdges {

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
            for (int i = 0; i < points.size(); i++) {
                var firstPoint = points.get(i);
                var anyOverlaps = points.stream().filter(p -> !p.equals(firstPoint))
                        .map(op -> PointAnalyzer.overlap2(finalMaxDistance,op,firstPoint))
                        .filter(d -> d.isPresent()).collect(Collectors.toList());
                if (!anyOverlaps.isEmpty()){
                    var anyExceeds = anyOverlaps.stream().filter(d -> d.get()==true).collect(Collectors.toList());
                    if (anyExceeds.isEmpty()){
                        System.out.println("Found overlaps no exceeding breaking now with maxDistance " + maxDistance);
                        inProcess = false;
                        return maxDistance;
                    } else {
                        maxDistance = maxDistance -1;
                        System.out.println("Found overlaps exceeding breaking now with maxDistance " + maxDistance);
                        inProcess = false;
                        return maxDistance;
                    }
                }
            }
            maxDistance = maxDistance + 1;
        }
        return maxDistance;
    }


    private int evaluatedPoints(List<Point> points) {
        var inProcess = true;
        int maxDistance = 1;
        while (inProcess) {
            int finalMaxDistance = maxDistance;
            System.out.println("Evaluating with distance " + finalMaxDistance);
            List<Edges> edges = points.stream()
                    .flatMap(p -> p.getEdges(finalMaxDistance).stream())
                    .collect(Collectors.toList());
            Set<Edges> duplicates = edges.stream().filter(i -> Collections.frequency(edges, i) > 1).collect(Collectors.toSet());
            duplicates.forEach(d -> System.out.println("WEF " +d));
            inProcess = duplicates.isEmpty();
            //System.out.println("inProcess is " + inProcess);
            maxDistance = maxDistance + 1;
            System.out.println("Updated maxDistance " + maxDistance);
        }
        return maxDistance-1;
    }

    // should be if LY, HY of A is between (LY, HY) of B
    // also LX,HX of A is between LX,HX of B

}
