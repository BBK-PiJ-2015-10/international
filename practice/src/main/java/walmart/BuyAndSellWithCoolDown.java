package walmart;

import java.util.logging.Logger;


//https://medium.com/@techiecontent/walmart-interview-experience-sde-iii-6f05a1fda937
public class BuyAndSellWithCoolDown {

    private Logger logger = Logger.getLogger("BuyAndSellApp");

    public BuyAndSellWithCoolDown() {
    }

    enum State {
        BUY,
        SELL,
        NOTHING
    }

    class Node {
        public State state;
        public int day;
        public int profit;
        public int cost;
        public Node left;
        public Node right;

        public Node(State state, int day, int profit, int cost, Node left, Node right) {
            this.state = state;
            this.day = day;
            this.cost = cost;
            this.profit = profit;
            this.left = left;
            this.right = right;
        }
    }

    private int add(int price, int day, Node node) {
        var leftProfit = 0;
        var rightProfit = 0;
        if (node.left != null || node.right != null) {
            leftProfit = add(price, day, node.left);
            rightProfit = add(price, day, node.right);
        } else {
            leftProfit = takeAction(price, day, node);
            rightProfit = leftProfit;
        }
        if (leftProfit >= rightProfit) {
            return leftProfit;
        } else {
            return rightProfit;
        }
    }

    private int takeAction(int price, int day, Node node) {
        var cumulativeProfit = node.profit;
        switch (node.state) {
            case BUY:
                if (price > node.cost) {
                    // left do nothing, right sell
                    var incProfit = price - node.cost;
                    var newCost = price;
                    var updatedCumProfit = node.profit + incProfit;
                    var leftNode = new Node(node.state, node.day, node.profit, node.cost, null, null);
                    var rightNode = new Node(State.SELL, day, updatedCumProfit, newCost, null, null);
                    node.left = leftNode;
                    node.right = rightNode;
                    cumulativeProfit = updatedCumProfit;
                } else {
                    // state does not change. add left/right reflecting that
                    var leftNode = new Node(node.state, node.day, node.profit, node.cost, null, null);
                    var rightNode = new Node(node.state, node.day, node.profit, node.cost, null, null);
                    node.left = leftNode;
                    node.right = rightNode;
                    cumulativeProfit = node.profit;
                }
                break;
            case SELL:
                var timeSinceSold = day - node.day;
                if (timeSinceSold > 1) {
                    // left do nothing, right buy
                    var newCost = price;
                    var leftNode = new Node(node.state, node.day, node.profit, node.cost, null, null);
                    var rightNode = new Node(State.BUY, day, node.profit, newCost, null, null);
                    node.left = leftNode;
                    node.right = rightNode;
                    cumulativeProfit = node.profit;
                } else {
                    // state does not change. add left/right reflecting that
                    var leftNode = new Node(node.state, node.day, node.profit, node.cost, null, null);
                    var rightNode = new Node(node.state, node.day, node.profit, node.cost, null, null);
                    node.left = leftNode;
                    node.right = rightNode;
                    cumulativeProfit = node.profit;
                }
                break;
            case NOTHING:
                // left do nothing right buy
                var newCost = price;
                var leftNode = new Node(node.state, node.day, node.profit, node.cost, null, null);
                var rightNode = new Node(State.BUY, day, node.profit, newCost, null, null);
                node.left = leftNode;
                node.right = rightNode;
                cumulativeProfit = node.profit;
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
            var day = i + 1;
            var profit = add(price,day, rootNode);
            if (profit > maxProfit) {
                maxProfit = profit;
                logger.info(String.format("MaxProfit update to %d on day %d",maxProfit,day));
            }
        }
        return maxProfit;
    }


}
