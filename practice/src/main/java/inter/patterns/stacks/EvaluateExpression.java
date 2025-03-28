package inter.patterns.stacks;


import java.util.List;
import java.util.logging.Logger;

public class EvaluateExpression {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private List<Character> parents = List.of('(', ')');
    private List<Character> signs = List.of('+', '-');
    private Character plus = '+';
    private Character minus = '-';
    private Character openParam = '(';
    private Character closeParam = ')';

    public int evaluateExpression(String expression) {
        var expressionArray = expression.chars().mapToObj(c -> (char) c).toList();
        var result = 0;
        int existingNumber = 0;
        int newDigit = 0;
        for (int i = 0; i < expressionArray.size(); i++) {
            Character character = expressionArray.get(i);
            if (Character.isDigit(character)) {
                newDigit = Integer.valueOf(character.toString());
                existingNumber = existingNumber * 10 + newDigit;
                logger.info(String.format("Updating existing number to %s", existingNumber));
            } else {
                existingNumber = 0;
            }
            logger.info(String.format("Evaluating character %s", character));
        }
        return result;
    }

}
