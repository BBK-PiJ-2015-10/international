package intern.patterns.prefixsums;

import inter.patterns.prefixsums.ProductArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductArrayTest {

    private ProductArray calculator = new ProductArray();

    @Test
    public void test1() {

        int[] input = {2, 3, 1, 4, 5};
        int[] output = {60, 40, 120, 30, 24};

        var result = calculator.productArrayWithoutCurrent(input);

        var resultA = Arrays.stream(result).boxed().collect(Collectors.toList());
        var resultE = Arrays.stream(output).boxed().collect(Collectors.toList());

        Assert.assertEquals(resultE, resultA);

    }

    @Test
    public void test2() {

        int[] input = {2, 3, 1, 4, 5};
        int[] output = {60, 40, 120, 30, 24};

        var result = calculator.productArrayWithoutCurrentLeftAndRight(input);

        var resultA = Arrays.stream(result).boxed().collect(Collectors.toList());
        var resultE = Arrays.stream(output).boxed().collect(Collectors.toList());

        Assert.assertEquals(resultE, resultA);

    }

    @Test
    public void test3() {

        int[] input = {2, 3, 1, 4, 5};
        int[] output = {60, 40, 120, 30, 24};

        var result = calculator.productArrayWithoutCurrentLeftAndRightLessSpace(input);

        var resultA = Arrays.stream(result).boxed().collect(Collectors.toList());
        var resultE = Arrays.stream(output).boxed().collect(Collectors.toList());

        Assert.assertEquals(resultE, resultA);

    }
}

