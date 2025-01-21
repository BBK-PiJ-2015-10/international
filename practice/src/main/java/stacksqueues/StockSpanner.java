package stacksqueues;

import java.util.Stack;

public class StockSpanner {

    private Stack<Integer> pricesStack = new Stack<>();

    private Stack<Integer> removedPrices = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
        var span = 1;
        while (pricesStack.isEmpty() == false && pricesStack.peek() < price) {
            var priceRemoved = pricesStack.pop();
            removedPrices.push(priceRemoved);
            span++;
        }
        while (removedPrices.isEmpty() == false) {
            pricesStack.push(removedPrices.pop());
        }
        pricesStack.push(price);
        return span;
    }
}
