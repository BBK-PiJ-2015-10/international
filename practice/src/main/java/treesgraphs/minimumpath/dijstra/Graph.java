package treesgraphs.minimumpath.dijstra;

import java.util.*;

//file: https://www.baeldung.com/java-dijkstra
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
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        distancesFromSource.put(source, 0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node curretNode = getShortestDistanceNode(unsettledNodes, distancesFromSource);
            unsettledNodes.remove(curretNode);
            for (Map.Entry<Node, Integer> adjacencyPair : curretNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, curretNode, distancesFromSource);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(curretNode);
            if (curretNode == destination) {
                shortestDistance = distancesFromSource.get(curretNode);
                break;
            }
        }

        return shortestDistance;
    }

//    public void calculatorShortestDistancesFromNode(Node file) {
//
//        file.setDistance(0);
//
//        Set<Node> settledNodes = new HashSet<>();
//        Set<Node> unsettledNodes = new HashSet<>();
//
//        unsettledNodes.add(file);
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

    private Node getShortestDistanceNode(Set<Node> unsettledNodes, HashMap<Node, Integer> distances) {
        return unsettledNodes.stream().filter(n -> distances.get(n) < Integer.MAX_VALUE).min(Comparator.comparing(n -> distances.get(n))).orElseGet(null);
    }

    private void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node fromNode, HashMap<Node, Integer> distances) {
        int fromDistance = distances.get(fromNode);
        if (fromDistance + edgeWeight < distances.get(evaluationNode)) {
            distances.put(evaluationNode, fromDistance + edgeWeight);
            //List<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            //shortestPath.add(sourceNode);
            //evaluationNode.setShortestPath(shortestPath);
        }
    }

}
