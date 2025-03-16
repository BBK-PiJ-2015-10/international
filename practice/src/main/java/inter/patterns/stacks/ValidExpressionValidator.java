package inter.patterns.stacks;

import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Logger;

public class ValidExpressionValidator {

    private Logger logger = Logger.getLogger(ValidExpressionValidator.class.getName());

    private Set<Character> openParenthesis = Set.of('(', '{', '[');
    private Map<Character, Character> closeToOpen = Map.of(')', '(', '}', '{', ']', '[');

    public boolean isValidExpression(String input) {
        if (input.isEmpty() || input.length() % 2 != 0) {
            return false;
        }
        Stack<Character> openStack = new Stack<>();
        var characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            Character parenthesis = characters[i];
            if (openParenthesis.contains(parenthesis)) {
                openStack.push(parenthesis);
            } else {
                var expectedOpen = closeToOpen.get(parenthesis);
                if (openStack.isEmpty()) {
                    return false;
                }
                var latestOpen = openStack.pop();
                if (latestOpen == null || latestOpen.equals(expectedOpen) == false) {
                    return false;
                }
            }
        }
        return openStack.isEmpty();
    }

}
