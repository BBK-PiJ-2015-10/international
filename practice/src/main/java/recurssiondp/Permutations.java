package recurssiondp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Permutations {

    private Logger logger = Logger.getLogger(Permutations.class.getName());

    public List<String> permutations(String string){
        List<String> strings = new ArrayList<>();
        strings.add(string);
        return permutationsAux(strings,0,string.length()-1);
    }

    public List<String> permutationsAux(List<String> strings, int position, int end) {
        List<String> permutations = new ArrayList<>();
        if (position >= end) {
            logger.info(String.format("Position %s equal to end %s", position, end));
            strings.stream().distinct().collect(Collectors.toList());
        }
        strings.forEach(string -> {
            logger.info(String.format("Evaluating string %s", string));
            char[] input = string.toCharArray();
            char toBeReplaced = input[position];
            for (int i = position; i < string.length(); i++) {
                char[] permutation = input.clone();
                char replacer = permutation[i];
                logger.info(String.format("Replacing %s with %s", toBeReplaced, replacer));
                permutation[position] = replacer;
                permutation[i] = toBeReplaced;
                String newPermutation = String.valueOf(permutation);
                logger.info(String.format("Adding permutation %s", newPermutation));
                permutations.add(newPermutation);
            }
        });
        return permutationsAux(permutations, position + 1, end);
    }


}
