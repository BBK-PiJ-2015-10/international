package fourth;

public class Wrapper {

    public <T extends School> String introduce(T input){
        return input.getName();
    }

    public String bark(School input) {
        return "woof " +input.getName();
    }

}
