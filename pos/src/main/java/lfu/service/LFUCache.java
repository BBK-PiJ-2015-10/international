package lfu.service;

import java.util.Optional;

public interface LFUCache {

    Optional<String> get(int key);

    void put(int key, String value);


}
