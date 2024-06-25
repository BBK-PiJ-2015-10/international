package codility.lesson6;

//https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionAnalyzer {

    public int numberOfIntersections(int[] A) {

        List<Point> points = new LinkedList<>();
        List<Intersection> intersections = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            var point = new Point(i, A[i]);
            points.add(point);
        }
        while (!points.isEmpty()){
            var point = points.remove(0);
            points.remove(point);
            var inters = points.stream().filter(op -> point.intersect(op)).map(op -> new Intersection(op, point)).collect(Collectors.toList());
            intersections.addAll(inters);
            if (intersections.size() > 10000000) {
                return -1;
            }
        }
        return intersections.size();
    }
}
