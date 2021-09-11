package oop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyHashTable<K,V> {

    private Logger logger = Logger.getLogger(MyHashTable.class.getName());

    private Node[] buckets;

    private int capacity = 5;

    public MyHashTable() {
        this.buckets = new Node[capacity];
    }

    public V get(K key){
        int bucket = Math.abs(key.hashCode()) % capacity;
        Node<K,V> current = buckets[bucket];
        if (current==null){
            logger.info("Did not find it");
            return null;
        }
        if (current.getKey().equals(key)){
            return current.getValue();
        }
        //Move to next node
        current = current.getNext();
        while (current!=null){
         if (current.getKey().equals(key)){
             return current.getValue();
         }
         current = current.getNext();
        }
        return null;
    }

    public V put(K key, V value){
        Node<K,V> node = new Node(key,value);
        int bucket  =   Math.abs(node.getKey().hashCode()) % capacity;
        Node<K,V> current = buckets[bucket];
        //Does not exist, then just put
        if (current==null){
            buckets[bucket] = node;
            logger.info(String.format("Placing node %s on bucket %S",node,bucket));
            return value;
        }
        //Already exists, just replace value
        if (current.getKey().equals(node.getKey())){
            current.setValue(value);
            logger.info(String.format("Updating node %s on bucket %S",node,bucket));
            return value;
        }

        Node<K,V> next = current.getNext();

        while(next!=null){
            // It is a replacement, just update
            if (next.getKey().equals(node.getKey())){
                next.setValue(value);
                return value;
            } /* keep going */
                else {
                //there is no next, set node as next
                current = next;
                next = next.getNext();
            }
        }

        current.setNext(node);
        return value;
    }






}
