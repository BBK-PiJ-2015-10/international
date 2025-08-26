package inter.patterns.dynamic;

import java.util.logging.Logger;

public class LongestPalindrome {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public String longestPalindrome(String word) {
        int maxLength = 1;
        int startIndex = 0;
        if (word == null || word.isBlank()) {
            return "";
        }
        boolean[][] dp = new boolean[word.length()][word.length()];
        for (int i = 0; i < word.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < word.length() - 1; i++) {
            Character characteri = word.charAt(i);
            Character characternext = word.charAt(i + 1);
            //logger.info(String.format("Comparing %s with %s", i, i + 1));
            if (characteri.equals(characternext)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                startIndex = i;
            } else {
                dp[i][i + 1] = false;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 2; j < word.length(); j++) {
                Character characteri = word.charAt(i);
                Character characterj = word.charAt(j);
                if (characteri.equals(characterj)) {
                    boolean prior = dp[i + 1][j - 1];
                    if (prior) {
                        logger.info(String.format("Evaluating %s and %s",characteri,characterj));
                        dp[i][j] = true;
                        int existingLength = j - i;
                        if (existingLength>maxLength){
                            maxLength = existingLength;
                            startIndex = i;
                            logger.info(String.format("Start index is %s Max length is %s",startIndex,maxLength));
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
                //logger.info(String.format("Processing with %s with %s", i, j));
            }
        }
        String result = word.substring(startIndex, startIndex + maxLength);
        logger.info(String.format("Solution is %s",result));
        return result;
    }

    private boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        } else {
            Character firstCharacter = word.charAt(0);
            Character lastCharacter = word.charAt(word.length() - 1);
            if (firstCharacter.equals(lastCharacter)) {
                if (word.length() > 2) {
                    return isPalindrome(word.substring(1, word.length() - 1));
                } else {
                    return true;
                }
            } else {
                return false;
            }
            //return false;
        }
    }

}
