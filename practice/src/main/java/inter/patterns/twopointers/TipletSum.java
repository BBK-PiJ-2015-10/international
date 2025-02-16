package inter.patterns.twopointers;


import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TipletSum {

    private Logger logger = Logger.getLogger("TipleSum");

    private List<Integer> toList(PairValue pairValue, int target) {
        return Stream.of(pairValue.leftValue, pairValue.rightValue, target).sorted().collect(Collectors.toList());
    }

    public List<List<Integer>> findAllTripletSumToZero(int[] input) {
        List<Integer> sortedInput = Arrays.stream(input).boxed().sorted().collect(Collectors.toList());
        logger.info(String.format("Sorted array is %s", sortedInput));
        Set<List<Integer>> solutions = new HashSet<>();
        for (int i = 0; i < sortedInput.size(); i++) {
            var target = -sortedInput.get(i);
            List<PairValue> solutionsPair = getAllPairSum(sortedInput, target, i + 1);
            logger.info(String.format("i is %d Target is %d solution is %s", i, target, solutionsPair));
            if (solutionsPair.size() != 0) {
                solutionsPair.forEach(s ->
                        solutions.add(toList(s, -target))
                );
            }
        }
        return solutions.stream().toList();
    }

    public record PairValue(int leftValue, int rightValue) {
    }

    public List<PairValue> getAllPairSum(List<Integer> input, int target, int left) {
        int leftIndex = left;
        int rightIndex = input.size() - 1;
        List<PairValue> solutions = new LinkedList<>();
        while (leftIndex < rightIndex) {
            int leftValue = input.get(leftIndex);
            int rightValue = input.get(rightIndex);
            Integer sum = leftValue + rightValue;
            int comparison = sum.compareTo(target);
            ;
            switch (comparison) {
                case 0 -> {
                    solutions.add(new PairValue(leftValue, rightValue));
                    leftIndex++;
                }
                case 1 -> rightIndex--;
                default -> leftIndex++;
            }
        }
        return solutions;
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
