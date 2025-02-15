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

    private void addToExistings(List<List<Integer>> inputs, Integer right, HashMap<Integer, List<List<Integer>>> visitedSums) {
        inputs.forEach(input -> addToExisting(input, right, visitedSums));
    }

    private boolean matchesTarget(List<Integer> solution, int target) {
        if (solution.stream().reduce((a, b) -> a + b).get() == target) {
            return true;
        } else {
            return false;
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
            // Map of costs and list of items
            var iVisitedSum = new HashMap<Integer, List<List<Integer>>>();
            for (int k = sortedInput.size() - 1; k >= i; k--) {
                var left = sortedInput.get(i);
                var right = sortedInput.get(k);
                if (i == k) {
                    if (left == target) {
                        var iSolution = new LinkedList<Integer>();
                        iSolution.add(left);
                        solution.add(iSolution);
                    }
                } else {
                    var sum = left + right;
                    var diffToTarget = target - sum;
                    logger.info(String.format("Start comparing left %d on i %d versus right %d on k %d with diffTarget %d", left, i, right, k, diffToTarget));
                    // the sum matches target, just add to solution
                    if (diffToTarget == 0) {
                        var iSolution = new LinkedList<Integer>();
                        iSolution.add(left);
                        iSolution.add(right);
                        solution.add(iSolution);
                    } else {
                        // sum is less than target
                        if (diffToTarget > 0) {
                            var exitingSolution = iVisitedSum.get(diffToTarget);
                            logger.info(String.format("I am on left %d on i %d versus right %d on k %d with diffTarget %d", left, i, right, k, diffToTarget));
                            // remove from visitedSum, add left and right and add to isolution
                            if (exitingSolution != null) {
                                var removed = iVisitedSum.remove(diffToTarget);
                                removed.stream().map(as -> helperAdded(as, left, right))
                                        .forEach(d -> solution.add(d));
                            } else {
                                // update iVisitedSum, make copies and add
                                List<List<List<Integer>>> cloned = iVisitedSum.entrySet().stream()
                                        .filter(e -> e.getKey() < diffToTarget)
                                        .map(es -> new LinkedList<>(es.getValue()))
                                        .collect(Collectors.toList());
                                cloned.forEach(ec -> addToExistings(ec, right, iVisitedSum));
                                addToExisting(new LinkedList<>(), right, iVisitedSum);
                            }
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
        return deDuppingmAP.values().stream()
                .filter(s -> matchesTarget(s, target))
                .toList();
    }
}
