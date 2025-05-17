package jerry;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class IntensityProcessorTest {

    @Test
    public void test1() {

        IntensityProcessor processor = new IntensityProcessor();

        var result = processor.add(10, 30, 1);

        var expectedResult = List.of(new Segment(10, 1), new Segment(30, 0));

        System.out.println(result);


        Assert.assertEquals(expectedResult, result);


    }
}
