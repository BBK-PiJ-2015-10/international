package linkedlistmaps.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCacheImpl implements LRUCacheInter {

    private int maxSize;

    private Node youngest;

    private Node oldest;

    private Map<String, Node> values;

    public LRUCacheImpl(int maxSize) {
        this.maxSize = maxSize;
        this.values = new HashMap<>(maxSize);
    }

    private void addNode(Node node) {
        // node will become the youngest. Hence, can't have a younger
        node.younger = null;
        // make the existing youngest the older of the node
        node.older = youngest;
        if (youngest != null) {
            youngest.younger = node;
        }
        youngest = node;
        if (oldest == null) {
            oldest = node;
        }
    }

    private void removeNode(Node node) {
        var younger = node.younger;
        if (younger != null) {
            younger.older = node.older;
        } else {
            // the node was the head since it did not have a younger
            youngest = node.older;
        }
        var older = node.older;
        if (older != null) {
            older.younger = node.younger;
        } else {
            // the node was the tail since it did not have an older
            oldest = node.younger;
        }
    }


    @Override
    public void put(String key, Integer value) {
        var existing = values.get(key);
        if (existing != null) {
            existing.value = value;
            removeNode(existing);
            addNode(existing);
        } else {
            var node = new Node();
            node.key = key;
            node.value = value;
            if (values.keySet().size() == maxSize) {
                removeNode(oldest);
            }
            addNode(node);
        }
    }


    @Override
    public Optional<Integer> get(String key) {
        var node = values.get(key);
        if (node == null) {
            return Optional.empty();
        } else {
            removeNode(node);
            addNode(node);
            return Optional.of(node.value);
        }
    }
}
