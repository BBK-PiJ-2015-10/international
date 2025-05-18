package jerry;

import java.util.List;

public interface IntensityProcessor {

    /**
     * Increments/decrements the intensity on the segments covered by the range from/to points provided
     *
     * @param fromPoint the starting segment point where the intensity will be added
     * @param toPoint   the ending segment point (exclusive) where the intensity will be added
     * @param intensity the incremental/decremental change on the intensity
     * @return the updated segmentations in place
     */
    List<SegmentPoint> add(int fromPoint, int toPoint, int intensity);

    /**
     * Sets the intensity on the segments covered by the range from/to points provided
     *
     * @param fromPoint the starting segment where the intensity will be set
     * @param toPoint   the ending segment point (exclusive) where the intensity will be set
     * @param intensity the value of the intensity to set
     * @return the updated segmentations in place
     */
    List<SegmentPoint> set(int fromPoint, int toPoint, int intensity);

}
