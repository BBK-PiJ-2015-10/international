package treesgraphs.trees.binarytree;

//https://www.baeldung.com/java-binary-tree

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeIntImpl {

    private Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean contains(int value) {
        return containsNodeRecursive(root, value);
    }

    public void delete(int value) {
        deleteNodeRecursive(root, value);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public List<List<Integer>> levelList() {
        var levelsToNodes = new HashMap<Integer, List<Integer>>();
        levelList(levelsToNodes, 0, root);
        return levelsToNodes.values().stream().collect(Collectors.toList());
    }

    private HashMap<Integer, List<Integer>> levelList(HashMap<Integer, List<Integer>> levelsToNodes, int level, Node element) {
        var existingList = levelsToNodes.get(level);
        if (existingList == null) {
            List<Integer> levelList = new LinkedList<>();
            levelList.add(element.value);
            levelsToNodes.put(level, levelList);
        } else {
            existingList.add(element.value);
        }
        if (element.left != null) {
            levelList(levelsToNodes, level + 1, element.left);
        }
        if (element.right != null) {
            levelList(levelsToNodes, level + 1, element.right);
        }
        return levelsToNodes;
    }


    public void traverseBFS() {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            var nodeToVisit = nodes.poll();
            System.out.printf("Visiting node %d", nodeToVisit.value);
            if (nodeToVisit.left != null) {
                nodes.add(nodeToVisit.left);
            }
            if (nodeToVisit.right != null) {
                nodes.add(nodeToVisit.right);
            }
        }
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.printf("Visiting node %d", node.value);
            traverseInOrder(node.right);
        }
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.printf("Visiting node %d", node.value);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            traverseInOrder(node.right);
            System.out.printf("Visiting node %d", node.value);
        }
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        // This will basically ignore it, since it is a tree-set
        return current;
    }


    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (current.value == value) {
            return true;
        }
        return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
    }


    private int findSmallestValue(Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }


    private Node deleteNodeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value == value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteNodeRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteNodeRecursive(current.left, value);
        } else {
            current.right = deleteNodeRecursive(current.right, value);
        }
        // I don't believe this can actually happen since it is a set
        return current;
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
