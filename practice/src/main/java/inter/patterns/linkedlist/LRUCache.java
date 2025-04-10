package inter.patterns.linkedlist;

import java.util.*;

public class LRUCache {

    private int capacity;

    private Map<Integer, Integer> cache;

    private LRUNode oldest = null;

    private LRUNode youngest = null;


    public class LRUNode {
        int key;
        public LRUNode(int key) {
            this.key = key;
        }
        LRUNode next;
        LRUNode previous;
    }

    private void removeNode(int key, LRUNode node) {
        if (node != null) {
            if (node.key == key) {
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
                removeNode(key, node.next);
            }
        }
    }

    private void addNode(LRUNode nodeToAdd) {
        if (oldest == null) {
            oldest = nodeToAdd;
        }
        if (youngest != null) {
            youngest.next = nodeToAdd;
            nodeToAdd.previous = youngest;
        }
        youngest = nodeToAdd;
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public void place(int key, int value) {
        var existing = cache.get(key);
        var nodeToAdd = new LRUNode(key);
        // exist => update, remove, and add
        if (existing != null) {
            cache.put(key, value);
            removeNode(key, oldest);
            addNode(nodeToAdd);
        } else {
            // at capacity, remove oldest, and add new
            if (capacity == cache.size()) {
                var oldestKeyToRemove = oldest.key;
                cache.remove(oldestKeyToRemove);
                var nextToOldest = oldest.next;
                if (nextToOldest != null) {
                    nextToOldest.previous = null;
                }
                oldest = oldest.next;
            }
            cache.put(key, value);
            addNode(nodeToAdd);
        }
    }

    public int get(int key) {
        var result = -1;
        var existing = cache.get(key);
        if (existing != null) {
            result = existing;
            removeNode(key, oldest);
            var nodeToAdd = new LRUNode(key);
            addNode(nodeToAdd);
        }
        return result;
    }


}
