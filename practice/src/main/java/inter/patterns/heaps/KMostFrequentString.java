package inter.patterns.heaps;

import java.util.*;

public class KMostFrequentString {

    class StringCounter {
        String string;
        Integer count;

        public StringCounter(String string, Integer count) {
            this.string = string;
            this.count = count;
        }
    }

    /**
     * Find the k-most frequent strings, sorted by frequency large to small and the lexicographicalordre
     */
    public List<String> getKthMostFrequentStrings(String[] words, int k) {
        List<String> topKth = new LinkedList<>();
        Comparator<StringCounter> descThenLexicological = (sc1, sc2) -> {
            var resultByCount = -sc1.count.compareTo(sc2.count);
            if (resultByCount == 0) {
                var resultByLexi = -sc1.string.compareTo(sc2.string);
                return resultByLexi;
            } else {
                return resultByCount;
            }
        };
        Queue<StringCounter> queue = new PriorityQueue<>(descThenLexicological);
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Integer existingCount = wordCount.get(word);
            if (existingCount == null) {
                wordCount.put(word, 1);
            } else {
                wordCount.put(word, existingCount + 1);
            }
        }
        wordCount.entrySet().stream().map(es -> new StringCounter(es.getKey(), es.getValue())).forEach(es ->
                queue.add(es));
        int existingCount = 0;
        while (existingCount < k && !queue.isEmpty()) {
            var wc = queue.poll();
            topKth.add(wc.string);
            existingCount++;
        }
        return topKth;
    }

}
