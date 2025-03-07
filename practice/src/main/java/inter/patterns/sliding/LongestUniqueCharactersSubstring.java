package inter.patterns.sliding;

import java.util.HashSet;

public class LongestUniqueCharactersSubstring {

    public int getLongestUniqueCharactersSubstring(String input) {
        var maxLens = 0;
        HashSet<Character> existingCharacters = new HashSet<>();
        int left = 0;
        int right = 0;
        var inputArray = input.toCharArray();
        while (right < inputArray.length) {
            var characterEvaluated = inputArray[right];
            while (existingCharacters.contains(characterEvaluated)) {
                existingCharacters.remove(inputArray[left]);
                left++;
            }
            maxLens = Math.max(maxLens, right - left + 1);
            existingCharacters.add(characterEvaluated);
            right++;
        }
        return maxLens;
    }

}
