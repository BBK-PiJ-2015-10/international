package veinteream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComputeHistogram {

    // 9 numbers
    // "1:","2:**"
    public List<String> computeHistogram(List<Integer> sample) {
        Map<Integer, Integer> numbersByFrequency = sample.stream()
                .collect(
                        Collectors.groupingBy(d -> d,
                                Collectors.reducing(0, (a, b) -> a + 1)
                        ));
        List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(n -> {
            if (numbersByFrequency.containsKey(n) == false) {
                numbersByFrequency.put(n, 0);
            }
        });
        return numbersByFrequency.keySet().stream().sorted().map(n ->
                maptoString(n, numbersByFrequency.get(n))
        ).collect(Collectors.toList());
    }

    private String maptoString(Integer number, Integer frequency) {
        if (frequency == 0) {
            return number.toString() + ":";
        } else {
            String result = "";
            for (int i = 1; i <= frequency; i++) {
                result = result + "*";
            }
            return number.toString() + ":" + result;
        }
    }

}
