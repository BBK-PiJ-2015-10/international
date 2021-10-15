import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Extra: https://www.baeldung.com/regular-expressions-java

public class SearchWord {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Map<Integer, Set<String>> dictionary = new HashMap<>();

    public void addWord(String word){
        Set<String> words = dictionary.get(word.length());
        if (words==null){
            words = new HashSet<>();
            words.add(word);
            logger.info(String.format("Added word %s and created key %s",word,word.length()));
            dictionary.put(word.length(),words);
        } else {
            words.add(word);
            logger.info(String.format("Added word %s to existing key %s",word,word.length()));
        }
    }

    public boolean searchWord(String regex){
        Set<String> words = dictionary.get(regex.length());
        if (words==null){
            return false;
        }
        for(String word: words){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()){
                logger.info(String.format("Word %s matches regex %s",word,regex));
                return true;
            } else {
                logger.info(String.format("Word %s does not matches regex %s",word,regex));
            }
        }
        return false;
    }

}
