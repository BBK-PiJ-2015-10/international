package jpmorgan;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSum {

    private Logger logger = Logger.getLogger("CombinationSum");


    private List<Integer> helperAdded(List<Integer> input, Integer left, Integer right) {
        input.add(left);
        input.add(right);
        return input;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solution = new LinkedList<>();
        var sortedInput = Arrays.stream(candidates)
                .boxed()
                .filter(n -> n < target)
                .sorted()
                .collect(Collectors.toList());
        for (int i = 0; i < sortedInput.size(); i++) {
            var iVisitedSum = new HashMap<Integer, List<List<Integer>>>();
            for (int k = sortedInput.size() - 1; k > i; k--) {
                var left = sortedInput.get(i);
                var right = sortedInput.get(k);
                var sum = left + right;
                var diffToTarget = target - sum;
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
                                    iVisitedSum.get(existingSum).forEach(el -> el.add(right));
                                }
                            }
                        }
                    }
                }
                logger.info(String.format("Done Comparing pos %d value %d ver pos %d value %d", i, left, k, right));
            }
        }
        return null;
    }
}
