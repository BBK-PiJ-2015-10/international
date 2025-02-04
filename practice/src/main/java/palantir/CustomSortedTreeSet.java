package palantir;

import java.util.logging.Logger;

public class CustomSortedTreeSet {

    private Logger logger = Logger.getLogger("CustomSortedTree");

    class Node {

        public int value;

        public Node next;

        public Node previous;

        public Node(int value) {
            this.value = value;
        }

    }

    public CustomSortedTreeSet(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    private Node head;

    private Node tail;

    private int maxCapacity;

    private int currentSize = 0;

    public void add(int value) {
        add(head, value);
    }

    public int getTailValue() {
        return tail.value;
    }

    private void add(Node node, int value) {
        Node newNode = new Node(value);
        // It means the tree is empty
        if (node == null) {
            head = newNode;
            tail = newNode;
            currentSize++;
            logger.info(String.format("Added value %d size is now %d", value, currentSize));
        } else {
            // compare to value on node
            var nodeValue = node.value;
            if (value > nodeValue) {
                var previousNode = node.previous;
                // it was the head
                if (previousNode == null) {
                    head = newNode;
                } else {
                    previousNode.next = newNode;
                    newNode.previous = previousNode;
                }
                newNode.next = node;
                node.previous = newNode;
                currentSize++;
                logger.info(String.format("Added value %d size is now %d", value, currentSize));
                if (currentSize > maxCapacity) {
                    var currenTail = tail;
                    var priorToTail = currenTail.previous;
                    priorToTail.next = null;
                    tail = priorToTail;
                    currentSize--;
                    logger.info(String.format("Removed node with value %d, current size is now %d", currenTail.value, currentSize));
                }
            } else {
                if (node.next == null) {
                    //check size if you can add
                    if (maxCapacity > currentSize) {
                        // can add
                        newNode.previous = node;
                        node.next = newNode;
                        tail = newNode;
                        currentSize++;
                    } else {
                        logger.info(String.format("At capacity already, not adding %d", value));
                    }
                } else {
                    // sent it to next
                    add(node.next, value);
                }
            }
        }
    }
    
}
