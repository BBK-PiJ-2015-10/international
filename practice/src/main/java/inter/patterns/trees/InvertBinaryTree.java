package inter.patterns.trees;

import java.util.Optional;
import java.util.Stack;
import java.util.logging.Logger;

public class InvertBinaryTree {

    private Logger logger = Logger.getLogger(InvertBinaryTree.class.getCanonicalName());

    public BinaryIntegerNode invertViaStack(BinaryIntegerNode node) {
        Stack<BinaryIntegerNode> stackOfNodes = new Stack<>();
        stackOfNodes.push(node);
        while (!stackOfNodes.isEmpty()) {
            var nodeBeingInverted = stackOfNodes.pop();
            var left = nodeBeingInverted.getLeft();
            var right = nodeBeingInverted.getRight();
            nodeBeingInverted.setLeft(right);
            nodeBeingInverted.setRight(left);
            if (left != null) {
                stackOfNodes.push(left);
            }
            if (right != null) {
                stackOfNodes.push(right);
            }
        }
        return node;
    }


    public BinaryIntegerNode invert(BinaryIntegerNode node) {
        if (node.getLeft() != null) {
            swapChildren(node.getLeft());
        }
        if (node.getRight() != null) {
            swapChildren(node.getRight());
        }
        swapChildren(node);
        return node;
    }

    public void printNode(BinaryIntegerNode node) {
        printNodeHelper(node, 0);
    }

    private void printNodeHelper(BinaryIntegerNode node, int level) {
        if (node != null) {
            logger.info(String.format("Visiting on level %d the value %d", level, node.getValue()));
        }
        if (node.getLeft() != null) {
            printNodeHelper(node.getLeft(), level + 1);
        }
        if (node.getRight() != null) {
            printNodeHelper(node.getRight(), level + 1);
        }
    }


    private void swapChildren(BinaryIntegerNode node) {
        var left = node.getLeft();
        var right = node.getRight();
        var leftValue = Optional.ofNullable(right).map(l -> l.getValue());
        var rightValue = Optional.ofNullable(right).map(r -> r.getValue());
        node.setLeft(right);
        node.setRight(left);
        logger.info(String.format("Swapping left %s with right %s", leftValue, rightValue));
    }


}
