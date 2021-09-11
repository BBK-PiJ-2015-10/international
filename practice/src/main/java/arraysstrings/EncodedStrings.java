package arraysstrings;

import java.util.Arrays;

import java.util.stream.Stream;

public class EncodedStrings {


    public Character[] encodeString(Character[] input){
        return  Arrays.stream(input)
        .map(this::transform)
        .toArray(Character[]::new);
    }

    private Stream<Character> transform(Character input){
        if (Character.isWhitespace(input)){
            return Stream.of('0','2','%');
        };
        return Stream.of(input);
    }

}
