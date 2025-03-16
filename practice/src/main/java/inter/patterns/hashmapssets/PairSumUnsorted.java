package inter.patterns.hashmapssets;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class PairSumUnsorted {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int[] findPairSum(int[] array, int target) {
        Map<Integer, Integer> valuesPositionMap = new HashMap<>();
        int[] solution = new int[2];
        solution[0] = -1;
        solution[1] = -1;
        for (int i = 0; i < array.length; i++) {
            var searchingFor = target - array[i];
            var foundIndex = valuesPositionMap.get(searchingFor);
            if (foundIndex != null) {
                solution[0] = i;
                solution[1] = foundIndex;
                logger.info(String.format("Found solution with index x %d, index y %d", i, foundIndex));
                return solution;
            }
            logger.info(String.format("Putting value %d with index %d", array[i], i));
            valuesPositionMap.put(array[i], i);
        }
        return solution;
    }

}
