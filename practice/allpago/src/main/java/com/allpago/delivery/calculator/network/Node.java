package com.allpago.delivery.calculator.network;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node {

    private String id;

    private Map<Node, Integer> toEdges = new HashMap<>();

    public Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Node, Integer> getToEdges() {
        return toEdges;
    }

    public void setToEdges(Map<Node, Integer> toEdges) {
        this.toEdges = toEdges;
    }

    public void addEdge(Node node, Integer cost) {
        toEdges.put(node, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


