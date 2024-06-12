package codility.deutsche;

import java.util.Objects;

public class Edges {

    public int x;

    public int y;

    public Edges(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edges edges = (Edges) o;
        return x == edges.x && y == edges.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
