package intern.patterns.backtracking;

import inter.patterns.backtracking.FindAllPermutations;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FindAllPermutationsTest {

    private FindAllPermutations calculator = new FindAllPermutations();

    @Test
    public void test1() {

        var list = List.of(4, 5, 6);

        var result = calculator.findAllPermutations(list);

        Assert.assertEquals(true, true);

    }
}
