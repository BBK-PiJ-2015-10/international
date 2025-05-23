package jerry;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An implementation of the IntensityProcessor using a SortedMap to manage segments intensity relationships
 */
public class IntensityProcessorSortedMapImpl implements IntensityProcessor {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private SortedMap<Integer, Integer> segmentIntensityRing = new TreeMap<>();

    @Override
    public List<SegmentPoint> add(int fromPoint, int toPoint, int intensity) {
        if (intensity == 0) {
            var updatedSegmentation = mapSegment(segmentIntensityRing.entrySet());
            logger.log(Level.INFO, String.format("From: %d to: %d %s intensity %d. Updated segmentation %s", fromPoint, toPoint, "add", intensity, updatedSegmentation));
            return updatedSegmentation;
        }
        BinaryOperator<Integer> add = (x, y) -> x + y;
        return segmentBinaryOperation(fromPoint, toPoint, intensity, add, "add");
    }

    @Override
    public List<SegmentPoint> set(int fromPoint, int toPoint, int intensity) {
        BinaryOperator<Integer> set = (x, y) -> y;
        return segmentBinaryOperation(fromPoint, toPoint, intensity, set, "set");
    }

    private List<SegmentPoint> segmentBinaryOperation(int fromPoint, int toPoint, int intensity, BinaryOperator<Integer> operation, String operationName) {
        if (toPoint <= fromPoint) {
            throw new IllegalArgumentException(String.format("fromPoint %d needs to be lower than toPoint %d", fromPoint, toPoint));
        }
        if (segmentIntensityRing.isEmpty()) {
            segmentIntensityRing.put(fromPoint, intensity);
            segmentIntensityRing.put(toPoint, 0);
        } else {
            // This section updates sentiments between fromPoint(inclusive) toPoint(exclusive)
            var rangeSegments = segmentIntensityRing.subMap(fromPoint, toPoint);
            for (var segment : rangeSegments.keySet()) {
                var existingIntensity = rangeSegments.get(segment);
                var updatedIntensity = operation.apply(existingIntensity, intensity);
                rangeSegments.put(segment, updatedIntensity);
            }
            var existingFromIntensity = rangeSegments.get(fromPoint);
            // This section updates the fromPoint in cases where it was not inside the rangeSegments
            if (existingFromIntensity == null) {
                var priorSegments = segmentIntensityRing.headMap(fromPoint);
                if (priorSegments.isEmpty()) {
                    segmentIntensityRing.put(fromPoint, intensity);
                } else {
                    var beforeSegment = priorSegments.lastKey();
                    var beforeSegmentIntensity = priorSegments.get(beforeSegment);
                    var fromSegmentIntensity = operation.apply(beforeSegmentIntensity, intensity);
                    segmentIntensityRing.put(fromPoint, fromSegmentIntensity);
                }
            }
            // This section updates the toPoint
            var nextSegments = segmentIntensityRing.tailMap(toPoint);
            if (nextSegments.isEmpty() || intensity == 0) {
                segmentIntensityRing.put(toPoint, 0);
            } else {
                var firstNextSegment = nextSegments.firstKey();
                if (firstNextSegment > fromPoint) {
                    segmentIntensityRing.put(toPoint, nextSegments.get(firstNextSegment));
                }
            }
            // This section removes any segments with 0 intensity
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
        var updatedSegmentation = mapSegment(segmentIntensityRing.entrySet());
        logger.log(Level.INFO, String.format("From: %d to: %d %s intensity %d. Updated segmentation %s", fromPoint, toPoint, operationName, intensity, updatedSegmentation));
        return updatedSegmentation;
    }


    private List<SegmentPoint> mapSegment(Set<Map.Entry<Integer, Integer>> entrySet) {
        return entrySet
                .stream()
                .map(es -> (new SegmentPoint(es.getKey(), es.getValue()))).toList();
    }

}
