//https://www.vogella.com/tutorials/JavaRegularExpressions/article.html

//https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class PostalValidator {

    private Map<String,String> postalCodeMap = new HashMap<>();

    public PostalValidator() {
        postalCodeMap.put("A","NL");
        postalCodeMap.put("B","NS");
        postalCodeMap.put("C","PE");
        postalCodeMap.put("E","NB");
        postalCodeMap.put("G","QC");
        postalCodeMap.put("H","QC");
        postalCodeMap.put("J","QC");
        postalCodeMap.put("K","ON");
        postalCodeMap.put("L","ON");
        postalCodeMap.put("M","ON");
        postalCodeMap.put("N","ON");
        postalCodeMap.put("P","ON");
        postalCodeMap.put("S","SK");
        postalCodeMap.put("T","AB");
        postalCodeMap.put("V","BC");
        postalCodeMap.put("X0A","NU");
        postalCodeMap.put("X0B","NU");
        postalCodeMap.put("X0C","NU");
        postalCodeMap.put("X0E","NT");
        postalCodeMap.put("X0G","NT");
        postalCodeMap.put("X1A","NT");
        postalCodeMap.put("Y","YT");
    }

    public boolean is_valid_postal_code1(String postal_code, String province_code){

        String regex = "[A-Z]"+"[0-9]"+"[A-Z]"+"[\\s]"+"[0-9]"+"[A-Z]"+"[0-9]";
        if (postal_code.length()!=7){
            return false;
        }
        if (!postal_code.matches(regex)){
            return false;
        } else {
            String key = postal_code.substring(0,1);
            if (key.equals("X")){
                key = postal_code.substring(0,3);
            }
            return postalCodeMap.get(key).equals(province_code);
        }
    }

    public Boolean is_valid_postal_code(String postal_code, String province_code){
        return practice(postal_code,Optional.of(false),x -> x.equals(province_code))
            .orElse(false);
    }

    public Optional<String> province_for_postal_code(String postal_code){
        return practice(postal_code, Optional.empty(),x -> x);
    }



    public Optional<String> province_for_postal_code1(String postal_code){
        if (postal_code.length()!=7){
            return Optional.empty();
        }
        String regex = "[A-Z]"+"[0-9]"+"[A-Z]"+"[\\s]"+"[0-9]"+"[A-Z]"+"[0-9]";
        if (!postal_code.matches(regex)){
            return Optional.empty();
        }
        String key = postal_code.substring(0,1);
        if (key.equals("X")){
            key = postal_code.substring(0,3);
        }
        return Optional.ofNullable(postalCodeMap.get(key));
    }

    public <T> Optional<T> practice(String postal_code, Optional<T> rejected, Function<String,T> function){
        if (postal_code.length()!=7){
            return rejected;
        }
        String regex = "[A-Z]"+"[0-9]"+"[A-Z]"+"[\\s]"+"[0-9]"+"[A-Z]"+"[0-9]";
        if (!postal_code.matches(regex)){
            return rejected;
        }
        String key = postal_code.substring(0,1);
        if (key.equals("X")){
            key = postal_code.substring(0,3);
        }
        return Optional.ofNullable(function.apply(postalCodeMap.get(key)));
    }


}
