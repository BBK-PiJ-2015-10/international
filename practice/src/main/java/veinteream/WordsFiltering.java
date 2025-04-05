package veinteream;


import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsFiltering {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public List<String> filterWords(String[] words, String letters) {
        List<String> filteredWords = new LinkedList<>();
        String regex = "";
        for (int i = 0; i < letters.length(); i++) {
            if (i == 0) {
                regex = regex + letters.substring(i, i + 1);
            } else {
                regex = regex + "|" + letters.substring(i, i + 1);
            }
        }
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                logger.info(String.format("Adding word %s", word));
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

}
