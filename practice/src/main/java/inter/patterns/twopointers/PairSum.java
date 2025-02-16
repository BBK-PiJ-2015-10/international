package inter.patterns.twopointers;


import java.util.Optional;
import java.util.logging.Logger;

public class PairSum {

    private Logger logger = Logger.getLogger("PairSum");

    public record Pair(int leftIndex, int rightIndex) {
    }

    // The input is sorted
    public Optional<Pair> getAnyPairSum(int[] input, int target) {
        int leftIndex = 0;
        int rightIndex = input.length - 1;
        Optional<Pair> solution = Optional.empty();
        while (leftIndex < rightIndex && solution.isEmpty()) {
            int leftValue = input[leftIndex];
            int rightValue = input[rightIndex];
            Integer sum = leftValue + rightValue;
            int comparison = sum.compareTo(target);
            logger.info(String.format("Comparing leftIndex %d with value %d plus rightIndex %d with value %d with sum %d yield comparison %d ", leftIndex, leftValue, rightIndex, rightValue, sum, comparison));
            switch (comparison) {
                case 0 -> solution = Optional.of(new Pair(leftIndex, rightIndex));
                case 1 -> rightIndex--;
                default -> leftIndex++;
            }
        }
        return solution;
    }


}
