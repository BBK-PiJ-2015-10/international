package treesgraphs;

public class BinaryIntTree {

    private IntNode root;

    public BinaryIntTree() {
    }

    public IntNode add(Integer value){
        IntNode node = new IntNode(value);
        if (root == null){
            root = node;
            return node;
        } else {
            return root.add(node);
        }
    }


}
