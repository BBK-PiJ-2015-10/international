package palantir;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopOnLinkedList {

    public DetectLoopOnLinkedList() {
    }

    public boolean isThereALoopNaive(Node node) {
        Set<Integer> priorNodes = new HashSet<>();
        return isThereALoopNaiveHelper(node, priorNodes);
    }

    private boolean isThereALoopNaiveHelper(Node node, Set<Integer> priorNodes) {
        if (priorNodes.contains(node.data)) {
            return true;
        } else {
            if (node.next != null) {
                priorNodes.add(node.data);
                return isThereALoopNaiveHelper(node.next, priorNodes);
            } else {
                return false;
            }
        }
    }


}
