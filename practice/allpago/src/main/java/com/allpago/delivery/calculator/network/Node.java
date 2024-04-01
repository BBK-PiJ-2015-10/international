package com.allpago.delivery.calculator.network;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private String id;

    private Map<Node,Integer> toEdges = new HashMap<>();

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

}