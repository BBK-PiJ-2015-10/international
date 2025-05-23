package jerry;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class IntensityProcessorTest {

    @Test
    public void test1AddPositiveToEmptySegmentation() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        var result = processor.add(10, 30, 1);
        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(30, 0));

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test2AddingAPositiveOverlappingSegment() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        var result = processor.add(20, 40, 1);

        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(20, 2), new SegmentPoint(30, 1), new SegmentPoint(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test3AddingANegativeAcrossAllSegmentsMakingInnerSegmentZero() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -2);

        var expectedResult = List.of(new SegmentPoint(10, -1), new SegmentPoint(20, 0), new SegmentPoint(30, -1), new SegmentPoint(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test4AddingNegativeEliminatingEndSegments() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        var result = processor.add(10, 40, -1);

        var expectedResult = List.of(new SegmentPoint(20, 1), new SegmentPoint(30, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test5AddNegativeOverlappingSegment() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        processor.add(20, 40, 1);
        processor.add(10, 40, -1);
        var result = processor.add(10, 40, -1);

        var expectedResult = List.of(new SegmentPoint(10, -1), new SegmentPoint(20, 0), new SegmentPoint(30, -1), new SegmentPoint(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test6AddPositiveDisjointSegment() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        var result = processor.add(60, 90, 2);

        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(30, 0), new SegmentPoint(60, 2), new SegmentPoint(90, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test7AddPositiveToDisjointSegments() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        processor.add(60, 90, 2);
        var result = processor.add(10, 100, 1);

        var expectedResult = List.of(new SegmentPoint(10, 2), new SegmentPoint(30, 1), new SegmentPoint(60, 3), new SegmentPoint(90, 1), new SegmentPoint(100, 0));
        Assert.assertEquals(expectedResult, result);

    }


    @Test
    public void test8AddNegativeToDisjointSegmentsEliminatingOneSegment() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 20, 1);
        processor.add(30, 40, 2);
        var result = processor.add(10, 20, -1);

        var expectedResult = List.of(new SegmentPoint(30, 2), new SegmentPoint(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test9AddNegativeUnitingDisjointSegments() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 20, 1);
        processor.add(40, 60, 1);
        var result = processor.add(10, 60, -1);

        var expectedResult = List.of(new SegmentPoint(20, -1), new SegmentPoint(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    // These are the tests for set

    @Test
    public void test1SetPositiveToEmptySegmentation() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        var result = processor.set(10, 30, 1);
        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(30, 0));

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test2SetPositiveAnOverlappingSegment() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.set(10, 30, 1);
        var result = processor.set(20, 40, 1);

        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(20, 1), new SegmentPoint(30, 1), new SegmentPoint(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test3SetNegativeAllSegments() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.set(10, 30, 1);
        processor.set(20, 40, 1);
        var result = processor.set(10, 40, -2);

        var expectedResult = List.of(new SegmentPoint(10, -2), new SegmentPoint(20, -2), new SegmentPoint(30, -2), new SegmentPoint(40, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test4SetPositiveDisjointSegment() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.set(10, 30, 1);
        var result = processor.set(60, 90, 2);

        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(30, 0), new SegmentPoint(60, 2), new SegmentPoint(90, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test6SetZeroOnExistingSegment() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        var result = processor.set(10, 30, 0);

        Assert.assertTrue(result.isEmpty());

    }

    @Test
    public void test7SetZeroOnExistingInnerSegments() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 40, 1);
        processor.add(30, 60, 1);

        var result = processor.set(30, 50, 0);
        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(30, 0));
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void test8SetZeroCoveringDisjointsSegments() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 40, 1);
        processor.add(60, 90, 1);

        var result = processor.set(10, 90, 0);
        Assert.assertTrue(result.isEmpty());

    }

    @Test
    public void test9SetZeroNonCoveringDisjointsSegments() {

        IntensityProcessor processor = new IntensityProcessorSortedMapImpl();

        processor.add(10, 30, 1);
        processor.add(70, 90, 1);
        var result = processor.set(40, 50, 0);

        var expectedResult = List.of(new SegmentPoint(10, 1), new SegmentPoint(30, 0), new SegmentPoint(70, 1), new SegmentPoint(90, 0));
        Assert.assertEquals(expectedResult, result);

    }


}
