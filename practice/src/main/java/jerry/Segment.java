package jerry;

import java.util.Objects;

public class Segment {

    public int value;

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
