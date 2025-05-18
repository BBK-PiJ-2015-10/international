package jerry;

import java.util.Objects;

public class Segment {

    // Represents the starting or end point of a segment
    public int point;

    // Represents the value of the intensity at this point
    public int intensity;

    public Segment(int point, int intensity) {
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
        Segment segment = (Segment) o;
        return point == segment.point && intensity == segment.intensity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, intensity);
    }
}
