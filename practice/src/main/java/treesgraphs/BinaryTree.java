package treesgraphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BinaryTree<T extends Comparable> {

    private Node<T> root;

    public BinaryTree() { }

    public Node add(T value){
        Node<T> node = new Node(value);
        if (root == null){
            root = node;
            return node;
        } else {
            return root.add(node);
        }
    }

    public void BFS(){
        Queue<Node> queue = new ArrayDeque<>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.value);
            if (current.left!=null){
                queue.add(current.left);
            }
            if (current.right!=null){
                queue.add(current.right);
            }
        }

    }
}
