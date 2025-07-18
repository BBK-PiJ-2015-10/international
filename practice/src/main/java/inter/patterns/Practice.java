package inter.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Practice {

    class Node {
        int key;
        int value;
        Node next;
        Node previus;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private Map<Integer, Node> mapKeysNodes;

    private Node leastRecentlyUsed;
    private Node mostRecentlyUsed;

    public Practice(int capacity) {
        this.capacity = capacity;
        mapKeysNodes = new HashMap<>(capacity);
    }

    public int get(int key) {
        var result = -1;
        Node existing = mapKeysNodes.get(key);
        if (existing != null) {
            result = existing.value;
            if (existing.previus != null) {
                existing.previus.next = mostRecentlyUsed;
            }
            if (existing.next != null) {
                existing.next.previus = mostRecentlyUsed;
            }
            mostRecentlyUsed.next = existing;
            existing.previus = mostRecentlyUsed;
            existing.next = null;
            mostRecentlyUsed = existing;
        }
        return result;
    }

    public void put(int key, int value) {

    }


    private Logger logger = Logger.getLogger(this.getClass().getName());


}
