package inter.patterns.heaps;

import java.util.*;
import java.util.logging.Logger;

public class CombinerSortedLinkedLists {

    private Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

    private class Node {
        public Integer number;
        public Integer count;

        public Node(Integer number) {
            this.number = number;
            this.count = 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(number, node.number);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(number);
        }
    }

    public List<Integer> combine(List<Integer>... lists) {
        Map<Integer, Node> numberCount = new HashMap<>();
        for (List<Integer> list : lists) {
            for (Integer number : list) {
                var existingNode = numberCount.get(number);
                if (existingNode == null) {
                    numberCount.put(number, new Node(number));
                } else {
                    existingNode.count = existingNode.count + 1;
                }
            }
        }
        Comparator<Node> nodeComparator = (node1, node2) -> node1.number.compareTo(node2.number);
        Queue<Node> nodeHeap = new PriorityQueue<>(nodeComparator);
        numberCount.values().forEach(nc -> nodeHeap.add(nc));


        return null;
    }

}
