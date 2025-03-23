package inter.patterns.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DeepCloneGraph {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public GraphNode deepCloneGraph(GraphNode graph) {
        Map<Integer, GraphNode> clonesNodes = new HashMap();
        return deepCloneGraphHelper(graph, clonesNodes);
    }

    private GraphNode deepCloneGraphHelper(GraphNode node, Map<Integer, GraphNode> clonedNodes) {
        var existingClone = clonedNodes.get(node.value);
        if (existingClone != null) {
            return existingClone;
        }
        var clone = new GraphNode(node.value);
        logger.info(String.format("Cloned node %d", clone.value));
        clonedNodes.put(node.value, clone);
        for (GraphNode neighbor : node.neighbors) {
            var clonedNeighbor = deepCloneGraphHelper(neighbor, clonedNodes);
            clone.neighbors.add(clonedNeighbor);
            logger.info(String.format("Added neighbor %d to node %d", clonedNeighbor.value, clone.value));
        }
        return clone;
    }


}
