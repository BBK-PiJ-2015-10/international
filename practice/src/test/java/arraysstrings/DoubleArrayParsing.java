package arraysstrings;

import org.junit.Test;

public class DoubleArrayParsing {

    public record FourPrices(String price1, String price2, String price3, String price4) {
    }

    public record FivePrices(String price1, String price2, String price3, String price4, String price5) {
    }

    @Test
    public void test1(){

        String[][] prices = {
                {"0","1","2","3","4"},
                {"5","6","7","9"},
                {"10","11","12","13","14"}
        };

        // number of rows is the length of the array

        var numberOfRows = prices.length;

        for (int i = 0; i < numberOfRows; i++) {
            var priceSize  = prices[i].length;
            System.out.println(priceSize);
            if (priceSize == 4) {
                var fourPrices = new FourPrices(prices[i][0], prices[i][1], prices[i][2], prices[i][3]);
                System.out.println(fourPrices);
            } else if (priceSize == 5) {
                var fivePrices = new FivePrices(prices[i][0], prices[i][1], prices[i][2], prices[i][3], prices[i][4]);
                System.out.println(fivePrices);
            }
        }
        
    }

}
