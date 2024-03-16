package lfu.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LFUCacheImpl implements LFUCache {

    private Map<Integer, MyNode> cache = new HashMap<>();

    private int maxCapacity;

    private int minUsed = 1;

    public LFUCacheImpl(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public Optional<String> get(int key) {
        MyNode existingNode = cache.get(key);
        if (existingNode == null) {
            return Optional.empty();
        } else {
            existingNode.setLastestTimeSamp(LocalDateTime.now());
            existingNode.setRequests(existingNode.requests + 1);
            return Optional.of(existingNode.value);
        }
    }

    @Override
    public void put(int key, String value) {
        MyNode existingNode = cache.get(key);
        if (existingNode == null) {
            var node = new MyNode(key, value, 1, LocalDateTime.now());
            if (cache.size() >= maxCapacity) {
                var values = cache.values().stream().collect(Collectors.toList());
                Collections.sort(
                        values, Comparator.comparing(MyNode::getRequests));
                var minRequests = values.get(0).requests;
                var oldestNode = values.stream().filter(n -> n.requests <= minRequests)
                        .min(Comparator.comparing(MyNode::getLastestTimeStamp));
                cache.remove(oldestNode.get().key);
            }
            cache.put(key, node);
        } else {
            // just fetch and update
            existingNode.setLastestTimeSamp(LocalDateTime.now());
            existingNode.setRequests(existingNode.requests + 1);
        }
    }

    private int compareByFrequency(MyNode node1, MyNode node2) {
        return node1.requests.compareTo(node2.requests);
    }


    class MyNode {

        Integer key;
        String value;
        Integer requests;
        LocalDateTime lastestTimeStamp;

        public MyNode(Integer key, String value, int requests, LocalDateTime lastestTimeSamp) {
            this.key = key;
            this.value = value;
            this.requests = requests;
            this.lastestTimeStamp = lastestTimeSamp;
        }

        public void setRequests(int requests) {
            this.requests = requests;
        }

        public void setLastestTimeSamp(LocalDateTime lastestTimeSamp) {
            this.lastestTimeStamp = lastestTimeSamp;
        }

        public Integer getRequests() {
            return requests;
        }

        public LocalDateTime getLastestTimeStamp() {
            return lastestTimeStamp;
        }

        public Integer getKey() {
            return key;
        }
    }


}
