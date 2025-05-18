package jerry;

import java.util.List;

public interface IntensityProcessor {

    /**
     * Increments/decrements the intensity on the segments covered by the range from/to provided
     *
     * @param fromSegment that starting segment where the intensity will be added
     * @param toSegment   the ending segment (exclusive) where the intensity will be added
     * @param intensity   the incremental/decremental change on the intensity
     * @return the updated segmentations in place
     */
    List<Segment> add(int fromSegment, int toSegment, int intensity);

    /**
     * Sets the intensity on the segments covered by the range from/to provided
     *
     * @param fromSegment hat starting segment where the intensity will be set
     * @param toSegment   the ending segment (exclusive) where the intensity will be set
     * @param intensity   the value of the intensity to set
     * @return the updated segmentations in place
     */
    List<Segment> set(int fromSegment, int toSegment, int intensity);

}
