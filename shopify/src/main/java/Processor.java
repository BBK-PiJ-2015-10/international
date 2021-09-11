import org.apache.commons.lang3.StringUtils;

public class Processor {

    public Processor() {
    }


    public boolean is_valid_postal_code(String postal_code, String province_code){
        if (!StringUtils.upperCase(postal_code).equals(postal_code)){
            return false;
        }
        Integer length = postal_code.length();
        if(!length.equals(7)){
            return false;
        }
        Character space  = postal_code.charAt(3);
        if (!space.equals(' ')){
            return false;
        }
        if (!helper(postal_code,true,0)){
            return false;
        };
        return true;
    }

    private boolean helper(String input,boolean letter,Integer position){
        if (input.length()<position+1){
            return true;
        }
        if (position.equals(3)){
            return helper(input,false,position+1);
        }
        if (letter){
             if (Character.isLetter(input.charAt(position))){
                 return  helper(input,false,position+1);
             }
             else {
                 return false;
            }
        } else {
            if (Character.isDigit(input.charAt(position))){
                return  helper(input,true,position+1);
            }
             else {

                 return false;
            }
        }
    }

}
