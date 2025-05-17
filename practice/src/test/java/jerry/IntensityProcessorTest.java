package jerry;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class IntensityProcessorTest {

    @Test
    public void test1AddPositiveToEmptySegmentation() {

        IntensityProcessor processor = new IntensityProcessor();

        var result = processor.add(10, 30, 1);
        var expectedResult = List.of(new Segment(10, 1), new Segment(30, 0));

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test2AddPositiveAnOverlappingSegment() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        var result = processor.add(20, 40, 1);

        var expectedResult = List.of(new Segment(10, 1), new Segment(20, 2), new Segment(30, 1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test3AddNegativeMakingAContainedSegmentZero() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -2);

        var expectedResult = List.of(new Segment(10, -1), new Segment(20, 0), new Segment(30, -1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test4AddNegativeMakingEndSegmentZero() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -1);

        var expectedResult = List.of(new Segment(20, 1), new Segment(30, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test5AddNegativeOverlappingSegment() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        processor.add(10, 40, -1);
        var result = processor.add(10, 40, -1);

        var expectedResult = List.of(new Segment(10, -1), new Segment(20, 0), new Segment(30, -1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test6AddPositiveDisjointSegment() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(60, 90, 2);

        var expectedResult = List.of(new Segment(10, 1), new Segment(20, 2), new Segment(30, 1), new Segment(40, 0), new Segment(60, 2), new Segment(90, 0));
        Assert.assertEquals(expectedResult, result);

    }

    // These are the tests for set

    @Test
    public void test1SetPositiveToEmptySegmentation() {

        IntensityProcessor processor = new IntensityProcessor();

        var result = processor.set(10, 30, 1);
        var expectedResult = List.of(new Segment(10, 1), new Segment(30, 0));

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test2SetPositiveAnOverlappingSegment() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.set(10, 30, 1);
        var result = processor.set(20, 40, 1);

        var expectedResult = List.of(new Segment(10, 1), new Segment(20, 1), new Segment(30, 1), new Segment(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test3SetNegativeAllSegments() {

        IntensityProcessor processor = new IntensityProcessor();

        processor.set(10, 30, 1);
        processor.set(20, 40, 1);
        var result = processor.set(10, 40, -2);

        var expectedResult = List.of(new Segment(10, -2), new Segment(20, -2), new Segment(30, -2), new Segment(40, 0));
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
