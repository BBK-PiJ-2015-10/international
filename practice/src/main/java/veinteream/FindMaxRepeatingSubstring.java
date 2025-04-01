package veinteream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class FindMaxRepeatingSubstring {

    private Logger logger = Logger.getLogger(FindMaxRepeatingSubstring.class.getName());

    // longest recurring substring
    // "abcabca" => abca
    // there will always be only one anaswe
    public String findMaxRepeatingSubstringWithOverlap(String text) {
        int maxSize = text.length() - 1;
        Map<String, Integer> stringCounts = new HashMap<>();
        int longestRepeatingSize = 0;
        while (maxSize > 0 && maxSize >= longestRepeatingSize) {
            logger.info(String.format("Evaluating with maxSize %d", maxSize));
            for (int i = 0; i < text.length(); i++) {
                var end = i + maxSize;
                logger.info(String.format("Evaluating (%d,%d)", i, end));
                if (end <= text.length()) {
                    var subString = text.substring(i, end);
                    if (subString.length() > longestRepeatingSize) {
                        var existingCount = stringCounts.get(subString);
                        if (existingCount == null) {
                            logger.info(String.format("Updating map with substring %s", subString));
                            stringCounts.put(subString, 1);
                        } else {
                            logger.info(String.format("Found a max repeating substring %s", subString));
                            if (subString.length() > longestRepeatingSize) {
                                longestRepeatingSize = subString.length();
                            }
                            stringCounts.put(subString, existingCount + 1);
                        }
                    }
                } else {
                    logger.info(String.format("Skipping evaluation will go to far i %d and end %d", i, end));
                }
            }
            maxSize--;
        }
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer c = o1.length();
                Integer d = o2.length();
                return c.compareTo(d);
            }
        };

        Optional<String> longestSubstring = stringCounts.keySet().stream()
                .filter(d -> stringCounts.get(d) > 1)
                .max(customComparator);
        String result = longestSubstring.orElse("");
        logger.info(String.format("The longest is %s", result));
        return result;
    }


}
