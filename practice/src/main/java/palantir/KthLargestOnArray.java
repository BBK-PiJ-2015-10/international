package palantir;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Logger;

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


}
