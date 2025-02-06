package palantir;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KthLargestOnArray {

    Logger logger = Logger.getLogger("KthLargestOnArray");

    public int getKthLargestViaPriorityQueue(int k, int[] array) {
        var result = -1;
        //Comparator<Integer> largestToSmallest = Comparator.comparing(i -> -i.compareTo(i));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        if (array.length < k) {
            return result;
        }
        for (Integer value : array) {
            logger.info(String.format("Adding to queue value %d", value));
            priorityQueue.add(value);
            if (priorityQueue.size() > k) {
                var removed = priorityQueue.poll();
                logger.info(String.format("Queue at capacity removing lower priority %d", removed));
            }
        }
        result = priorityQueue.poll();
        return result;
    }

    public int getKthLargestViaArrays(int k, int[] array) {
        var result = -1;
        if (array.length < k) {
            return result;
        }
        var listInput = Arrays.stream(array).boxed().collect(Collectors.toList());
        return getKthLargestViaArraysHelper(k, listInput);
    }

    private int getKthLargestViaArraysHelper(int k, List<Integer> input) {
        int pivotPosition = new Random().nextInt(input.size());
        Integer pivot = input.get(pivotPosition);
        List<Integer> lowerValuesArray = new LinkedList<>();
        List<Integer> higherValuesArray = new LinkedList<>();
        List<Integer> sameValueArray = new LinkedList<>();
        for (Integer value : input) {
            if (value > pivot) {
                higherValuesArray.add(value);
            } else if (value < pivot) {
                lowerValuesArray.add(value);
            } else {
                sameValueArray.add(value);
            }
        }
        if (higherValuesArray.size() > k) {
            return getKthLargestViaArraysHelper(k, higherValuesArray);
            // need to go to right
        } else if (higherValuesArray.size() + sameValueArray.size() < k) {
            var ktoFind = k - higherValuesArray.size() - sameValueArray.size();
            return getKthLargestViaArraysHelper(k, lowerValuesArray);
        }
        return pivot;
    }


}
