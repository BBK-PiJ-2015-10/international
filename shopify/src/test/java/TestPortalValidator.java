import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TestPortalValidator {

    private PostalValidator postalValidator = new PostalValidator();

    @Test
    public void test1(){


        //is_valid_postal_code("B0P 1X0", "NS") => true
        String postalCode = "B0P 1X0";
        String providenceCode = "NS";

        Assert.assertEquals(true,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test2(){


        //        is_valid_postal_code("b0P 1x0", "NS") => false
        String postalCode = "b0P 1x0";
        String providenceCode = "NS";

        Assert.assertEquals(false,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test3(){


        //is_valid_postal_code("M5W 1E6", "QC") => false
        String postalCode = "M5W 1E6";
        String providenceCode = "QC";

        Assert.assertEquals(false,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test4(){


        //is_valid_postal_code("X0A 0H0", "NU") => true
        String postalCode = "X0A 0H0";
        String providenceCode = "NU";

        Assert.assertEquals(true,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test5(){


        //is_valid_postal_code("V0F G5A", "BC") => false
        String postalCode = "V0F G5A";
        String providenceCode = "BC";

        Assert.assertEquals(false,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test6(){


        //is_valid_postal_code("X0A0H0", "NU") => false
        String postalCode = "X0A0H0";
        String providenceCode = "NU";

        Assert.assertEquals(false,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test7(){


        // is_valid_postal_code("V0G 3E3", "BC") => true
        String postalCode = "V0G 3E3";
        String providenceCode = "BC";

        Assert.assertEquals(true,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test8(){


        //is_valid_postal_code("B0P 1X", "NS") => false
        String postalCode = "B0P 1X";
        String providenceCode = "NS";

        Assert.assertEquals(false,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }

    @Test
    public void test9(){

        //is_valid_postal_code("B0P 1X0B", "NS") => false

        String postalCode = "B0P 1X0B";
        String providenceCode = "NS";

        Assert.assertEquals(false,postalValidator.is_valid_postal_code(postalCode,providenceCode));

    }



    @Test
    public void test10(){

        //  province_for_postal_code("P3E 5P9") => "ON"
        String postalCode = "P3E 5P9";
        String providenceCode = "ON";

        Assert.assertEquals(providenceCode,postalValidator.province_for_postal_code(postalCode).get());

    }

    @Test
    public void test11(){

        //  province_for_postal_code("P3e 5p9") => null
        String postalCode = "P3e 5p9";

        Assert.assertEquals(Optional.empty(),postalValidator.province_for_postal_code(postalCode));

    }

    @Test
    public void test12(){

        //  province_for_postal_code("P3E 5P9") => "ON"
        String postalCode = "P3E 5P9";
        String providenceCode = "ON";

        Assert.assertEquals(providenceCode,postalValidator.province_for_postal_code(postalCode).get());

    }

    @Test
    public void test13(){

        //  province_for_postal_code("P3E N0M") => null
        String postalCode = "P3E N0M";

        Assert.assertEquals(Optional.empty(),postalValidator.province_for_postal_code(postalCode));

    }

    @Test
    public void test14(){

        //   province_for_postal_code("X0E 0T0") => "NT"
        String postalCode = "X0E 0T0";
        String providenceCode = "NT";

        Assert.assertEquals(providenceCode,postalValidator.province_for_postal_code(postalCode).get());

    }

    @Test
    public void test15(){

        //  province_for_postal_code("Q1Q 1Q1") => null
        String postalCode = "Q1Q 1Q1";

        Assert.assertEquals(Optional.empty(),postalValidator.province_for_postal_code(postalCode));

    }

    @Test
    public void test16(){

        //  province_for_postal_code("Y1A 1V6") => "YT"
        String postalCode = "Y1A 1V6";
        String providenceCode = "YT";

        Assert.assertEquals(providenceCode,postalValidator.province_for_postal_code(postalCode).get());

    }

    @Test
    public void test17(){

        //  province_for_postal_code("Y1A1V6") => null
        String postalCode = "Y1A1V6";

        Assert.assertEquals(Optional.empty(),postalValidator.province_for_postal_code(postalCode));

    }

    @Test
    public void test18(){

        //  province_for_postal_code("P3E 5P") => null
        String postalCode = "P3E 5P";

        Assert.assertEquals(Optional.empty(),postalValidator.province_for_postal_code(postalCode));

    }

    @Test
    public void test19(){

        //  province_for_postal_code("Y1A 1V66") => null
        String postalCode = "Y1A 1V66";

        Assert.assertEquals(Optional.empty(),postalValidator.province_for_postal_code(postalCode));

    }










}
