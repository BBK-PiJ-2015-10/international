package inter.patterns;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Practice {

    private Logger logger = Logger.getLogger(this.getClass().getName());


    public List<List<Integer>> findTripletSum(int[] array) {
        Set<List<Integer>> result = new HashSet<>();
        var sortedArray = Arrays.stream(array).sorted().boxed().toList();
        for (int i = 0; i < sortedArray.size(); i++) {
            var target = -sortedArray.get(i);
            findPairSumSorted(sortedArray, i + 1, sortedArray.size() - 1, target, result);
        }
        return result.stream().toList();
    }

    private void findPairSumSorted(List<Integer> sortedList, int i, int k, int target, Set<List<Integer>> solutions) {
        int left = i;
        int right = k;
        logger.info(String.format("Evaluating left: %d right: %d target: %d", left, right, target));
        while (left < right) {
            int leftValue = sortedList.get(left);
            int rightValue = sortedList.get(right);
            int sum = leftValue + rightValue;
            logger.info(String.format("Evaluating left: %d right: %d target: %d sum: %d", left, right, target, sum));
            if (sum == target) {
                solutions.add(Stream.of(-target, leftValue, rightValue).sorted().toList());
                left++;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }


//    private int largestSubArraySum(int[] array){
//        int i =0, k=0;
//        int existingLargest = Integer.MIN_VALUE;
//        while (i<=k){
//            int evaluated = array[]
//        }
//    }


}
