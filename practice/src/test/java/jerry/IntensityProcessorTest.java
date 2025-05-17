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

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test2() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        var result = processor.add(20, 40, 1);

        var expectedResult = List.of(new Segment(10, 1), new Segment(20, 2), new Segment(30, 1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test3() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -2);

        var expectedResult = List.of(new Segment(10, -1), new Segment(20, 0), new Segment(30, -1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test4() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -1);
        //var result = processor.add(10, 40, -2);

        System.out.println(result);

        //var expectedResult = List.of(new Segment(10, -1), new Segment(20, 0), new Segment(30, -1), new Segment(40, 0));
        //Assert.assertEquals(expectedResult, result);

    }


}
