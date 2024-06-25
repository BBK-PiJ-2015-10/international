package codility.lesson6;

import java.util.Objects;

public class Point {

    public long center;
    public long lowerLimit;
    public long upperLimit;

    public Point(long center, long radius) {
        this.center = center;
        this.lowerLimit = center - radius;
        this.upperLimit = center + radius;
    }

    public boolean intersect(Point otherPoint){
        if (otherPoint.center == center){
            return false;
        }
        if (otherPoint.lowerLimit >= lowerLimit && otherPoint.lowerLimit <= upperLimit) {
            return true;
        }
        if (lowerLimit >= otherPoint.lowerLimit && lowerLimit <= otherPoint.upperLimit) {
            return true;
        }
        if (otherPoint.upperLimit >= lowerLimit && otherPoint.upperLimit <= upperLimit) {
            return true;
        }
        if (upperLimit >= otherPoint.upperLimit && upperLimit <= otherPoint.lowerLimit) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return center == point.center && lowerLimit == point.lowerLimit && upperLimit == point.upperLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, lowerLimit, upperLimit);
    }
}
