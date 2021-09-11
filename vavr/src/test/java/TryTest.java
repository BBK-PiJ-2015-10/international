import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert.*;


//https://www.baeldung.com/vavr

public class TryTest {


    @Test
    public void test1(){

        Try<Integer> result = Try.of(() -> 1 / 0);
        Assert.assertTrue(result.isFailure());

        int errorSentinel = result.getOrElse(-1);

        Assert.assertEquals(-1,errorSentinel);

        result.getOrElseThrow(() -> new ArithmeticException());

    }



}
