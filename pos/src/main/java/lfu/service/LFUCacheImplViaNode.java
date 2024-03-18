package lfu.service;

import java.util.HashMap;

public class LFUCacheImplViaNode implements LFUCache {

    private Node head;

    private Node tail;

    private int maxCapacity;

    private HashMap<Integer,Node> keysToNodes = new HashMap<>();

    public LFUCacheImplViaNode(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public int get(int key) {
        var existingNode = keysToNodes.get(key);
        if (existingNode != null) {
            removeNode(existingNode);
            addNode(existingNode);
            return existingNode.value;
        } else {
            return -1;
        }
    }

    private void addNode(Node node){
        keysToNodes.put(node.key,node);
        if (head != null){
            node.setNext(head);
            head.setPrevious(node);
        }
        node.setPrevious(null);
        head = node;
        if (tail == null){
            tail = head;
        }
    }

    private void removeNode(Node node){
        keysToNodes.remove(node.key);
        if (node.previous!=null){
            node.previous.setNext(node.next);
        } else {
            head = node.next;
            // it was the head
        }
        if (node.next != null){
            node.next.previous = node.previous;
        } else {
            // it was the tail
            tail = node.previous;
        }
    }

    @Override
    public void put(int key, int value) {
        var existingNode = keysToNodes.get(key);
        if (existingNode != null){
            existingNode.setValue(value);
            removeNode(existingNode);
            addNode(existingNode);
        } else {
            var nodeToAdd = new Node(key,value);
            if (maxCapacity == keysToNodes.size()) {
                removeNode(tail);
            }
            addNode(nodeToAdd);
        }
    }

    class Node{
        private int key;
        private int value;
        private Node next;
        private Node previous;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }
    }

}
