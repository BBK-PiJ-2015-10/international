package inter.patterns.tries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class Trie {

    public class Node {

        Optional<String> character = Optional.empty();

        boolean isWord = false;

        Map<String, Node> children = new HashMap<>();

        public Node() {
        }

        public Node(String character) {
            this.character = Optional.of(character);
        }
    }

    private Node root = new Node();

    public void insert(String word) {
        insertHelper(root, word);
    }

    private void insertHelper(Node node, String word) {
        var prefix = word.substring(0, 1);
        var newNode = new Node(prefix);
        var suffix = word.substring(1, word.length());
        if (suffix.isEmpty()) {
            newNode.isWord = true;
            node.children.put(prefix, newNode);
        } else {
            node.children.put(prefix, newNode);
            insertHelper(newNode, suffix);
        }
    }

    public boolean search(String word) {
        return false;
    }

    public boolean hasPrefix(String prefix) {
        return false;
    }
}
