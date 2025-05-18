package jerry;

import java.util.Objects;

/**
 * Represents a starting or endpoint of a segment. A segment with an intensity of 0 signals an endpoint.
 */
public class SegmentPoint {

    // Represents the starting or end point of a segment
    public int point;

    // Represents the value of the intensity at this point
    public int intensity;

    public SegmentPoint(int point, int intensity) {
        this.point = point;
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "[" + point +
                "," + intensity +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SegmentPoint segmentPoint = (SegmentPoint) o;
        return point == segmentPoint.point && intensity == segmentPoint.intensity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, intensity);
    }
}
