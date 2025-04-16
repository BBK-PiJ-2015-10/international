package inter.patterns.binarysearch;

public class BinaryNodeVal {

    public int value;
    public BinaryNodeVal left;
    public BinaryNodeVal right;

    public BinaryNodeVal(int value, BinaryNodeVal left, BinaryNodeVal right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryNodeVal(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
