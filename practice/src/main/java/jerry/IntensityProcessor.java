package jerry;

import java.util.*;

public class IntensityProcessor {

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
            var existingFrom = rangeSegments.get(fromSegment);
            if (existingFrom == null) {
                var priorSegments = segmentIntensityRing.headMap(existingFrom);
                if (priorSegments == null) {
                    segmentIntensityRing.put(fromSegment, intensity);
                } else {
                    var beforeSegment = priorSegments.lastKey();
                    var beforeSegmentIntensity = priorSegments.get(beforeSegment);
                    var fromSegmentIntensity = beforeSegmentIntensity + intensity;
                    segmentIntensityRing.put(fromSegment, fromSegmentIntensity);
                }
            }
            var nextSegments = segmentIntensityRing.tailMap(toSegment);
            if (nextSegments == null) {
                // just need to add with a zero
                segmentIntensityRing.put(toSegment, 0);
            } else {
                var firstNextSegment = nextSegments.firstKey();
                if (firstNextSegment > fromSegment) {
                    segmentIntensityRing.put(toSegment, nextSegments.get(firstNextSegment));
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
