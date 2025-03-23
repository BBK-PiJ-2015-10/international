package inter.patterns.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GraphNode {

    int value;

    List<GraphNode> neighbors = new LinkedList<>();

    public GraphNode(int value, List<GraphNode> neighbors) {
        this.value = value;
        this.neighbors = neighbors;
    }

    public GraphNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return value == graphNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
