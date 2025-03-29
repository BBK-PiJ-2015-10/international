package inter.patterns.trees;

import java.util.logging.Logger;

public class BalanceTreeValidation {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * no node's left subtree and right subtree have a height difference > 1
     */
    public boolean isBalanceTree(BinaryIntegerNode node) {
        return isBalanceTreeHelper(node, 0);
    }

    boolean isBalanceTreeHelper(BinaryIntegerNode node, int unbalance) {
        if (unbalance < -1) {
            logger.info(String.format("Detected unbalance at node %d", node.getValue()));
            return false;
        }
        if (node.getLeft() != null && node.getRight() != null) {
            return isBalanceTreeHelper(node.getLeft(), unbalance) && isBalanceTreeHelper(node.getRight(), unbalance);
        }
        if (node.getLeft() != null) {
            return isBalanceTreeHelper(node.getLeft(), unbalance - 1);
        }
        if (node.getRight() != null) {
            return isBalanceTreeHelper(node.getRight(), unbalance - 1);
        }
        logger.info(String.format("Balanced reach at node %d", node.getValue()));
        return true;
    }


}
