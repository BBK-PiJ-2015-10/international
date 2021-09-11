package stacksqueues;

import java.util.Stack;

public class StockSpan {

    Integer[] spanResults;

    Stack<Integer> dayStack = new Stack<>();

    public Integer[] calculateSpan(Integer[] stockPrices) {
        spanResults = new Integer[stockPrices.length];
        spanResults[0] = 1;
        dayStack.push(0);

        for (int i = 1; i < stockPrices.length; i++) {
            while (!dayStack.isEmpty() && stockPrices[i] > stockPrices[dayStack.peek()]){
                dayStack.pop();
            }

            if (dayStack.isEmpty()){
                spanResults[i] = i + 1;
            } else {
                spanResults[i] =  i - dayStack.peek();
            }

            dayStack.push(i);

        }

        return spanResults;
    }
}
