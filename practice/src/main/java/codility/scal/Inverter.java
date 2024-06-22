package codility.scal;


// Java program to ReverseString using StringBuilder
import java.lang.*;

public class Inverter {


    public Inverter() {
    }

    public String invert(String inputString) {
        StringBuilder input = new StringBuilder();
        input.append(inputString);
        var act  = input.reverse();
        return act.toString();
    }

}
