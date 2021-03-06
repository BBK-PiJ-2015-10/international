package oop;

import java.util.Objects;

public class Node<K,V> {

    private K key;

    private V value;

    private Node<K,V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
            "key=" + key +
            ", value=" + value +
            '}';
    }
}
