package inter.patterns.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RemoveKthLastNode {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public Node removedKthLastNode(Node root, int kth) {
        int position = 0;
        Node existing = root;
        Map<Integer, Node> positionNode = new HashMap<>();
        while (existing != null) {
            positionNode.put(position, existing);
            position++;
            existing = existing.next;
        }
        int priorToKthPosition = position - kth - 1;
        int kthPostion = position - kth;
        int nextToKthPosition = position - kth + 1;
        logger.info(String.format("Size is %d, priorToKth pos is %d, nextToKth is %d ", position, priorToKthPosition, nextToKthPosition));
        var priorToKth = positionNode.get(priorToKthPosition);
        if (priorToKth != null) {
            var nextToKth = positionNode.get(nextToKthPosition);
            var kthnode = positionNode.get(kthPostion);
            kthnode.next = null;
            priorToKth.next = nextToKth;
            logger.info(String.format("Prior to kth value is %d, next to kth value is %d", priorToKth.value, nextToKth.value));
            return root;
        } else {
            return root;
        }
    }

    public Node removedKthLastNodeOptimized(Node root, int kth) {
        Node dummy = new Node(-1, root);
        Node leader = dummy;
        Node trailer = dummy;
        for (int i = 1; i <= kth; i++) {
            leader = leader.next;
        }
        while (leader.next != null) {
            leader = leader.next;
            trailer = trailer.next;
        }
        trailer.next = trailer.next.next;
        return dummy.next;
    }


}
