package leetcode.dynamicp;


//https://leetcode.com/problems/longest-palindromic-substring/?envType=problem-list-v2&envId=dynamic-programming
public class LongestPalindromicSubstring {

    public LongestPalindromicSubstring() {
    }

    public String longestPalindrome(String s) {
        var longestSubstring = s.substring(0,1);
        for (int i = 0; i <= s.length(); i++) {
            for (int k = i + 1; k <= s.length(); k++) {
                var subString = s.substring(i, k);
                System.out.println(String.format("i is %s, k is %s, substring is %s", i, k, subString));
                if (longestSubstring.length()<subString.length()){
                    var isPalindrome = isPalindrome(subString);
                    if (isPalindrome){
                        longestSubstring = subString;
                    }
                } else {
                    //break;
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String input) {
        if (input.length() == 1) {
            return true;
        } else {
            var left = input.substring(0, 1);
            var right = input.substring(input.length() - 1, input.length());
            if (left.equals(right)) {
                var middle = input.substring(1, input.length() - 1);
                if (middle.isEmpty()) {
                    return true;
                } else {
                    return isPalindrome(middle);
                }
            } else {
                return false;
            }
        }
    }

}
