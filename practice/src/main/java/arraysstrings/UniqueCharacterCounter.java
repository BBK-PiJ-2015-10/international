package arraysstrings;

public class UniqueCharacterCounter {

    public boolean unique(String input) {
        if (input == null) {
            return true;
        }
        return Long.valueOf(input.length()).compareTo(input.chars().distinct().count()) == 0;
    }

}
