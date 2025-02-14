package jpmorgan;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSum {

    private Logger logger = Logger.getLogger("CombinationSum");

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solution = new LinkedList<>();
        var sortedInput = Arrays.stream(candidates)
                .boxed()
                .filter(n -> n < target)
                .sorted()
                .collect(Collectors.toList());
        for (int i=0;i<sortedInput.size();i++){
            //var iSolutions = new LinkedList<Integer>();
            var iVisitedPotential = new LinkedList<Integer>();
            for (int k=sortedInput.size()-1;k>i;k--){
                var left = sortedInput.get(i);
                var right = sortedInput.get(k);
                var sum = left + right;
                if (sum == target){
                    var iSolution = new LinkedList<Integer>();
                    iSolution.add(left);
                    iSolution.add(right);
                    solution.add(iSolution);
                    iVisitedPotential.clear();
                } else {
                    if (sum < target){
                        if (iVisitedPotential.isEmpty()==false){
                            var tail = iVisitedPotential.get(iVisitedPotential.size()-1);
                            var sumWithTail = sum + tail;
                            if (sumWithTail==target){
                                var iSolution = new LinkedList<Integer>();
                                iSolution.add(left);
                                iSolution.add(right);
                                iSolution.add(tail);
                                solution.add(iSolution);
                                iVisitedPotential.clear();
                            } else if (sumWithTail < target){
                                iVisitedPotential.add(right);
                            } else {
                                var removed = iVisitedPotential.removeLast();
                                iVisitedPotential.add(right);
                            }
                        }
                    }
                }
                logger.info(String.format("Comparing pos %d value %d ver pos %d value %d",i,left,k,right));
            }
        }
        return null;
    }
}
