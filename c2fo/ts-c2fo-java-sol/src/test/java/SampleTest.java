import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;

public class SampleTest {

    @Test
    public void sampleTest() {
        Assert.assertEquals(3, 3);
    }


    @Test
    public void sampleTestMono() {

        val mono = Mono.just("alexis");

        StepVerifier
                .create(mono)
                .assertNext(result -> {
                    Assert.assertEquals("alexis", result);
                })
                .expectComplete()
                .verify(Duration.ofMillis(400));

    }


    @Test
    public void sampleTestFlux() {

        val flux = Flux.fromIterable(List.of("alexis", "balti"));

        StepVerifier
                .create(flux)
                .assertNext(result -> {
                    Assert.assertEquals("alexis", result);
                })
                .assertNext(result -> {
                    Assert.assertEquals("balti", result);
                })
                .expectComplete()
                .verify(Duration.ofMillis(400));

    }

}
