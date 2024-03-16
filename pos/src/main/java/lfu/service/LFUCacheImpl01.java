package lfu.service;

import java.util.*;

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
        Integer existingValue = keysToValues.get(key);
        if (existingValue == null) {
            return -1;
        } else {
            int existingFrequency = keysToFrequency.get(key);
            int updatedFrequency = existingFrequency + 1;
            keysToFrequency.put(key, updatedFrequency);
            // remove and update
            var existingFrequencyList = freqToLRUKeys.get(existingFrequency);
            existingFrequencyList.removeFirstOccurrence(key);
            var freqList = freqToLRUKeys.get(updatedFrequency);
            if (freqList == null) {
                var createdList = new LinkedList<Integer>();
                createdList.add(key);
                freqToLRUKeys.put(updatedFrequency, createdList);
            } else {
                freqList.add(key);
            }
            if (minFrequency == existingFrequency) {
                if (existingFrequencyList.isEmpty()){
                    minFrequency = updatedFrequency;
                }
            }



            return existingValue;
        }
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
                System.out.println(String.format("min is %d , key is %d, value is %d ", minFrequency,key,value));
                var keyToEvict = freqToLRUKeys.get(minFrequency).removeFirst();
                System.out.println(String.format("Removed %d ",keyToEvict));
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
                freqToLRUKeys.put(frequency, newList);
            } else {
                freqToLRUKeysList.add(key);
            }

            if (minFrequency == null) {
                minFrequency = frequency;
            }
            if (minFrequency > frequency){
                minFrequency = frequency;
            }
            System.out.println(String.format("HERE 1 Minimum frequency iS %d ", minFrequency));

        } else {
            // update frequencies
            var existingFrequency = keysToFrequency.get(key);
            // remove from existing
            var otherKeysWithSameFrequency = freqToLRUKeys.get(existingFrequency);
            otherKeysWithSameFrequency.removeFirstOccurrence(key);
            // update frequencies
            var updatedFrequency = existingFrequency + 1;
            keysToFrequency.put(key, updatedFrequency);
            var freqToLRUKeysList = freqToLRUKeys.get(updatedFrequency);
            if (freqToLRUKeysList == null) {
                LinkedList<Integer> newList = new LinkedList();
                newList.add(key);
                freqToLRUKeys.put(updatedFrequency, newList);
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
