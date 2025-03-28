package inter.patterns.stacks;

import java.util.Stack;
import java.util.logging.Logger;

public class NextLargestNumberToTheRight {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int[] calculate(int[] input) {
        Stack<Integer> ongoingHigherToTheRight = new Stack<>();
        int[] result = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            var currentValue = input[i];
            logger.info(String.format("Evaluating value %d at position %d", currentValue, i));
            if (i == input.length - 1) {
                logger.info(String.format("Updated result with %d at position %d", -1, i));
                result[input.length - 1] = -1;
            } else {
                while (!ongoingHigherToTheRight.isEmpty() && ongoingHigherToTheRight.peek() <= currentValue) {
                    ongoingHigherToTheRight.pop();
                }
                if (ongoingHigherToTheRight.isEmpty()) {
                    result[i] = -1;
                    logger.info(String.format("Updated result with %d at position %d", -1, i));
                } else {
                    result[i] = ongoingHigherToTheRight.peek();
                    logger.info(String.format("Updated result with %d at position %d", ongoingHigherToTheRight.peek(), i));
                }
            }
            ongoingHigherToTheRight.push(currentValue);
        }
        return result;
    }


}
