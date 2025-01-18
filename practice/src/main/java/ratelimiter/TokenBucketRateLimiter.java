package ratelimiter;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class TokenBucketRateLimiter {

    private int maxCapacity;

    private long lastRefillTime;

    private long windowUnitMillis;

    private AtomicLong tokens = new AtomicLong(0);

    private Logger logger = Logger.getLogger(TokenBucketRateLimiter.class.getName());

    public TokenBucketRateLimiter(int maxCapacity, int windowUnitMillis) {
        this.maxCapacity = maxCapacity;
        this.lastRefillTime = System.currentTimeMillis();
        this.windowUnitMillis = windowUnitMillis;
        tokens.set(maxCapacity);
    }

    public boolean allowRequest() {
        long currentRequestTimeStamp = System.currentTimeMillis();
        var timeElapsedMillis = currentRequestTimeStamp - lastRefillTime;
        boolean needToRefill = (timeElapsedMillis / windowUnitMillis) > 0;
        logger.info(String.format("Evaluating request current %2d timeElapsed %2d needToRefill %s",currentRequestTimeStamp,timeElapsedMillis,needToRefill));
        if (needToRefill) {
            tokens.set(maxCapacity);
            logger.info(String.format("Refilled tokens to max capacity: %s",maxCapacity));
        }
        var existingTokens = tokens.decrementAndGet();
        if (existingTokens < 0) {
            logger.warning(String.format("Request denied due to lack of tokens at %s",existingTokens));
            return false;
        } else {
            logger.info(String.format("Request allowed with %s tokens remaining",existingTokens));
            return true;
        }
    }


}
