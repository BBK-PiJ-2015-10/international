package ratelimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RateLimiter {

    private Duration period;

    private int requests;

    private List<Instant> requestTracker;

    private int pointer;

    public RateLimiter(Duration period, int requests) {
        this.period = period;
        this.requests = requests;
        initializeRequestTracker(period);
    }

    private void initializeRequestTracker(Duration period){
        Instant onPeriodAgo = Instant.now().minus(period);
        requestTracker = IntStream.range(0,requests)
            .boxed()
            .map(n -> onPeriodAgo)
            .collect(Collectors.toList());
        pointer = 0;
    }

    public <T> T call(Callable<T> func) throws Exception {
        Instant newTime = Instant.now();
        Instant expiredPriorTime  = requestTracker.get(pointer).plus(period);
        if (newTime.isAfter(expiredPriorTime)){
            enqueue(newTime);
            return func.call();
        } else {
            throw new RateLimitException();
        }
    }

    private void enqueue(Instant newTime){
        requestTracker.remove(pointer);
        requestTracker.add(pointer,newTime);
        pointer ++;
        if (pointer==requests){
            pointer = 0;
        }
    }

}
