package arraysstrings;

import java.util.Map;
import java.util.TreeMap;

public class ReplacementRanks {

    public int[] replaceWithRanks(int[] values) {
        Map<Integer, Integer> valuesPositions = new TreeMap<>();
        for (int i = 0; i < values.length; i++) {
            Integer value = values[i];
            valuesPositions.put(value, i);
        }
        int[] result = new int[values.length];
        int rank = 1;
        for (Integer value : valuesPositions.keySet()) {
            Integer position = valuesPositions.get(value);
            result[position] = rank;
            rank++;
        }
        return result;
    }

}
