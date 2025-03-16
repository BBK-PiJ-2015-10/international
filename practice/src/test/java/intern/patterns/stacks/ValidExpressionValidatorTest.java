package intern.patterns.stacks;

import inter.patterns.stacks.ValidExpressionValidator;
import org.junit.Assert;
import org.junit.Test;

public class ValidExpressionValidatorTest {

    private ValidExpressionValidator validator = new ValidExpressionValidator();

    @Test
    public void test1() {

        String input = "";

        var result = validator.isValidExpression(input);


        Assert.assertEquals(false, result);

    }

    @Test
    public void test2() {

        String input = "{";

        var result = validator.isValidExpression(input);


        Assert.assertEquals(false, result);

    }

    @Test
    public void test3() {

        String input = "}{";

        var result = validator.isValidExpression(input);


        Assert.assertEquals(false, result);

    }

    @Test
    public void test4() {

        String input = "{}";

        var result = validator.isValidExpression(input);


        Assert.assertEquals(true, result);

    }


}
