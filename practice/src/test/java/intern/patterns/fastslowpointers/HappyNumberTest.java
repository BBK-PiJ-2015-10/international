package intern.patterns.fastslowpointers;

import inter.patterns.fastslowpointers.HappyNumber;
import org.junit.Assert;
import org.junit.Test;

public class HappyNumberTest {

    private HappyNumber calculator = new HappyNumber();

    @Test
    public void test1() {

        var nextNumber = calculator.nextNumber(23);


        Assert.assertEquals(13, nextNumber);

    }

    @Test
    public void test2() {

        var isHappy = calculator.isHappyNumber(23);


        Assert.assertEquals(true, isHappy);

    }
}
