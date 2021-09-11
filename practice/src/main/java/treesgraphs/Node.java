package treesgraphs;

public class Node<T extends Comparable> {

    public T value;

    public Node left;

    public Node right;

    public Node(T value) {
        this.value = value;
    }

    public Node add(Node<T> newNode){
        //newValue less than value
        if (value.compareTo(newNode.value) < 0){
            //System.out.println(value+" is less than "+newNode.value);
            if (left != null){
                return left.add(newNode);
            } else {
                left = newNode;
                //System.out.println("Left of "+value +" is " +newNode);
                return newNode;
            }
        }
        //newValue higher than value
        if (value.compareTo(newNode.value) > 0){
            //System.out.println(value+" is more than "+newNode.value);
            if (right != null){
                return right.add(newNode);
            } else {
                right = newNode;
                //System.out.println("Right of "+value +" is " +newNode);
                return newNode;
            }
        }
        //same as value
        return newNode;
    }

    @Override
    public String toString() {
        return "Node{" +
            "value=" + value +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}
