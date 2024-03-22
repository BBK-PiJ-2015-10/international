package treesgraphs.graph;

import java.util.*;

public class Graph<T> {

    private HashMap<T, List<T>> adjacentMap = new HashMap<>();

    public Graph(HashMap<T, List<T>> adjacentMap) {
        this.adjacentMap = adjacentMap;
    }

    public void add(T from, T to) {
        if (from == null || to == null) {
            return;
        }
        var existingAdj = adjacentMap.get(from);
        if (existingAdj == null) {
            var newAdjList = new LinkedList<T>();
            newAdjList.add(to);
            adjacentMap.put(from, newAdjList);
        } else {
            existingAdj.add(to);
        }
    }

    public boolean isPath(T from, T to) {
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();
        if (from == null || to == null) {
            return false;
        }
        visited.add(from);
        queue.add(from);
        while (!queue.isEmpty()) {
            var adjList = adjacentMap.get(from);
            if (adjList != null) {
                for (T adj : adjList) {
                    if (!visited.contains(adj)) {
                        visited.add(adj);
                        if (adj.equals(to)) {
                            return true;
                        } else {
                            queue.add(adj);
                        }
                    }
                }
            }
        }
        return false;
    }


}
