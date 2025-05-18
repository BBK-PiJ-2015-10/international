package jerry;

import java.util.Objects;

public class Segment {

    // Represents the starting or end point of a segment
    public int point;

    // Represents the value of the sentiments at this point
    public int sentiment;

    public Segment(int point, int sentiment) {
        this.point = point;
        this.sentiment = sentiment;
    }

    @Override
    public String toString() {
        return "[" + point +
                "," + sentiment +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return point == segment.point && sentiment == segment.sentiment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, sentiment);
    }
}
