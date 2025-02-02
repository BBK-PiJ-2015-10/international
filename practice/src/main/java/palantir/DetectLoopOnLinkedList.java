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

    public boolean isThereALoopFloyd(Node node) {
        if (node.next == null) {
            return false;
        } else {
            return isThereALoopFloydHelper(node.next, node.next.next);
        }
    }

    private boolean isThereALoopFloydHelper(Node slowNode, Node fastNode) {
        if (fastNode == null) {
            return false;
        }
        if (slowNode.data == fastNode.data) {
            return true;
        } else {
            if (slowNode.next == null) {
                return false;
            } else {
                if (fastNode.next == null) {
                    return isThereALoopFloydHelper(slowNode.next, null);
                } else {
                    return isThereALoopFloydHelper(slowNode.next, fastNode.next.next);
                }
            }
        }
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
