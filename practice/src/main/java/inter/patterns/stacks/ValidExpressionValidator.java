package inter.patterns.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class ValidExpressionValidator {

    private Logger logger = Logger.getLogger(ValidExpressionValidator.class.getName());

    private Set<Character> openParenthesis = Set.of('(', '{', '[');
    private Map<Character, Character> closeToOpen = Map.of(')', '(', '}', '{', ']', '[');
    
    public boolean isValidExpression(String input) {
        Map<Character, Integer> existingOpenParenthesis = new HashMap<>();
        Boolean result = false;
        if (input.isEmpty() || input.length() % 2 != 0) {
            return false;
        }
        var inputCharacters = input.toCharArray();
        for (int i = 0; i < inputCharacters.length; i++) {
            Character parenthesis = inputCharacters[i];
            var isOpenParenthesis = openParenthesis.contains(parenthesis);
            if (isOpenParenthesis) {
                var existingOpenCount = existingOpenParenthesis.get(parenthesis);
                logger.info(String.format("%s is open parenthesis", parenthesis));
                if (existingOpenCount == null) {
                    logger.info(String.format("Updating %s with count %s", parenthesis, 1));
                    existingOpenParenthesis.put(parenthesis, 1);
                } else {
                    existingOpenParenthesis.put(parenthesis, existingOpenCount + 1);
                }
            } else {
                logger.info(String.format("%s is closed parenthesis", parenthesis));
                var openParenthesis = closeToOpen.get(parenthesis);
                var existingOpenCount = existingOpenParenthesis.get(openParenthesis);
                if (existingOpenCount == null) {
                    return false;
                }
                if (existingOpenCount <= 1) {
                    existingOpenParenthesis.remove(openParenthesis);
                } else {
                    existingOpenParenthesis.put(openParenthesis, existingOpenCount - 1);
                }
            }
        }
        return existingOpenParenthesis.isEmpty();
    }

}
