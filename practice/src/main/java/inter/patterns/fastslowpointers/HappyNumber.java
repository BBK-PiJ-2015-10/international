package inter.patterns.fastslowpointers;

import java.util.logging.Logger;

public class HappyNumber {

    private Logger logger = Logger.getLogger(HappyNumber.class.getName());

    public boolean isHappyNumber(int number) {
        Integer fastResult = number;
        Integer slowResult = number;
        while (true) {
            slowResult = nextNumber(slowResult);
            fastResult = nextNumber(nextNumber(fastResult));
            if (slowResult == fastResult) {
                logger.info("Match slow and fast");
                return false;
            }
            if (fastResult == 1) {
                logger.info("Fast did it");
                return true;
            }
        }
    }

    public int nextNumber(int number) {
        return nextNumberHelper(number, 0);
    }

    private int nextNumberHelper(int number, int cumulative) {
        var lastDigit = number % 10;
        int multiplication = lastDigit * lastDigit;
        int root = number / 10;
        logger.info(String.format("Number is %s, lastDigit is %s, multi is %s, residual is %s", number, lastDigit, multiplication, root));
        if (root > 0) {
            //logger.info(String.format("HERE 1 Residual is %d", residual));
            return nextNumberHelper(root, cumulative + multiplication);
        } else {
            //logger.info(String.format("HERE 2 Residual is %d", residual));
            return cumulative + multiplication;
        }
    }

}
