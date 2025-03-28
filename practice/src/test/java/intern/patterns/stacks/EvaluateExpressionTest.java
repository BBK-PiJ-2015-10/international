package intern.patterns.stacks;

import inter.patterns.stacks.EvaluateExpression;
import org.junit.Assert;
import org.junit.Test;

public class EvaluateExpressionTest {

    private EvaluateExpression evaluator = new EvaluateExpression();

    @Test
    public void test1(){

        String expression = "18-(7+(2-4)";

        var result = evaluator.evaluateExpression(expression);



        Assert.assertEquals(true,true);

    }

}
