package inter.patterns.greedy;

import java.util.logging.Logger;

public class JumpToTheEnd {

    private Logger logger = Logger.getLogger(JumpToTheEnd.class.getName());

    public boolean canJumpToTheEnd(int[] nums) {
        var destinationPosition = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            var positionValue = nums[i];
            var positionPlusValue = i + positionValue;
            logger.info(String.format("Evaluating position %d , with value %d, currentDestination %d", i, positionValue, destinationPosition));
            if (positionPlusValue >= destinationPosition) {
                destinationPosition = i;
                logger.info(String.format("Updating destination to position %d", destinationPosition));
            }
        }
        return destinationPosition == 0;
    }

}
