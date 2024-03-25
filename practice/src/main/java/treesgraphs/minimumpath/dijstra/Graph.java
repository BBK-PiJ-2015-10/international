package treesgraphs.minimumpath.dijstra;

import java.util.*;

//source: https://www.baeldung.com/java-dijkstra
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void calculatorShortestDistancesFromNode(Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()){
            Node curretNode = getShortestDistanceNode(unsettledNodes);
            unsettledNodes.remove(curretNode);
            for (Map.Entry< Node, Integer> adjacencyPair: curretNode.getAdjacentNodes().entrySet()){
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)){
                    calculateMininumDistance(adjacentNode,edgeWeight,curretNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(curretNode);
        }
    }

    private Node getShortestDistanceNode(Set<Node> unsettledNodes) {
        return unsettledNodes.stream().filter(n -> n.getDistance() < Integer.MAX_VALUE).min(Comparator.comparing(n -> n.getDistance())).orElseGet(null);
    }

    private void calculateMininumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
        int sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeight < evaluationNode.getDistance()){
            evaluationNode.setDistance(sourceDistance+edgeWeight);
            List<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}
