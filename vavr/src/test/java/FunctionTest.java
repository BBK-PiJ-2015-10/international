import io.vavr.Function1;
import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert.*;

import java.util.function.BiFunction;
import java.util.function.Function;


public class FunctionTest {

    @Test
    public void simpleFunctionJava(){

        Function<Integer,Integer> square = (num) -> num * num;
        int result = square.apply(2);

        Assert.assertEquals(4, result);

    }

    @Test
    public void simplBiFunctionJava(){

        BiFunction<Integer,Integer,Integer> square = (num1,num2) -> num1 + num2;
        int result = square.apply(5,7);

        Assert.assertEquals(12, result);

    }

    @Test
    public void simpleFunctionWithVavr(){

        Function1<Integer,Integer> square = (num) -> num * num;
        int result = square.apply(2);

        Assert.assertEquals(4, result);
    }






}
