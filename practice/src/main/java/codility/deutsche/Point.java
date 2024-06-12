package codility.deutsche;

import java.util.LinkedList;
import java.util.List;

public class Point {

    public int x;

    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Edges> getEdges(Integer distance){
        List<Edges> edges = new LinkedList<>();
        var lxLy = new Edges(x-distance, y-distance);
        var lxHy = new Edges(x-distance, y+distance);
        var hxHy = new Edges(x+distance, y+distance);
        var hxLy = new Edges(x+distance, y-distance);
        edges.add(lxLy);
        edges.add(lxHy);
        edges.add(hxHy);
        edges.add(hxLy);
        return edges;
    }

}
