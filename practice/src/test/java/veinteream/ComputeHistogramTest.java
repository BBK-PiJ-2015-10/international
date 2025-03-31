package veinteream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ComputeHistogramTest {

    private ComputeHistogram histogramComputer = new ComputeHistogram();

    @Test
    public void test1(){

        var input = List.of(1,3,1,5);

        var result = histogramComputer.computeHistogram(input);

        result.forEach(System.out::println);


        Assert.assertEquals(true,true);
    }

}
