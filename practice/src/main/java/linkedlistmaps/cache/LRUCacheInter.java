package linkedlistmaps.cache;

import java.util.Optional;

public interface LRUCacheInter {

    void put  (String key, Integer value);

    Optional<Integer> get(String key);

}
