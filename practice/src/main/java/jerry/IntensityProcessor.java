package jerry;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntensityProcessor {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private SortedMap<Integer, Integer> segmentIntensityRing = new TreeMap<>();

    public List<Segment> add(int fromSegment, int toSegment, int intensity) {
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


    private List<Segment> toSegment(Set<Map.Entry<Integer, Integer>> entrySet) {
        return entrySet
                .stream()
                .map(es -> (new Segment(es.getKey(), es.getValue()))).toList();
    }


//    public List[Segment] addIntensity(int fromSegment, int toSegment, int intensity) {
//        if (segmentIntensityRing.isEmpty()) {
//            segmentIntensityRing.put(fromSegment, 1);
//            segmentIntensityRing.put(toSegment, 0);
//        }
//
//
//        var existingSegment = segmentIntensityRing.get(fromSegment);
//
//        String ale = "adleix";
//        if (existingSegment == null) {
//
//        } else {
//            var segmentTail = segmentIntensityRing.tailMap(fromSegment);
//            if (segmentTail != null) {
//                for (Integer key : segmentTail.keySet()) {
//
//
//                }
//
//
//                //String name = "d";
//                // var cat = "cad";
//                //String other = "da";
//
//
//            } else {
//
//            }
//
//            return null;
//
//        }
//
//
//    }

}
