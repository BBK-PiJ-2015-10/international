package jerry;

import java.util.*;

public class IntensityProcessor {

    private SortedMap<Integer, Integer> segmentIntensityRing = new TreeMap<>();

    public List<Segment> addIntensity(int fromSegment, int toSegment, int intensity) {
        if (segmentIntensityRing.isEmpty()) {
            segmentIntensityRing.put(fromSegment, intensity);
            segmentIntensityRing.put(toSegment, 0);
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
