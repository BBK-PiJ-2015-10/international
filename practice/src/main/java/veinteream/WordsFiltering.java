package veinteream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordsFiltering {

    public List<String> filterWords(String[] words, String letters) {
        List<String> filteredWords = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            if (word.matches("[ae]")) {
                filteredWords.add(word);
            }
        }
        //String[] result = (String[]) filteredWords.toArray();
        return filteredWords;
    }

}
