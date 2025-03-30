package veinteream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReorderStringBasedOnPosition {

    public String reorder(String text, List<Integer> indexes) {
        var characters = text.toCharArray();
        Character[] response = new Character[text.length()];
        for (int i = 0; i < indexes.size(); i++) {
            var character = characters[i];
            var newPosition = indexes.get(i);
            response[newPosition - 1] = character;
        }
        return Arrays.stream(response).map(String::valueOf).collect(Collectors.joining());
    }


}
