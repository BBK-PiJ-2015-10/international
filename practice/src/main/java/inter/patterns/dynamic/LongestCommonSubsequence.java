package inter.patterns.dynamic;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String word1, String word2) {
        char[] w1Chars = word1.toCharArray();
        char[] w2Chars = word2.toCharArray();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int c1 = 0; c1 < word1.length(); c1++) {
            dp[c1][word2.length()] = 0;
        }
        for (int c2 = 0; c2 < word2.length(); c2++) {
            dp[word1.length()][c2] = 0;
        }
        for (int c1 = word1.length() - 1; c1 >= 0; c1--) {
            for (int c2 = word2.length() - 1; c2 >= 0; c2--) {
                var c1Val = w1Chars[c1];
                var c2Val = w2Chars[c2];
                if (c1Val == c2Val) {
                    dp[c1][c2] = dp[c1 + 1][c2 + 1] + 1;
                } else {
                    dp[c1][c2] = Math.max(
                            dp[c1 + 1][c2], dp[c1][c2 + 1]);
                }
            }
        }
        return dp[0][0];
    }

}
