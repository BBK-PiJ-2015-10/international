package linkedlistmaps;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int maxSize;

    Map<Integer,Node> map;

    public LRUCache(int maxSize) {
        map = new HashMap<>(maxSize);
    }

    private Node head;

    private Node tail;

    public int getMostRecent(){
        return head.value;
    }

    public int getLeastUsed(){
        return tail.value;
    }

    private void addNode(Node node){
        node.next = head;
        node.prev = null;
        if (head!=null){
            head.prev = node;
        }
        head = node;
        if (tail == null){
            tail = node;
        }
    }

    private void removeNode(Node node){
        //update previous
        if (node.prev !=null){
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next !=null){
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public int getEntry(int key){
        Node node = map.get(key);
        if (node == null){
            return -1;
        } else {
            removeNode(node);
            addNode(node);
            return node.value;
        }
    }

    public void putEntry(int key, int value){
        Node node = map.get(key);
        if (node!=null){
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            Node newNode = new Node();
            newNode.key =  key;
            newNode.value = value;
            if (map.size()>=maxSize){
                removeNode(tail);
                addNode(newNode);
            } else {
                addNode(newNode);
            }
        }
    }

}
