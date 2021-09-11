import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cache {

    private int limit;

    private List<String> keyHistory = new LinkedList<>();

    private Map<String,String> map = new HashMap<>(limit);

    public Cache(int limit) { this.limit = limit; }

    public String get(String key){
        //update access history
        keyHistory.remove(key);
        keyHistory.add(key);
        //return value
        return map.get(key);
    }

    /*
     By reading the statement "Oldest is defined as: The least used item in the cache" , I thought the oldest
     was the least accessed item. However, based on conversation during interview, it seems that it is meant to be
     the item that has been not been updated or get the longest amount of time. Hence, my solution on the oldest uses
     this assumption.
     */
    public String getOldest(){
        if (keyHistory.isEmpty()){
            return null;
        }
         return keyHistory.get(0);
    }

    public String getYoungest(){
        if (keyHistory.isEmpty()){
            return null;
        }
        return keyHistory.get(keyHistory.size()-1);
    }

    public void put(String key, String value){
        if (map.containsKey(key)){
            keyHistory.remove(key);
        } else {
            if (map.size()>=limit){
                String oldest = keyHistory.remove(0);
                map.remove(oldest);
            }
        }
        keyHistory.add(key);
        map.put(key,value);
    }

}
