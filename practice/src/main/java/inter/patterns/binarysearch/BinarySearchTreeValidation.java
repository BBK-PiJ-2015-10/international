package inter.patterns.binarysearch;


import java.util.logging.Logger;

public class BinarySearchTreeValidation {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    // lowest
    public boolean isBinarySearchTree(BinaryNodeVal node) {
        var leftResult = true;
        if (node.left != null) {
            if (node.left.value >= node.value) {
                logger.info(String.format("TreeNode is invalid, left %s is greaterOrEqual to root %s", node.left.value, node.value));
                leftResult = false;
            } else {
                leftResult = isBinarySearchTree(node.left);
            }
        }
        var rightResult = true;
        if (node.right != null) {
            if (node.right.value <= node.value) {
                logger.info(String.format("TreeNode is invalid, right %s is lessOrEqual to root %s", node.right.value, node.value));
                rightResult = false;
            } else {
                rightResult = isBinarySearchTree(node.right);
            }
        }
        return leftResult && rightResult;
    }


}
