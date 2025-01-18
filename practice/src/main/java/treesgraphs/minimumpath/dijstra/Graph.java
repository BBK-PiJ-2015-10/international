package treesgraphs.minimumpath.dijstra;

import java.util.*;

//source: https://www.baeldung.com/java-dijkstra
// DI: Example https://medium.com/edureka/what-is-dependency-injection-5006b53af782
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public int calculatorShortestDistance(Node source, Node destination) {

        var shortestDistance = Integer.MAX_VALUE;

        // initialize to inf all nodes
        var distancesFromSource = new HashMap<Node, Integer>();
        nodes.forEach(n -> distancesFromSource.put(n, Integer.MAX_VALUE));

        // create settle and unsettle sets
        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();

        distancesFromSource.put(source, 0);
        unvisitedNodes.add(source);

        while (!unvisitedNodes.isEmpty()) {
            Node curretNode = getShortestDistanceNode(unvisitedNodes, distancesFromSource);
            unvisitedNodes.remove(curretNode);
            for (Map.Entry<Node, Integer> adjacencyPair : curretNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!visitedNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, curretNode, distancesFromSource);
                    unvisitedNodes.add(adjacentNode);
                }
            }
            visitedNodes.add(curretNode);
            if (curretNode == destination) {
                shortestDistance = distancesFromSource.get(curretNode);
                break;
            }
        }

        return shortestDistance;
    }

//    public void calculatorShortestDistancesFromNode(Node source) {
//
//        source.setDistance(0);
//
//        Set<Node> settledNodes = new HashSet<>();
//        Set<Node> unsettledNodes = new HashSet<>();
//
//        unsettledNodes.add(source);
//
//        while (!unsettledNodes.isEmpty()) {
//            Node curretNode = getShortestDistanceNode(unsettledNodes);
//            unsettledNodes.remove(curretNode);
//            for (Map.Entry<Node, Integer> adjacencyPair : curretNode.getAdjacentNodes().entrySet()) {
//                Node adjacentNode = adjacencyPair.getKey();
//                Integer edgeWeight = adjacencyPair.getValue();
//                if (!settledNodes.contains(adjacentNode)) {
//                    calculateMinimumDistance(adjacentNode, edgeWeight, curretNode);
//                    unsettledNodes.add(adjacentNode);
//                }
//            }
//            settledNodes.add(curretNode);
//        }
//    }

    private Node getShortestDistanceNode(Set<Node> unvisitedNodes, HashMap<Node, Integer> distancesFromSource) {
        return unvisitedNodes.stream()
                // want to filter to only unvisited nodes that are reachable from the source or aware at that point
                .filter(n -> distancesFromSource.get(n) < Integer.MAX_VALUE)
                // get the one closest to the source
                .min(Comparator.comparing(n -> distancesFromSource.get(n))).orElseGet(null);
    }

    private void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node currentNode, HashMap<Node, Integer> distancesFromSource) {
        // getting distances fromSource to the current node
        int fromDistance = distancesFromSource.get(currentNode);
        // comparing getting adjacent node from node vs what is on the distancesFromSource
        if (fromDistance + edgeWeight < distancesFromSource.get(evaluationNode)) {
            distancesFromSource.put(evaluationNode, fromDistance + edgeWeight);
            //List<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            //shortestPath.add(sourceNode);
            //evaluationNode.setShortestPath(shortestPath);
        }
    }

}
