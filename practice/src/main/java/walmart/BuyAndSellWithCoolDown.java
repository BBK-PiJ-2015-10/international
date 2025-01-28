package walmart;

public class BuyAndSellWithCoolDown {

    enum State {
        BUY,
        SELL,
        NOTHING
    }

    class Node {
        public State state;
        public int period;
        public int profit;
        public int cost;
        public Node left;
        public Node right;

        public Node(State state, int period, int profit, int cost, Node left, Node right) {
            this.state = state;
            this.period = period;
            this.cost = cost;
            this.profit = profit;
            this.left = left;
            this.right = right;
        }
    }

    private int add(int price, Node node) {
        var profit = 0;
        // evaluate left


        // evaluate right
        return profit;
    }

    private int takeAction(int price, int period, Node node) {
        var profit = 0;
        Node decision = null;
        var existingProfit = node.profit;
        var existingCost = node.cost;
        switch (node.state) {
            case BUY:
                System.out.println("WOOF");
                //var incProfit = p
                // you can sell
                //decision = new Node(State.SELL,
                //      )

                // you can hold
                break;
            case SELL:
                System.out.println("WOOF");
                // you can buy if no freezing
                // you can hold
                break;
            case NOTHING:
                System.out.println("WOOF");
                // you can buy
                // you can nothing
                break;
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        if (prices.length == 1) {
            return maxProfit;
        }
        var rootNode = new Node(State.NOTHING, 0, 0, 0, null, null);
        for (int price : prices) {
            var profit = add(price, rootNode);
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }


}
