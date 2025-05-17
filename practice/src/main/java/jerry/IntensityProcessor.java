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
            var updatedFromSegmentIntensity = segmentIntensityRing.get(fromSegment);
            if (updatedFromSegmentIntensity == 0) {
                segmentIntensityRing.remove(fromSegment);
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
            var priorToSegments = segmentIntensityRing.headMap(toSegment);
            if (!priorToSegments.isEmpty()) {
                var priorToSegmentIntensity = segmentIntensityRing.get(priorToSegments.lastKey());
                //logger.log(Level.INFO, String.format("ToSegment is %d PriorToSegment is value %d, intensity %d", toSegment, priorToSegments.lastKey(), priorToSegmentIntensity));
                if (priorToSegmentIntensity == 0) {
                    segmentIntensityRing.remove(toSegment);
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
        return toSegment(segmentIntensityRing.entrySet());
    }

    public List<Segment> add(int fromSegment, int toSegment, int intensity) {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        return segmentBinaryOperation(fromSegment, toSegment, intensity, add);
    }

    public List<Segment> set(int fromSegment, int toSegment, int intensity) {
        BinaryOperator<Integer> set = (x, y) -> y;
        return segmentBinaryOperation(fromSegment, toSegment, intensity, set);
    }


    private List<Segment> toSegment(Set<Map.Entry<Integer, Integer>> entrySet) {
        return entrySet
                .stream()
                .map(es -> (new Segment(es.getKey(), es.getValue()))).toList();
    }

    public List<Segment> addL(int fromSegment, int toSegment, int intensity) {
        if (segmentIntensityRing.isEmpty()) {
            segmentIntensityRing.put(fromSegment, intensity);
            segmentIntensityRing.put(toSegment, 0);
        } else {
            var rangeSegments = segmentIntensityRing.subMap(fromSegment, toSegment);
            for (var segment : rangeSegments.keySet()) {
                var existingIntensity = rangeSegments.get(segment);
                var updatedIntensity = existingIntensity + intensity;
                rangeSegments.put(segment, updatedIntensity);
            }
            // check if
            var existingFromIntensity = rangeSegments.get(fromSegment);
            if (existingFromIntensity == null) {
                var priorSegments = segmentIntensityRing.headMap(fromSegment);
                if (priorSegments.isEmpty()) {
                    segmentIntensityRing.put(fromSegment, intensity);
                } else {
                    var beforeSegment = priorSegments.lastKey();
                    var beforeSegmentIntensity = priorSegments.get(beforeSegment);
                    var fromSegmentIntensity = beforeSegmentIntensity + intensity;
                    segmentIntensityRing.put(fromSegment, fromSegmentIntensity);
                }
            }
            // remove fromSegment if intensity is 0
            var updatedFromSegmentIntensity = segmentIntensityRing.get(fromSegment);
            if (updatedFromSegmentIntensity == 0) {
                segmentIntensityRing.remove(fromSegment);
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
            // remove toSegment if prior intensity is 0
            var priorToSegments = segmentIntensityRing.headMap(toSegment);
            if (!priorToSegments.isEmpty()) {
                var priorToSegmentIntensity = segmentIntensityRing.get(priorToSegments.lastKey());
                //logger.log(Level.INFO, String.format("ToSegment is %d PriorToSegment is value %d, intensity %d", toSegment, priorToSegments.lastKey(), priorToSegmentIntensity));
                if (priorToSegmentIntensity == 0) {
                    segmentIntensityRing.remove(toSegment);
                }
            }
        }
        return toSegment(segmentIntensityRing.entrySet());
    }


}
