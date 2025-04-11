package inter.patterns.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LRUCacheO1 {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private int capacity;

    private Map<Integer, LRUNode> cache;

    private LRUNode oldest = null;

    private LRUNode youngest = null;


    public class LRUNode {
        int key;
        int value;

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        LRUNode next;
        LRUNode previous;

        @Override
        public String toString() {
            return "LRUNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    ", previous=" + previous +
                    '}';
        }
    }

    private void removeNode(int key, LRUNode node) {
        if (node != null) {
            if (node.key == key) {
                logger.info(String.format("Found node to remove for key %d ", key));
                // remove all pointers
                if (node.previous == null) {
                    // it is the oldest
                    oldest = node.next;
                } else {
                    node.previous.next = node.next;
                }
                if (node.next == null) {
                    // it is the youngest
                    youngest = node.previous;
                } else {
                    node.next.previous = node.previous;
                }
            } else {
                // pass it to the next
                logger.info(String.format("Passing remove to next for key %d ", key));
                removeNode(key, node.next);
            }
        }
    }

    private void addNode(LRUNode nodeToAdd) {
        if (oldest == null) {
            logger.info(String.format("Node with key %d is the new oldest", nodeToAdd.key));
            oldest = nodeToAdd;
        }
        if (youngest != null) {
            youngest.next = nodeToAdd;
            nodeToAdd.previous = youngest;
        }
        logger.info(String.format("Node with key %d is the new youngest", nodeToAdd.key));
        youngest = nodeToAdd;
    }


    public LRUCacheO1(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public void place(int key, int value) {
        var existing = cache.get(key);
        var nodeToAdd = new LRUNode(key,value);
        // exist => update, remove, and add
        if (existing != null) {
            logger.info(String.format("Key %d already exist just updating", key));
            cache.put(key, nodeToAdd);
            removeNode(key, oldest);
            addNode(nodeToAdd);
        } else {
            logger.info(String.format("Key %d does not exist need to add", key));
            // at capacity, remove oldest, and add new
            if (capacity == cache.size()) {
                logger.info(String.format("At capacity need to remove oldest, to host key %d", key));
                var oldestKeyToRemove = oldest.key;
                cache.remove(oldestKeyToRemove);
                var nextToOldest = oldest.next;
                if (nextToOldest != null) {
                    nextToOldest.previous = null;
                }
                oldest = oldest.next;
            }
            cache.put(key, nodeToAdd);
            addNode(nodeToAdd);
        }
    }

    public int get(int key) {
        var result = -1;
        var existing = cache.get(key);
        if (existing != null) {
            logger.info(String.format("Key found for key %d", key));
            result = existing.value;
            removeNode(key, oldest);
            var nodeToAdd = new LRUNode(key,result);
            addNode(nodeToAdd);
        } else {
            logger.info(String.format("No key found for key %d", key));
        }
        return result;
    }


}
