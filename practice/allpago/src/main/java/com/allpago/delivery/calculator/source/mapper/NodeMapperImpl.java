package com.allpago.delivery.calculator.source.mapper;

import com.allpago.delivery.calculator.network.Node;

import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NodeMapperImpl implements NodeMapper {

    private Logger logger = LoggerFactory.getLogger(NodeMapperImpl.class);

    private HashMap<String, Node> nodes = new HashMap();

    @Override
    public Set<Node> toGraph(String nodesData) {
        processNodeData(nodesData);
        return nodes.values().stream().collect(Collectors.toSet());
    }

    private Set<Node> processNodeData(String nodesData) {
        var nodes = Arrays.asList(nodesData.split(System.lineSeparator()));
        return nodes.stream().map(ns -> toNode(ns)).collect(Collectors.toSet());
    }


    private Node toNode(String input) {
        //logger.info("Processing string: {}", input);
        List<String> nodeInfo = new ArrayList<>();
        Arrays.asList(input.split(",")).forEach(i -> nodeInfo.add(i));
        String nodeId = nodeInfo.remove(0);
        var node = nodes.get(nodeId);
        if (node == null) {
            //logger.info("Creating new node with id {}", nodeId);
            node = new Node(nodeId);
        }
        for (String linkedNodeInfo : nodeInfo) {
            var linkedNodeInfos = Arrays.asList(linkedNodeInfo.split(":"));
            var linkedNodeId = linkedNodeInfos.get(0);
            var linkedNode = nodes.get(linkedNodeId);
            if (linkedNode == null) {
                linkedNode = new Node(linkedNodeId);
                //logger.info("Creating linkedNode {} while processing node with id {}", linkedNode, nodeId);
                nodes.put(linkedNodeId, linkedNode);
            }
            var linkedCost = Integer.valueOf(linkedNodeInfos.get(1));
            node.addEdge(linkedNode, linkedCost);
        }
        //logger.info("Updated nodeId: {} to {}", nodeId, node);
        nodes.put(nodeId, node);
        return node;
    }
}
