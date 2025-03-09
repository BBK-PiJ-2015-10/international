package inter.patterns.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class Trie {

    private Logger logger = Logger.getLogger(Trie.class.getCanonicalName());

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
        var existingNode = node.children.get(prefix);
        var suffix = word.substring(1, word.length());
        if (existingNode == null) {
            var newNode = new Node(prefix);
            if (suffix.isEmpty()) {
                newNode.isWord = true;
                node.children.put(prefix, newNode);
            } else {
                node.children.put(prefix, newNode);
                insertHelper(newNode, suffix);
            }
        } else {
            if (suffix.isEmpty()) {
                existingNode.isWord = true;
            } else {
                insertHelper(existingNode, suffix);
            }
        }
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    private boolean searchHelper(Node node, String word) {
        var prefix = word.substring(0, 1);
        var suffix = word.substring(1, word.length());
        var existingNode = node.children.get(prefix);
        if (existingNode == null) {
            return false;
        } else {
            if (suffix.isEmpty()) {
                return existingNode.isWord;
            } else {
                return searchHelper(existingNode, suffix);
            }
        }
    }

    public boolean hasPrefix(String prefix) {
        return hasPrefixHelper(root, prefix);
    }

    public boolean hasPrefixHelper(Node node, String word) {
        var prefix = word.substring(0, 1);
        var suffix = word.substring(1, word.length());
        logger.info(String.format("Evaluating word %s, prefix %s, suffix %s", word, prefix, suffix));
        var existingNode = node.children.get(prefix);
        if (existingNode == null) {
            return false;
        } else {
            if (suffix.isEmpty()) {
                logger.info(String.format("Suffix is empty word %s, prefix %s, suffix %s", word, prefix, suffix));
                return true;
            } else {
                logger.info(String.format("Suffix is non-empty word %s, prefix %s, suffix %s", word, prefix, suffix));
                return hasPrefixHelper(existingNode, suffix);
            }
        }
    }


}
