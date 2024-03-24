package hashing;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;

public class ConsistentHashing<S, K> {

    private int replicas;
    private SortedMap<Integer, S> serverRing = new TreeMap<>();
    
    private Function<String, Integer> hashFunction;

    public ConsistentHashing(int replicas, Function<String, Integer> hashFunction, Collection<S> nodes) {
        this.replicas = replicas;
        this.hashFunction = hashFunction;
    }

    public void addServer(S server) {
        for (int i = 0; i < replicas; i++) {
            int hashKey = hashFunction.apply(server.toString() + i);
            serverRing.put(hashKey, server);
        }
    }

    public void removeServer(S server) {
        for (int i = 0; i < replicas; i++) {
            int hashKey = hashFunction.apply(server.toString() + i);
            serverRing.remove(hashKey);
        }
    }

    public S getServer(K key) {
        int hashKey = hashFunction.apply(key.toString());
        var server = serverRing.get(hashKey);
        if (server == null) {
            var potentialServers = serverRing.tailMap(hashKey);
            return potentialServers.isEmpty() ? serverRing.firstKey() : potentialServers.firstKey()
        } else {
            return server;
        }

        return null;
    }

}
