package com.allpago.delivery.calculator.distance;

import com.allpago.delivery.calculator.network.Network;
import com.allpago.delivery.calculator.network.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DistanceCalculatorImpl implements DistanceCalculator {

    private Network network;

    Logger logger = LoggerFactory.getLogger(DistanceCalculatorImpl.class);


    @Autowired
    public DistanceCalculatorImpl(Network network) {
        this.network = network;
    }

    @Override
    public void setNetwork(Set<Node> networkInput) {
        network.setNetwork(networkInput);
    }

    @Override
    public double getMinimumDistance(String startId, String destinationId) {

        var nodes = network.getNetwork();
        logger.info("Calculating distance between nodes " + startId + " and " + destinationId +"with a a graph with "+nodes.size()  +" nodes");
        Map<Node, Integer> distanceFromSource = new HashMap<>();

        //initialize to non-reachable
        nodes.forEach(n -> distanceFromSource.put(n, Integer.MAX_VALUE));


        var visitedNodes = new HashSet<Node>();
        var reachedUnvisitedNodes = new HashSet<Node>();

        var startNode = nodes.stream().filter(n -> n.getId().equals(startId)).findFirst().get();
        logger.info("Updating distance from {} to {} to value {}",startId,startNode.getId(),0);
        distanceFromSource.put(startNode,0);
        var destinationNode = nodes.stream().filter(n -> n.getId().equals(destinationId)).findFirst().get();

        reachedUnvisitedNodes.add(startNode);

        while (!reachedUnvisitedNodes.isEmpty()) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e){
//                logger.info("Someone woke me up");
//            }

            var closerUnvisitedNodeToSource = getMinimumDistance(reachedUnvisitedNodes, distanceFromSource);
            logger.info("Evaluating unvisited node with id {}",closerUnvisitedNodeToSource.getId());
            int closerUnvisitedNodeToSourceDistance = distanceFromSource.get(closerUnvisitedNodeToSource);
            logger.info("Visiting node: {} with distance {}", closerUnvisitedNodeToSource.getId(), closerUnvisitedNodeToSourceDistance);
            for (Map.Entry<Node, Integer> linkedNode : closerUnvisitedNodeToSource.getToEdges().entrySet()) {
                // update distance of linkedNodes if not yet visited
                if (!visitedNodes.contains(linkedNode.getKey())) {
                    var currentDistanceLinkedNode = distanceFromSource.get(linkedNode.getKey());
                    var distanceToLinkedNodeViaCurrent = closerUnvisitedNodeToSourceDistance + linkedNode.getValue();
                    if (currentDistanceLinkedNode > distanceToLinkedNodeViaCurrent) {
                        logger.info("Updating node: {} with distance {}", linkedNode.getKey().getId(), distanceToLinkedNodeViaCurrent);
                        distanceFromSource.put(linkedNode.getKey(), distanceToLinkedNodeViaCurrent);
                    }
                    reachedUnvisitedNodes.add(linkedNode.getKey());
                }
            }
            visitedNodes.add(closerUnvisitedNodeToSource);
            reachedUnvisitedNodes.remove(closerUnvisitedNodeToSource);
            if (closerUnvisitedNodeToSource.equals(destinationNode)) {
                return distanceFromSource.get(closerUnvisitedNodeToSource);
            }
        }
        return -1.0;
    }

    private Node getMinimumDistance(Set<Node> unvisitedNodes, Map<Node, Integer> distanceFromSource) {
        var closerNodeToSource = unvisitedNodes.stream().min(Comparator.comparing(n -> distanceFromSource.get(n)));
        return closerNodeToSource.get();
    }

}
