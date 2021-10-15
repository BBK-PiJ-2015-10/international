package ratelimiter;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RateLimiterTest {

    @Test
    public void test1(){

        Duration duration = Duration.ofDays(1);

        Instant before = Instant.now();

        Instant yesterday = before.minus(duration);

        System.out.println(before);
        System.out.println(yesterday);



    }

    @Test
    public void test2(){

        List<String> names = Stream.of("yasser","alexander").collect(Collectors.toList());



        names.remove(0);
        names.add(0,"baltimora");

        String result  = names.get(0);
        int size = names.size();

        System.out.println(result);
        System.out.println(size);


        //names.


    }

}
