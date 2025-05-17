package jerry;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class IntensityProcessorTest {

    @Test
    public void addTest1() {

        IntensityProcessor processor = new IntensityProcessor();

        var result = processor.add(10, 30, 1);
        var expectedResult = List.of(new Segment(10, 1), new Segment(30, 0));

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void addTest2() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        var result = processor.add(20, 40, 1);

        var expectedResult = List.of(new Segment(10, 1), new Segment(20, 2), new Segment(30, 1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void addTest3() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -2);

        var expectedResult = List.of(new Segment(10, -1), new Segment(20, 0), new Segment(30, -1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void addTest4() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -1);

        var expectedResult = List.of(new Segment(20, 1), new Segment(30, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void addTest5() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        processor.add(10, 40, -1);
        var result = processor.add(10, 40, -1);

        var expectedResult = List.of(new Segment(10, -1), new Segment(20, 0), new Segment(30, -1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void setTest1() {

        IntensityProcessor processor = new IntensityProcessor();

        var result = processor.set(10, 30, 1);
        var expectedResult = List.of(new Segment(10, 1), new Segment(30, 0));

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void setTest2() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.set(10, 30, 1);
        var result = processor.set(20, 40, 1);

        var expectedResult = List.of(new Segment(10, 1), new Segment(20, 1), new Segment(30, 1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void setTest3() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.set(10, 30, 1);
        processor.set(20, 40, 1);
        var result = processor.set(10, 40, -2);

        var expectedResult = List.of(new Segment(10, -2), new Segment(20, -2), new Segment(30, -2), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    // TODO: need to remove not needed
    @Test
    public void setTest4() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.set(10, 30, 1);
        processor.set(20, 40, 1);
        var result = processor.set(10, 40, -1);

        var expectedResult = List.of(new Segment(10, -1), new Segment(20, -1), new Segment(30, -1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    // TODO: need to remove not needed
    @Test
    public void setTest5() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.set(10, 30, 1);
        processor.set(20, 40, 1);
        processor.set(10, 40, -1);
        var result = processor.set(10, 40, -1);

        var expectedResult = List.of(new Segment(10, -1), new Segment(20, -1), new Segment(30, -1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void setTest6() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.set(10, 30, 1);
        processor.set(20, 40, 1);
        processor.set(10, 40, -1);
        var result1 = processor.set(10, 50, -2);
        System.out.println(result1);
        var result = processor.set(20, 40, 0);

        System.out.println(result);

        //var expectedResult = List.of(new Segment(10, -1), new Segment(20, -1), new Segment(30, -1), new Segment(40, 0));
        //Assert.assertEquals(expectedResult, result);

    }


}
