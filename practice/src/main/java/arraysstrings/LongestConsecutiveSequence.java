package arraysstrings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    private Logger logger = LoggerFactory.getLogger(LongestConsecutiveSequence.class.getName());

    public int longestConsecutive(int[] nums) {
        var elements = new HashSet<Integer>();
        for (var num : nums) {
            elements.add(num);
        }
        var longestSequenceCount = 0;
        for (Integer elem: elements){
            var prior = elem - 1;
            if (!elements.contains(prior)){
                var currentLength = 1;
                var currentElem = elem;
                while (elements.contains(currentElem + 1)){
                    currentElem += 1;
                    currentLength += 1;
                }
                longestSequenceCount = Math.max(longestSequenceCount,currentLength);
            }
        }
        return longestSequenceCount;
    }

}
