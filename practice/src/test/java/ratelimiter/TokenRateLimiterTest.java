package ratelimiter;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

public class TokenRateLimiterTest {

    @Test
    public void test1(){

        var maxCapacity = 5;
        var windowUnitMillis = 1000;

        var bucketRateLimit = new TokenBucketRateLimiter(5,windowUnitMillis);

        for (int i = 0; i < 10; i++) {
            //bucketRateLimit.allowRequest();
            System.out.println(bucketRateLimit.allowRequest());
        }

    }


}
