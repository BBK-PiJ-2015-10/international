package arraysstrings;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestSequence {

    private Logger logger = Logger.getLogger(LongestSequence.class.getName());

    public int calculateLongestSequence(int[] sequence) {
        int longestSequenceCount = 1;
        Set<Integer> set = IntStream.of(sequence)
            .boxed()
            .collect(Collectors.toSet());

        for (Integer value : set) {
            if (!set.contains(value - 1)) {
                logger.info(String.format("New sequence count started with %s",value));
                int newSequenceCount = 1;
                while (set.contains(value + newSequenceCount)) {
                    ++newSequenceCount;
                }
                logger.info(String.format("Evaluating newSequenceCount of %s vs currentLongestCount of %s",newSequenceCount,longestSequenceCount));
                longestSequenceCount = Math.max(newSequenceCount,longestSequenceCount);
            }
        }

        return longestSequenceCount;
    }

}
