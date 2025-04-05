package veinteream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchValue {

    public List<Integer> searchValue(List<Integer> numbers, int value) {
        Map<Integer, Integer> positionValues = new HashMap<>();
        positionValues.put(0, 0);
        positionValues.put(1, 0);
        positionValues.put(2, 0);
        positionValues.put(3, 0);
        for (int i = 0; i < numbers.size(); i++) {
            var inPlaceValue = numbers.get(i);
            if (inPlaceValue == value) {
                var isEven = i % 2;
                if (isEven == 0) {
                    positionValues.put(0, 1);
                } else {
                    positionValues.put(1, 1);
                }
                if (i < numbers.size() / 2) {
                    positionValues.put(2, 1);
                } else {
                    positionValues.put(3, 1);
                }
            }
        }
        return positionValues.keySet()
                .stream()
                .sorted()
                .map(k -> positionValues.get(k)).collect(Collectors.toList());
    }

}
