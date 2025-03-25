package intern.patterns.greedy;

import inter.patterns.greedy.JumpToTheEnd;
import org.junit.Assert;
import org.junit.Test;

public class JumpToTheEndTest {

    private JumpToTheEnd calculator = new JumpToTheEnd();

    @Test
    public void test1() {

        int[] input = {3, 2, 0, 2, 5};
        var result = calculator.canJumpToTheEnd(input);
        Assert.assertEquals(result, true);

    }

    @Test
    public void test2() {

        int[] input = {2, 1, 0, 3};
        var result = calculator.canJumpToTheEnd(input);
        Assert.assertEquals(result, false);

    }

}
