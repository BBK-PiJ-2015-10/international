package inter.patterns.stacks;

import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class EvaluateExpression {

    private Logger logger = Logger.getLogger(this.getClass().getName());


    public int evaluate(String expression) {
        Stack<String> operations = new Stack<>();
        var expressionArray = expression.chars().mapToObj(c -> (char) c).toList();
        Integer result = 0;
        int currentNumber = 0;
        Integer sign = 1;
        for (int i = 0; i < expressionArray.size(); i++) {
            var character = expressionArray.get(i);
            logger.info(String.format("Char is %s at position %s", character, i));
            if (Character.isDigit(character)) {
                currentNumber = (currentNumber * 10) + Integer.valueOf(character.toString());
                logger.info(String.format("Current number is %s", currentNumber));
            } else {
                if (List.of('+', '-').contains(character)) {
                    result += currentNumber * sign;
                    logger.info(String.format("Updating result to %s", result));
                    if (character.equals('+')) {
                        sign = 1;
                    } else {
                        sign = -1;
                    }
                    currentNumber = 0;
                } else {
                    if (character.equals('(')) {
                        operations.push(result.toString());
                        operations.push(sign.toString());
                        result = 0;
                        sign = 1;
                    } else {
                        result += sign * currentNumber;
                        result = result * Integer.valueOf(operations.pop().toString());
                        result += Integer.valueOf(operations.pop().toString());
                        currentNumber = 0;
                    }
                }
            }
        }
        return result + currentNumber * sign;
    }

}
