package inter.patterns.sliding;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LongestUniformSubstring {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int longestUniformSubstring(String input, int maxReplacement) {
        Map<String, Integer> results = new HashMap<>();
        var maxResult = 0;
        for (int i = 0; i < input.length(); i++) {
            String character = input.substring(i, i + 1);
            int maxCharacter = evaluate(input, maxReplacement, character, results);
            maxResult = Math.max(maxResult, maxCharacter);
            logger.info(String.format("Evaluating char: %s at beg: %d end: %d with maxCharacter %d maxResult %d", character, i, i + 1, maxResult,maxCharacter));
        }
        return maxResult;
    }

    private int evaluate(String input, int maxReplacement, String character, Map<String, Integer> results) {
        var existingResult = results.get(character);
        if (existingResult != null) {
            return existingResult;
        }
        int beg = 0;
        int end = beg + 1;
        int maxLength = 0;
        int replaced = 0;
        while (end <= input.length()) {
            var evaluated = input.substring(end-1, end);
            logger.info(String.format("Comparing %s with %s",character,evaluated));
            if (evaluated.equals(character)) {
                maxLength = Math.max(maxLength, end - beg);
                end++;
            } else {
                if (replaced < maxReplacement) {
                    replaced++;
                    maxLength = Math.max(maxLength, end - beg);
                    end++;
                } else {
                    beg = end;
                    end = beg + 1;
                    replaced = 0;
                }
            }
        }
        results.put(character, maxLength);
        return maxLength;
    }

}
