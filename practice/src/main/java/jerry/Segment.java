package jerry;

import java.util.Objects;

public class Segment {

    // Represents the starting or end point of a segment
    public int value;

    // Represents the value of the sentiments at this point
    public int sentiment;

    public Segment(int value, int sentiment) {
        this.value = value;
        this.sentiment = sentiment;
    }

    @Override
    public String toString() {
        return "[" + value +
                "," + sentiment +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return value == segment.value && sentiment == segment.sentiment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, sentiment);
    }
}
