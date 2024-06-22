package codility.scal;

import org.junit.Test;
import org.junit.Assert;

public class InverterTest {

    private Inverter Inverter = new Inverter();

    @Test
    public void givenALargeSingleCharacterStringInvertShouldReturnSameStringString() {

        String input = "AAAAAAAAAAAAAAA";

        String result = Inverter.invert(input);

        Assert.assertEquals(input, result);

    }


}
