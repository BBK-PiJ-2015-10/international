package intern.patterns.twopointers;

import inter.patterns.twopointers.TipletSum;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TripletSumTest {

    private TipletSum calculator = new TipletSum();

    @Test
    public void test1ViaBrutal() {

        int[] input = {0, -1, 2, -3, 1};


        var sol1 = Stream.of(-3, 1, 2).sorted().collect(Collectors.toList());
        var sol2 = Stream.of(-1, 0, 1).sorted().collect(Collectors.toList());
        var solution = List.of(sol1, sol2);

        var results = calculator.findAllTripletSumToZeroBrutal(input);

        Assert.assertTrue(solution.containsAll(results));
        Assert.assertTrue(results.containsAll(solution));

    }
}
