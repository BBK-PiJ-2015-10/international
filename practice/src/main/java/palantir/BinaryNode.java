package palantir;

class BinaryNode {
    public int cost;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int cost, BinaryNode left, BinaryNode right) {
        this.cost = cost;
        this.left = left;
        this.right = right;
    }
}
