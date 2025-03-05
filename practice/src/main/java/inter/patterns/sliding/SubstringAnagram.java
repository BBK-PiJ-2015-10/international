package inter.patterns.sliding;

import java.util.Arrays;

public class SubstringAnagram {

    public int getSubstringAnagrams(String input, String target) {
        var result = 0;
        if (input == null || target == null || input.length() == 0 || target.length() == 0 || input.length() < target.length()) {
            return result;
        }
        int[] expectedFrequencies = new int[26];
        Arrays.fill(expectedFrequencies, 0);
        int[] windowsFrequency = new int[26];
        Arrays.fill(windowsFrequency, 0);
        var targetChars = target.toCharArray();
        char a = 'a';
        int baseAscii = a;
        for (int i = 0; i < targetChars.length; i++) {
            int asciiMinusBase = targetChars[i] - baseAscii;
            expectedFrequencies[asciiMinusBase] = expectedFrequencies[asciiMinusBase] + 1;
        }
        for (int i = 0; i <= input.length() - target.length(); i++) {
            var subInput = input.substring(i, i + 3);
            var subInputArray = subInput.toCharArray();
            for (int k = 0; k < subInputArray.length; k++) {
                int asciiMinusBase = subInputArray[k] - baseAscii;
                int contains = expectedFrequencies[asciiMinusBase];
                if (contains == 0) {
                    Arrays.fill(windowsFrequency, 0);
                    break;
                } else {
                    windowsFrequency[asciiMinusBase] = windowsFrequency[asciiMinusBase] + 1;
                }
            }
            if (Arrays.equals(expectedFrequencies, windowsFrequency)) {
                result++;
            }
            Arrays.fill(windowsFrequency, 0);
        }
        return result;
    }
}
