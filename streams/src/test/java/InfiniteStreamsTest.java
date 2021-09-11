import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreamsTest {

    @Test
    public void generateTest(){

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }

    @Test
    public void generateIterate(){

        List<Integer> list = Stream.iterate(2, i -> i *2)
            .limit(5)
            .collect(Collectors.toList());

        Assert.assertEquals(list, Arrays.asList(2,4,8,16,32));

    }

    @Test
    public void takeWhile() {
        Stream.iterate(1, i -> i + 1)
                .takeWhile(n -> n <= 10)
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhile(){
        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .dropWhile(x -> x < 5)
                .forEach(System.out::println);

    }

    @Test
    public void iterateWithStopCondition(){
        Stream.iterate(1,i -> i < 256,i -> i *2)
                .forEach(System.out::println);

    }

    @Test
    public void ofNullableTest(){

        Integer number = null;

        Stream.ofNullable(number)
            .map(x -> x * x)
            .forEach(System.out::println);
        ;


    }













}
