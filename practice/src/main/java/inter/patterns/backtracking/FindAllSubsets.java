package inter.patterns.backtracking;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class FindAllSubsets {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public List<List<Integer>> findAllSubsets(int[] array) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> empty = new LinkedList<>();
        result.add(empty);
        for (int i = 0; i < array.length; i++) {
            var valueToAdd = array[i];
            List<List<Integer>> newSubsetsToAdd = new LinkedList<>();
            for (int k = 0; k < result.size(); k++) {
                List<Integer> newSubset = new LinkedList<>(result.get(k));
                newSubset.add(valueToAdd);
                newSubsetsToAdd.add(newSubset);
            }
            result.addAll(newSubsetsToAdd);
        }
        return result;
    }
}
