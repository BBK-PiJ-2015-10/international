package arraysstrings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class LongestSubStringWithoutRepeatingCharacters {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int longest(String input) {
        var maxSize = 0;
        List<Character> characters = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Map<Character, Integer> existingCharPosition = new HashMap<>();
        int left = -1;
        int right = 0;
        while (left <= right && right < characters.size()) {
            var currentChar = characters.get(right);
            logger.info(String.format("Evaluating character %s and maxSize is %d with left %d and right %d", currentChar, maxSize, left, right));
            var existingPos = existingCharPosition.get(currentChar);
            if (existingPos == null) {
                existingCharPosition.put(currentChar, right);
                var currentSize = right - left;
                maxSize = Math.max(maxSize, currentSize);
                right++;
            } else {
                logger.info(String.format("Char repeated %s old at pos %d new at pos %d", currentChar, existingPos, right));
                existingCharPosition.clear();
                left = right;
                right++;
            }
            logger.info(String.format("Max size is %d", maxSize));
        }
        return maxSize;
    }

}
