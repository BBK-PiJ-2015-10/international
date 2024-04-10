package com.allpago.delivery.calculator.source.mapper;

import com.allpago.delivery.calculator.network.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class InputMapperImpl implements InputMapper{

    private HashMap<String,Node> nodes = new HashMap();

    public Set<Node> toGraph(String input) {
        // Todo
        // split by @
        // take first and use it to populate the input
        // second and fourth to run cases, just store
        return null;
    }


    @Override
    public Node toNode(String input) {
        var nodeInfo = Arrays.asList(input.split(","));
        var nodeId = nodeInfo.remove(0);
        var node = nodes.get(nodeId);
        if (node == null){
            node = new Node(nodeId);
        }
        for (String linkedNodeInfo: nodeInfo){
            var linkedNodeInfos = Arrays.asList(linkedNodeInfo.split(":"));
            var linkedNodeId = linkedNodeInfos.get(0);
            var linkedNode = nodes.get(linkedNodeId);
            if (linkedNode == null) {
                linkedNode = new Node(linkedNodeId);
                nodes.put(linkedNodeId,linkedNode);
            }
            var linkedCost = Integer.valueOf(linkedNodeInfos.get(1));
            node.addEdge(linkedNode,linkedCost);
        }
        nodes.put(nodeId,node);
        return node;
    }
}
