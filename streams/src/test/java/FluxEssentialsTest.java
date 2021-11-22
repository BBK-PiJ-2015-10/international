import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;

import static org.awaitility.Awaitility.given;

public class FluxEssentialsTest {

    private final Random random = new Random();


    @Test
    public void createFlux() {

        Flux<String> stream1 = Flux.just("Hello", "world");

        StepVerifier
                .create(stream1)
                .assertNext(next ->
                        Assert.assertEquals("Hello", next)
                )
                .assertNext(next ->
                        Assert.assertEquals("world", next)
                )
                .expectComplete()
                .verify(Duration.ofMillis(500));

    }

    @Test
    public void simpleSubscribe() {


        Flux.just("A", "B", "C").subscribe
                (each -> System.out.println(each),
                        errorIgnores -> System.out.println("Ignoring this guy"),
                        () -> System.out.println("DONE"));


    }

    @Test
    public void simpleRange(){
        Flux.range(2010,9)
                .subscribe(y -> System.out.print(y + ","));

    }

    @Test
    public void broadCastingMerginFlux(){

        val numbers = Flux.fromIterable(List.of(1,2,3,4,5,6)).publish();

        val stream1 = numbers.filter(i -> i % 2 ==0).map(i -> i * 10);
        val stream2 =numbers.filter(i -> i % 2 !=0)
                .map(i -> i * 100);
        val stream3 =numbers.filter(i -> i > 5).map(i -> i * 1000);

        val mergeResult = Flux.merge(stream2,stream3);

        stream1.subscribe(value -> System.out.println("from stream1:"+value));
        //stream2.subscribe(value -> System.out.println("from stream2:"+value));
        mergeResult.subscribe(value -> System.out.println("from merged: "+value));

        numbers.connect();
        
    }

    @Test
    public void delayExample() throws Exception{

        val numbers = Flux.fromIterable(List.of(1,2,3,4,5,6)).publish();

        val stream1 = numbers.filter(i -> i % 2 ==0).map(i -> i * 10);
        val stream2 =numbers.filter(i -> i % 2 !=0)
                .map(i -> i * 100)
                .delayElements(Duration.ofMillis(300));
        val stream3 =numbers.filter(i -> i > 5).map(i -> i * 1000);


        val mergeResult = Flux.merge(stream2,stream3);

        stream1.subscribe(value -> System.out.println("from stream1:"+value));
        mergeResult.subscribe(value -> System.out.println("from merged: "+value));

        numbers.connect();

        org.awaitility.Duration waitingTime = org.awaitility.Duration.FIVE_SECONDS;

        given().await().with().pollDelay(waitingTime).and().until(() -> true);


    }


}
