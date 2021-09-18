
import java.util.HashMap;
import java.util.Map;

public class CacheFreq {

    class CountedValue{

        public String value;

        public int timesAccessed;

        public CountedValue(String value, int timesAccessed) {
            this.value = value;
            this.timesAccessed = timesAccessed;
        }
    }

    private int limit;

    private Map<String,CountedValue> map = new HashMap<>(limit);

    public CacheFreq(int limit){
        this.limit = limit;
    }

    public String get(String key) {
        CountedValue countedValue = map.get(key);
        if (countedValue != null) {
            countedValue.timesAccessed = countedValue.timesAccessed + 1;
            return countedValue.value;
        }
        return null;
    }

    public void put(String key,String value){
        if (map.containsKey(key)){
            CountedValue countedValue = map.get(key);
            countedValue.value = value;
            countedValue.timesAccessed = countedValue.timesAccessed + 1;
        } else {
            CountedValue countedValue = new CountedValue(value,1);
            if (map.size()>=limit){
                String leastUsed = map.keySet()
                        .stream()
                        .min((e1,e2) -> map.get(e1).timesAccessed > map.get(e2).timesAccessed ? 1 : -1).get();
                map.remove(leastUsed);
                map.put(key,countedValue);
            } else {
                map.put(key,countedValue);
            }
        }
    }

    public String getLeastUsed(){
        return map.keySet()
                .stream()
                .min((e1,e2) -> map.get(e1).timesAccessed > map.get(e2).timesAccessed ? 1 : -1).get();
    }


}
