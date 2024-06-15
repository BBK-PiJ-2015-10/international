package codility.matrix;

public class Point {

    public int x;
    public int y;
    public int value;

    public Point(int y, int x, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                '}';
    }
}
