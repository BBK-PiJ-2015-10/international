package treesgraphs;

public class MinimalBST<T extends Comparable> {

    Node<T> root;

    public MinimalBST(T values[]) {
        root = minimalBst(0,values.length,values);
    }

    private Node minimalBst(int start, int end,T values[]){
        if (end < start){
            return null;
        }
        int middle = (start+end)/2;
        T middleValue = values[middle];
        System.out.println("Middle is "+middle);
        Node node = new Node(middleValue);
        System.out.println("Did "+middleValue);
        node.left = minimalBst(start,middle-1,values);
        node.right = minimalBst(middle+1,end,values);
        return node;
    }

}
