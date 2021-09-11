package treesgraphs;

public class IntNode {

    public Integer value;

    public IntNode left;

    public IntNode right;

    public IntNode(Integer value) {
        this.value = value;
    }

    public IntNode add(IntNode newNode){
        //newValue less than value
        if (value > newNode.value){
            if (left != null){
                return left.add(newNode);
            } else {
                left = newNode;
                System.out.println("Added "+newNode.value +"to the left of " +value);
                return newNode;
            }
        }
        //newValue higher than value
        if (value < newNode.value){
            if (right != null){
                return right.add(newNode);
            } else {
                right = newNode;
                System.out.println("Added "+newNode.value +"to the right of " +value);
                return newNode;
            }
        }
        //same as value
        return newNode;
    }

    @Override
    public String toString() {
        return "IntNode{" +
            "value=" + value +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}
