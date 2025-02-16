package inter.patterns.twopointers;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TipletSum {

    Logger logger = Logger.getLogger("TipleSum");

    public List<List<Integer>> findAllTripletSumToZero(int[] input) {
        return null;
    }

    public List<List<Integer>> findAllTripletSumToZeroBrutal(int[] input) {
        Set<List<Integer>> solutions = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int k = i + 1; k < input.length; k++) {
                for (int l = k + 1; l < input.length; l++) {
                    logger.info(String.format("Visiting i %d with and k %d and l %d", i, k, l));
                    int sum = input[i] + input[k] + input[l];
                    if (sum == 0) {
                        var solution = Stream.of(input[i], input[k], input[l]).sorted().collect(Collectors.toList());
                        solutions.add(solution);
                    }
                }
            }
        }
        return solutions.stream().toList();
    }


}
