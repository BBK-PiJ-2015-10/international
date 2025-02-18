package inter.patterns.heaps;

import java.util.List;
import java.util.Objects;
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

        return null;
    }

}
