package treesgraphs.trees.binarytree;

public class MinimalBST<T> {

    T[] values;

    Node root;

    class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    public MinimalBST(T[] values) {
        this.values = values;
        root = minimalBST(values,0, values.length-1);
    }

    private Node minimalBST(T[] inputValues,int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(inputValues[mid]);
        node.left = (minimalBST(inputValues,start,mid-1));
        node.right = (minimalBST(inputValues,mid+1,end));
        return node;
    }
}
