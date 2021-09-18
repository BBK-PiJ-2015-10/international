import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchItem {

    public Set<Item> findMatch(String regex, String[] dictionary) {
        return findMatch(regex,List.of(dictionary));
    }

    private Set<Item> findMatch(String regex, List<String> dictionary) {
        Pattern patter = Pattern.compile(regex);
        Set<Item> matches = new HashSet<>();
        for (String word : dictionary) {
            int matchCount = 0;
            Matcher matcher = patter.matcher(word);
            while (matcher.find()) {
                matchCount++;
            }
            if (matchCount > 0) {
                matches.add(new Item(word, matchCount));
            }
        }
        return matches;
    }

}
