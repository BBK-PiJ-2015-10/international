package inter.patterns.twopointers;


import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TipletSum {

    Logger logger = Logger.getLogger("TipleSum");

    public List<List<Integer>> findAllTripletSumToZero(int[] input) {
        List<Integer> sortedInput = Arrays.stream(input).boxed().sorted().collect(Collectors.toList());
        logger.info(String.format("Sorted array is %s", sortedInput));
        Set<List<Integer>> solutions = new HashSet<>();
        for (int i = 0; i < sortedInput.size(); i++) {
            var target = -sortedInput.get(i);
            var solutionPair = getAnyPairSum(sortedInput, target,i+1);
            //logger.info(String.format("i is %d Target is %d solution is %s",i,target,solutionPair));
            if (solutionPair.isPresent()) {
                var leftValue = solutionPair.get().leftValue;
                var rightValue = solutionPair.get().rightValue;
                var solution = Stream.of(leftValue, rightValue, -target).sorted().collect(Collectors.toList());
                logger.info(String.format("Found a solution on %s with i %d with target %d", solution, i, target));
                solutions.add(solution);
            }
        }
        return solutions.stream().toList();
    }

    public record PairValue(int leftValue, int rightValue) {
    }

    public Optional<PairValue> getAnyPairSum(List<Integer> input, int target,int left) {
        int leftIndex = left;
        int rightIndex = input.size() - 1;
        Optional<PairValue> solution = Optional.empty();
        while (leftIndex < rightIndex && solution.isEmpty()) {
            int leftValue = input.get(leftIndex);
            int rightValue = input.get(rightIndex);
            Integer sum = leftValue + rightValue;
            int comparison = sum.compareTo(target);
            //logger.info(String.format("Comparing leftIndex %d with value %d plus rightIndex %d with value %d with sum %d yield comparison %d ", leftIndex, leftValue, rightIndex, rightValue, sum, comparison));
            switch (comparison) {
                case 0 -> solution = Optional.of(new PairValue(leftValue, rightValue));
                case 1 -> rightIndex--;
                default -> leftIndex++;
            }
        }
        return solution;
    }

    public List<List<Integer>> findAllTripletSumToZeroBrutal(int[] input) {
        Set<List<Integer>> solutions = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int k = i + 1; k < input.length; k++) {
                for (int l = k + 1; l < input.length; l++) {
                    logger.info(String.format("Visiting i %d with and k %d and l %d", i, k, l));
                    int sum = input[i] + input[k] + input[l];
                    if (sum == 0) {
                        var solution = Stream.of(input[i], input[k], input[l]).sorted().collect(Collectors.toList());
                        solutions.add(solution);
                    }
                }
            }
        }
        return solutions.stream().toList();
    }


}
