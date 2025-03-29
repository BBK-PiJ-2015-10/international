package intern.patterns.stacks;

import inter.patterns.stacks.EvaluateExpression;
import org.junit.Assert;
import org.junit.Test;

public class EvaluateExpressionTest {

    private EvaluateExpression evaluator = new EvaluateExpression();

    @Test
    public void test1() {

        String expression = "18-10+7";

        var result = evaluator.evaluate(expression);

        Assert.assertEquals(15, result);

    }

    @Test
    public void test2() {

        String expression = "10-(7+(2+4))";

        var result = evaluator.evaluate(expression);

        Assert.assertEquals(-3, result);

    }

    @Test
    public void test3() {

        // create an expression with multiple parenthesis
        String expression = "18-(7+(2-4))";

        var result = evaluator.evaluate(expression);

        Assert.assertEquals(13, result);

    }

}
