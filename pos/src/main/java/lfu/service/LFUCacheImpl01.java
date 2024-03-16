package lfu.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class LFUCacheImpl01 implements LFUCache {


    private int maxCapacity;

    private Integer minFrequency;

    private Map<Integer, Integer> keysToValues = new HashMap<>();
    private Map<Integer, Integer> keysToFrequency = new HashMap<>();

    private Map<Integer, LinkedList<Integer>> freqToLRUKeys = new HashMap<>();

    public LFUCacheImpl01(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public int get(int key) {

//        MyNode existingNode = cache.get(key);
//        if (existingNode == null) {
//            return -1;
//        } else {
//            existingNode.setLastestTimeSamp(LocalDateTime.now());
//            existingNode.setRequests(existingNode.requests + 1);
//            return existingNode.value;
//        }
    }

    @Override
    public void put(int key, int value) {
        Integer existingValue = keysToValues.get(key);
        int frequency = 1;
        if (existingValue == null) {
            // THIS ITEM IS NEW
            if (keysToValues.size() >= maxCapacity) {
                // THERE IS NO SPACE, NEED TO EVICT
                // Evicting key
                var keyToEvict = freqToLRUKeys.get(minFrequency).removeFirst();
                keysToFrequency.remove(keyToEvict);
                keysToValues.remove(keyToEvict);
            }

            // adding key
            keysToValues.put(key, value);
            keysToFrequency.put(key, frequency);
            var freqToLRUKeysList = freqToLRUKeys.get(frequency);
            if (freqToLRUKeysList == null) {
                LinkedList<Integer> newList = new LinkedList();
                newList.add(key);
                freqToLRUKeys.put(key, newList);
            } else {
                freqToLRUKeysList.add(key);
            }

            if (minFrequency == null) {
                minFrequency = frequency;
            }

        } else {
            // update frequencies
            var existingFrequency = keysToFrequency.get(key);
            // remove from existing
            var otherKeysWithSameFrequency = freqToLRUKeys.get(existingFrequency);
            otherKeysWithSameFrequency.remove(key);
            // update frequencies
            var updatedFrequency = existingFrequency + 1;
            keysToFrequency.put(key, updatedFrequency);
            var freqToLRUKeysList = freqToLRUKeys.get(updatedFrequency);
            if (freqToLRUKeysList == null) {
                LinkedList<Integer> newList = new LinkedList();
                newList.add(key);
                freqToLRUKeys.put(key, newList);
            } else {
                freqToLRUKeysList.add(key);
            }

            if (minFrequency == null) {
                minFrequency = frequency;
            }

            if (minFrequency == existingFrequency) {
                if (otherKeysWithSameFrequency.isEmpty()) {
                    minFrequency = updatedFrequency;
                }
            }

        }


    }


}
