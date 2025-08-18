package inter.patterns.intervals;

public class Interval {

    int from;
    int to;

    public Interval(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Interval[" +
                "from=" + from +
                ",to=" + to +
                ']';
    }
}
