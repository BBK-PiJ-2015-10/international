package leetcode.dynamicp;


//https://leetcode.com/problems/longest-palindromic-substring/?envType=problem-list-v2&envId=dynamic-programming
public class LongestPalindromicSubstring {

    public LongestPalindromicSubstring() {
    }

    public String longestPalindrome(String s) {

        for (int i = 0; i <= s.length(); i++) {
            for (int k = i + 1; k <= s.length(); k++) {
                var subString = s.substring(i, k);
                System.out.println(String.format("i is %s, k is %s, substring is %s", i, k, subString));
            }
        }
        return "";
    }

}
