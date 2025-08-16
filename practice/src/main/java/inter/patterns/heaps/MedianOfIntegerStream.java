package inter.patterns.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Logger;

public class MedianOfIntegerStream {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Queue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> right = new PriorityQueue<>();

    public void add(int valueToAdd) {
        if (left.isEmpty()) {
            left.add(valueToAdd);
        } else {
            var leftHead = left.peek();
            if (valueToAdd <= leftHead) {
                logger.info(String.format("Adding element %d to the left", valueToAdd));
                left.add(valueToAdd);
            } else {
                logger.info(String.format("Adding element %d to the right", valueToAdd));
                right.add(valueToAdd);
            }
            // evaluate need to rebalance
            if (!(left.size() == right.size())) {
                logger.info(String.format("Left size %d is different than right %d", left.size(), right.size()));
                if (left.size() - right.size() > 1) {
                    logger.info(String.format("Need to move 1 from left %d to right %d", left.size(), right.size()));
                    var elementToMove = left.poll();
                    right.add(elementToMove);
                } else if (right.size() - left.size() > 0) {
                    logger.info(String.format("Need to move 1 from right %d to left %d", right.size(), left.size()));
                    var elementToMove = right.poll();
                    left.add(elementToMove);
                } else {
                    logger.info(String.format("No need to rebalance left %d is and right is %d", left.size(), right.size()));
                }
            } else {
                logger.info(String.format("No need to rebalance sides are equal left %d is and right is %d", left.size(), right.size()));
            }
        }
    }

    public double getMedian() {
        if ((left.size() + right.size()) % 2 == 0) {
            double leftHead = left.peek();
            double rightHead = right.peek();
            double median = (leftHead + rightHead) / 2;
            return median;
        } else {
            return left.peek();
        }
    }

}
