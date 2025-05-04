package inter.patterns.trees;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTree {

    private Integer preOrderIndex = null;

    private Map<Integer, Integer> inOrderIndexMap;

    public TreeNode reconsTructBinaryTree(int[] preOrder, int[] inOrder) {
        inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }
        preOrderIndex = 0;
        return buildSubtree(0, inOrder.length - 1, preOrder);
    }


    private TreeNode buildSubtree(int left, int right, int[] preOrder) {
        if (left > right) {
            return null;
        }
        int preorderValue = preOrder[preOrderIndex];
        int inOrderIndex = inOrderIndexMap.get(preorderValue);
        var node = new TreeNode(preorderValue);
        preOrderIndex++;
        node.setLeft(buildSubtree(left, inOrderIndex - 1, preOrder));
        node.setRight(buildSubtree(inOrderIndex + 1, right, preOrder));
        return node;
    }

}
