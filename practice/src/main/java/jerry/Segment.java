package jerry;

public class Segment {

    public int value;

    public int sentiment;

    public Segment(int value, int sentiment) {
        this.value = value;
        this.sentiment = sentiment;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "value=" + value +
                ", sentiment=" + sentiment +
                '}';
    }
}
