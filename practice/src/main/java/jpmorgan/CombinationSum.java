package jpmorgan;


import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSum {

    private Logger logger = Logger.getLogger("CombinationSum");


    private List<Integer> helperAdded(List<Integer> input, Integer left, Integer right) {
        input.add(left);
        input.add(right);
        return input;
    }

    private void addToExisting(List<Integer> input, Integer right, HashMap<Integer, List<List<Integer>>> visitedSums) {
        input.add(right);
        Integer cum = input.stream().reduce((a, b) -> a + b).get();
        List<List<Integer>> existing = visitedSums.get(cum);
        if (existing == null) {
            List<List<Integer>> newExisting = new LinkedList<>();
            newExisting.add(input);
            visitedSums.put(cum, newExisting);
        } else {
            existing.add(input);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solution = new LinkedList<>();
        var sortedInput = Arrays.stream(candidates)
                .boxed()
                .filter(n -> n <= target)
                .sorted()
                .collect(Collectors.toList());
        for (int i = 0; i < sortedInput.size(); i++) {
            var iVisitedSum = new HashMap<Integer, List<List<Integer>>>();
            for (int k = sortedInput.size() - 1; k >= i; k--) {
                var left = sortedInput.get(i);
                var right = sortedInput.get(k);
                var sum = left + right;
                var diffToTarget = target - sum;
                logger.info(String.format("Done Comparing left %d on i %d versus right %d on k %d with diffTarget %d", left,i, right,k, diffToTarget));
                if (left == target){
                    var iSolution = new LinkedList<Integer>();
                    iSolution.add(left);
                    solution.add(iSolution);
                }
                if (diffToTarget == 0) {
                    var iSolution = new LinkedList<Integer>();
                    iSolution.add(left);
                    iSolution.add(right);
                    solution.add(iSolution);
                } else {
                    if (diffToTarget > 0) {
                        var exitingSolution = iVisitedSum.get(diffToTarget);
                        if (exitingSolution != null) {
                            iVisitedSum.remove(diffToTarget).stream().map(as -> helperAdded(as, left, right))
                                    .forEach(d -> solution.add(d));
                        } else {
                            var existingSums = iVisitedSum.keySet();
                            for (Integer existingSum : existingSums) {
                                if (existingSum < diffToTarget) {
                                    var existingCloned = iVisitedSum.get(existingSum).stream()
                                            .collect(Collectors.toList());
                                    existingCloned.forEach(ec ->
                                            addToExisting(ec, right, iVisitedSum)
                                    );
                                }
                            }
                            addToExisting(new LinkedList<>(), right, iVisitedSum);
                        }
                    }
                }
            }
        }
        Map<String, List<Integer>> deDuppingmAP = new HashMap<>();
        solution.forEach(l -> {
            String key = l.stream().map(e -> e.toString()).collect(Collectors.joining());
            l.sort(Integer::compare);
            deDuppingmAP.put(key, l);
        });
        return deDuppingmAP.values().stream().toList();
    }
}
