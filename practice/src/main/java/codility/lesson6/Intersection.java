package codility.lesson6;

import java.util.Objects;

public class Intersection {

    public Point left;
    public Point right;

    public Intersection(Point pointA, Point pointB) {
        if (pointA.center < pointB.center){
            left = pointA;
        } else {
            right = pointB;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
