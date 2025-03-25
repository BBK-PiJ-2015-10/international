package intern.patterns.greedy;

import inter.patterns.greedy.GasStations;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GasStationsTest {

    private GasStations calculator = new GasStations();

    @Test
    public void test1() {

        var gas = List.of(2, 5, 1, 3);
        var cost = List.of(3, 2, 1, 4);

        var startingPoint = calculator.startingPoint(cost, gas);

        Assert.assertEquals(1, startingPoint);
    }
}
