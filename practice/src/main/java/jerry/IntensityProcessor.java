package jerry;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.logging.Logger;

public class IntensityProcessor {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private SortedMap<Integer, Integer> segmentIntensityRing = new TreeMap<>();

    private List<Segment> segmentBinaryOperation(int fromSegment, int toSegment, int intensity, BinaryOperator<Integer> operation) {
        if (toSegment <= fromSegment) {
            throw new IllegalArgumentException(String.format("fromSegment %d needs to be lower than toSegment %d", fromSegment, toSegment));
        }
        if (segmentIntensityRing.isEmpty()) {
            segmentIntensityRing.put(fromSegment, intensity);
            segmentIntensityRing.put(toSegment, 0);
        } else {
            var rangeSegments = segmentIntensityRing.subMap(fromSegment, toSegment);
            for (var segment : rangeSegments.keySet()) {
                var existingIntensity = rangeSegments.get(segment);
                var updatedIntensity = operation.apply(existingIntensity, intensity);
                rangeSegments.put(segment, updatedIntensity);
            }
            var existingFromIntensity = rangeSegments.get(fromSegment);
            if (existingFromIntensity == null) {
                var priorSegments = segmentIntensityRing.headMap(fromSegment);
                if (priorSegments.isEmpty()) {
                    segmentIntensityRing.put(fromSegment, intensity);
                } else {
                    var beforeSegment = priorSegments.lastKey();
                    var beforeSegmentIntensity = priorSegments.get(beforeSegment);
                    var fromSegmentIntensity = operation.apply(beforeSegmentIntensity, intensity);
                    segmentIntensityRing.put(fromSegment, fromSegmentIntensity);
                }
            }
            var nextSegments = segmentIntensityRing.tailMap(toSegment);
            if (nextSegments.isEmpty()) {
                segmentIntensityRing.put(toSegment, 0);
            } else {
                var firstNextSegment = nextSegments.firstKey();
                if (firstNextSegment > fromSegment) {
                    segmentIntensityRing.put(toSegment, nextSegments.get(firstNextSegment));
                }
            }
            var allSegments = segmentIntensityRing.keySet().stream().toList();
            for (int currentSegmentPos = allSegments.size() - 1; currentSegmentPos >= 0; currentSegmentPos--) {
                var currentSegment = allSegments.get(currentSegmentPos);
                var currentSegmentIntensity = segmentIntensityRing.get(currentSegment);
                if (currentSegmentIntensity == 0) {
                    if (currentSegmentPos == 0) {
                        segmentIntensityRing.remove(currentSegment);
                    } else {
                        var priorSegment = allSegments.get(currentSegmentPos - 1);
                        var priorSegmentIntensity = segmentIntensityRing.get(priorSegment);
                        if (priorSegmentIntensity == 0) {
                            segmentIntensityRing.remove(currentSegment);
                        }
                    }
                }
            }
        }
        return mapSegment(segmentIntensityRing.entrySet());
    }

    public List<Segment> add(int fromSegment, int toSegment, int intensity) {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        return segmentBinaryOperation(fromSegment, toSegment, intensity, add);
    }

    public List<Segment> set(int fromSegment, int toSegment, int intensity) {
        BinaryOperator<Integer> set = (x, y) -> y;
        return segmentBinaryOperation(fromSegment, toSegment, intensity, set);
    }


    private List<Segment> mapSegment(Set<Map.Entry<Integer, Integer>> entrySet) {
        return entrySet
                .stream()
                .map(es -> (new Segment(es.getKey(), es.getValue()))).toList();
    }

}
