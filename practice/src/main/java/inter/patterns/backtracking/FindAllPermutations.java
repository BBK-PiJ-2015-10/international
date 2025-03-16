package inter.patterns.backtracking;

import java.util.*;
import java.util.logging.Logger;

public class FindAllPermutations {

    private Logger logger = Logger.getLogger(FindAllPermutations.class.getName());

    public List<List<Integer>> findAllPermutations(List<Integer> input) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> candidates = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        findAllPermutations(input, candidates, visited, results);
        return results;
    }

    private void findAllPermutations(List<Integer> input, List<Integer> ongoingSolution, Set<Integer> visited, List<List<Integer>> solutions) {
        if (ongoingSolution.size() == input.size()) {
            var candidateLog = Arrays.toString(ongoingSolution.toArray());
            logger.info(String.format("Adding to solution %s", candidateLog));
            solutions.add(ongoingSolution);
        }
        for (int i = 0; i < input.size(); i++) {
            var node = input.get(i);
            //logger.info();
            if (!visited.contains(node)) {
                ongoingSolution.add(node);
                visited.add(node);
                findAllPermutations(input, ongoingSolution, visited, solutions);
                ongoingSolution.remove(node);
                visited.remove(node);
            }
        }
    }

}
