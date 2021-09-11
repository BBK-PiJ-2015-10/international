package linkedlistmaps;

import java.util.List;
import java.util.logging.Logger;

public class Palindrome {

    private Logger logger = Logger.getLogger(Palindrome.class.getName());

    public boolean isPalindrome(int[] array){
        if (array.length==0){
            return false;
        } else {
            return auxIsPalindrome(0,array.length-1,array);
        }
    }

    private boolean auxIsPalindrome(int start, int end, int[] array){
        logger.info(String.format("Comparing positions %s with position %s",start,end));
        if (start < end){
            if(array[start]==array[end]){
                return auxIsPalindrome(start+1,end-1,array);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean isPalindrome(List<Integer> list){
        if (list.isEmpty()){
            return false;
        }
        return isPalindromeAux(0,list.size()-1,list);
    }

    private boolean isPalindromeAux(int beg, int end, List<Integer> list){
        if (beg<end){
            if (list.get(beg)==list.get(end)){
                return isPalindromeAux(beg+1,end-1,list);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

}
