package codility.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StringAlgosImpl implements StringAlgos {

    public StringAlgosImpl() {
    }

    @Override
    public int longestSubStringWithOutRepeatingCharacters(String s) {

        String currentNonRepeating = "";
        String longestNonRepeating = currentNonRepeating;

        var stringList = s.chars().mapToObj(e -> (char) e)
                .map(c -> c.toString())
                .collect(Collectors.toList());

        for (int i = 0; i < stringList.size(); i++) {
            var evaluatingString = stringList.get(i);
            System.out.println("Evaluating string: " + evaluatingString);
            var containedPosition = currentNonRepeating.indexOf(evaluatingString);
            if (containedPosition == -1) {
                currentNonRepeating = currentNonRepeating + evaluatingString;
                if (currentNonRepeating.length() >= longestNonRepeating.length()) {
                    longestNonRepeating = currentNonRepeating;
                    System.out.println("Longest non repeating updated to : " + longestNonRepeating);
                }
                System.out.println("It did not repeat. New current is: " + currentNonRepeating);
            } else {
                currentNonRepeating = currentNonRepeating.substring(containedPosition + 1);
                System.out.println("It did repeat. New current is: " + currentNonRepeating);
            }
        }

        return longestNonRepeating.length();
    }
}
