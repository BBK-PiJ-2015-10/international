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

    private int add(int price, int period, Node node) {
        var leftProfit = 0;
        var rightProfit = 0;
        if (node.left != null || node.right != null) {
            leftProfit = add(price, period, node.left);
            rightProfit = add(price, period, node.right);
        } else {
            leftProfit = takeAction(price, period, node);
            rightProfit = leftProfit;
        }
        if (leftProfit >= rightProfit) {
            return leftProfit;
        } else {
            return rightProfit;
        }
    }

    private int takeAction(int price, int period, Node node) {
        var cumulativeProfit = node.profit;
        switch (node.state) {
            case BUY:
                if (price > node.cost) {
                    // left do nothing, right sell
                    var incProfit = price - node.cost;
                    var newCost = price;
                    var updatedCumProfit = node.profit + incProfit;
                    var leftNode = new Node(node.state,node.period,node.profit,node.cost,null,null);
                    var rightNode = new Node(State.SELL,period,updatedCumProfit,newCost,null,null);
                    node.left = leftNode;
                    node.right = rightNode;
                    cumulativeProfit = updatedCumProfit;
                } else {
                    // do nothing don't add any nodes
                }
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
        return cumulativeProfit;
    }

    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        if (prices.length == 1) {
            return maxProfit;
        }
        var rootNode = new Node(State.NOTHING, 0, 0, 0, null, null);
        for (int i = 0; i < prices.length; i++) {
            var price = prices[i];
            var profit = add(price, i, rootNode);
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }


}
