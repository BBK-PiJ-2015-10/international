package stacksqueues;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StockSpannerTest {

    private StockSpanner stockSpan = new StockSpanner();


    @Test
    public void test1() {

        String[][] input = {
                {"100", "80", "60", "70", "60", "75", "85"},
                {"1", "1", "1", "2", "1", "4", "6"}
        };

        List<Integer> inputPrices = new LinkedList<>();
        List<Integer> expectedOutput = new LinkedList<>();

        var numberOfRows = input.length;
        for (int i = 0; i < numberOfRows; i++) {
            String[] inputStrings = input[i];
            if (i == 0) {
                inputPrices = Stream.of(inputStrings).map(Integer::parseInt).collect(Collectors.toList());
            } else if (i == 1) {
                expectedOutput = Stream.of(inputStrings).map(Integer::parseInt).collect(Collectors.toList());
            } else {
                System.out.println("Invalid input");
            }
            ;
        }

        for (int i = 0; i < inputPrices.size(); i++) {
            int expectedResult = expectedOutput.get(i);
            var result = stockSpan.next(inputPrices.get(i));
            Assert.assertEquals(expectedResult, result);
        }


    }
}
