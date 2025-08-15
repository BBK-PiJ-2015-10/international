package inter.patterns.heaps;

import java.util.logging.Logger;

public class MedianOfIntegerStream {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int count = 0;

    private Median median;

    public class Median {
        Node left;
        Node right;

        public Median(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public class Node {
        int value;
        Node next;
        Node prior;

        public Node(int value) {
            this.value = value;
        }
    }

    public void add(int valueToAdd) {
        count++;
        if (median == null) {
            median = new Median(new Node(valueToAdd), null);
        } else if (median.right == null) {
            median.right = new Node(valueToAdd);
        } else if (valueToAdd > median.left.value && valueToAdd < median.right.value) {
            // if in between replaced the right
            var newNode = new Node(valueToAdd);
            newNode.next = median.right;
            median.right.prior = newNode;
            median.right = newNode;
        } else {
            if (!(valueToAdd > median.left.value)) {
                addLeft(valueToAdd, median.left);
                // add to left
            } else {
                addRight(valueToAdd, median.right);
                // add to right
            }
        }
    }


    private void addLeft(int valueToAdd, Node node) {
        // pass down
        if (valueToAdd <= node.value) {
            if (node.next != null) {
                addLeft(valueToAdd, node.next);
            } else {
                var newNode = new Node(valueToAdd);
                node.next = newNode;
                newNode.prior = node;
            }
        }
        // replace
        else {
            var newNode = new Node(valueToAdd);
            newNode.prior = node.prior;
            newNode.next = node;
            node.prior.next = newNode;
            node.prior = newNode;
        }
    }

    private void addRight(int valueToAdd, Node node) {
        // pass down
        if (valueToAdd >= node.value) {
            if (node.next != null) {
                addRight(valueToAdd, node.next);
            } else {
                var newNode = new Node(valueToAdd);
                node.next = newNode;
                newNode.prior = node;
            }
        }
        // replace
        else {
            var newNode = new Node(valueToAdd);
            newNode.prior = node.prior;
            newNode.next = node;
            node.prior.next = newNode;
            node.prior = newNode;
        }
    }

    public double getMedian() {
        if (count == 0) {
            return 0;
        }
        if (count % 2 == 0) {
            double left = median.left.value;
            double right = median.right.value;
            // double medianResult = (median.left.value + median.right.value) / 2;
            double medianResult = (left + right) / 2;
            logger.info(String.format("Left is %s, right is %s, median is %s", left, right, medianResult));
            return medianResult;
        } else {
            return median.left.value;
        }
    }

}
