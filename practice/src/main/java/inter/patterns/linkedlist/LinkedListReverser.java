package inter.patterns.linkedlist;

import java.util.List;

public class LinkedListReverser {

    public Node reverseList(Node node) {
        Node previousNode = null;
        Node nextNode = null;
        Node currentNode = node;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            ;
        }
        return previousNode;
    }

    public Node reverseNodeRecurs(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        var newHead = reverseNodeRecurs(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public void print(Node node) {
        System.out.println(String.format("Node %d", node.value));
        if (node.next != null) {
            print(node.next);
        }
    }

    public List<Node> print(Node node, List<Node> nodes) {
        if (node != null) {
            nodes.add(node);
            if (node.next != null) {
                return print(node.next, nodes);
            } else {
                return nodes;
            }
        }
        return nodes;
    }


}
