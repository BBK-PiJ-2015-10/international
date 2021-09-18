package mathandpuzzles;

import java.util.logging.Logger;

public class Divisable {

    public Logger logger = Logger.getLogger(Divisable.class.getName());

    public boolean divisibleByDigits(int number){
        return divisibleByDigits(String.valueOf(number),0);
    }

    private boolean divisibleByDigits(String number, int pos){
        if (pos >= number.length()){
            logger.info(String.format("%s is fully divisible, reached pos %s",number,pos));
            return true;
        }
        String denominator = number.substring(pos,pos+1);
        if (Integer.valueOf(number) % Integer.valueOf(denominator) == 0){
            logger.info(String.format("%s is divisible by %s",number,denominator));
            return divisibleByDigits(number,pos+1);
        } else {
            logger.info(String.format("%s is not divisible by %s",number,denominator));
            return false;
        }
    }


}
