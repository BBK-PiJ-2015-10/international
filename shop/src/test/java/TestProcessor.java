import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert.*;


public class TestProcessor {

    private Processor processor = new Processor();

    @Test
    public void test1Sample(){

        String postalCode = "B0P 1X0";
        String provinceCode = "";

        boolean result = processor.is_valid_postal_code(postalCode, provinceCode);

        Assert.assertEquals(true,result);


    }



}
