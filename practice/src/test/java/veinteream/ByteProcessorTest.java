package veinteream;

import org.junit.Assert;
import org.junit.Test;

public class ByteProcessorTest {

    private BytesProcessor processor = new BytesProcessor();

    @Test
    public void test1() {

        var bytesQuantity = 123;
        var result = processor.compute(bytesQuantity);

        Assert.assertEquals("123", result);

    }

    @Test
    public void test2() {

        var bytesQuantity = 1024;
        var result = processor.compute(bytesQuantity);

        Assert.assertEquals("1 KiB", result);

    }

    @Test
    public void test3() {

        var bytesQuantity = 3687;
        var result = processor.compute(bytesQuantity);

        Assert.assertEquals("3 KiB", result);

    }

    @Test
    public void test4() {

        var bytesQuantity = 1048575;
        var result = processor.compute(bytesQuantity);

        Assert.assertEquals("1 MiB", result);

    }

    @Test
    public void test5() {

        var bytesQuantity = 1293941552;
        var result = processor.compute(bytesQuantity);

        Assert.assertEquals("1234 MiB", result);

    }


}
