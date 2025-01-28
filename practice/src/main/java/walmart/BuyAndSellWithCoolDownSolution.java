package walmart;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


//https://medium.com/@techiecontent/walmart-interview-experience-sde-iii-6f05a1fda937
public class BuyAndSellWithCoolDownSolution {

    private Logger logger = Logger.getLogger("BuyAndSellApp");

    public BuyAndSellWithCoolDownSolution() {
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

        public Node(State state, int day, int profit, int cost) {
            this.state = state;
            this.day = day;
            this.cost = cost;
            this.profit = profit;
        }
    }

    private int takeAction(int price, int day, Node node, List<Node> newNodes) {
        var cumulativeProfit = node.profit;
        switch (node.state) {
            case BUY:
                if (price > node.cost) {
                    // left do nothing, right sell
                    var incProfit = price - node.cost;
                    var newCost = price;
                    var updatedCumProfit = node.profit + incProfit;
                    var leftNode = new Node(node.state, node.day, node.profit, node.cost);
                    var rightNode = new Node(State.SELL, day, updatedCumProfit, newCost);
                    newNodes.add(leftNode);
                    newNodes.add(rightNode);
                    cumulativeProfit = updatedCumProfit;
                } else {
                    // state does not change. add left/right reflecting that
                    cumulativeProfit = node.profit;
                    newNodes.add(node);
                }
                break;
            case SELL:
                var timeSinceSold = day - node.day;
                if (timeSinceSold > 1) {
                    // left do nothing, right buy
                    var newCost = price;
                    var leftNode = new Node(node.state, node.day, node.profit, node.cost);
                    var rightNode = new Node(State.BUY, day, node.profit, newCost);
                    cumulativeProfit = node.profit;
                    newNodes.add(leftNode);
                    newNodes.add(rightNode);
                } else {
                    // state does not change. add left/right reflecting that
                    newNodes.add(node);
                    cumulativeProfit = node.profit;
                }
                break;
            case NOTHING:
                // left do nothing right buy
                var newCost = price;
                // var leftNode = new Node(node.state, node.day, node.profit, node.cost);
                var rightNode = new Node(State.BUY, day, node.profit, newCost);
                cumulativeProfit = node.profit;
                newNodes.add(node);
                newNodes.add(rightNode);
                break;
        }
        return cumulativeProfit;
    }

    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        if (prices.length == 1) {
            return maxProfit;
        }
        var rootNode = new Node(State.NOTHING, 0, 0, 0);
        List<Node> existingNodes = new LinkedList<>();
        List<Node> newNodes = new LinkedList<>();
        existingNodes.add(rootNode);
        for (int i = 0; i < prices.length; i++) {
            var price = prices[i];
            var day = i + 1;
            logger.info(String.format("On day %d, existingNodes is size %d and newNodes is size %d", day, existingNodes.size(), newNodes.size()));
            for (Node existingNode : existingNodes) {
                var profit = takeAction(price, day, existingNode, newNodes);
                if (profit > maxProfit) {
                    maxProfit = profit;
                    logger.info(String.format("MaxProfit update to %d on day %d", maxProfit, day));
                }
            }
            existingNodes = newNodes;
            newNodes = new LinkedList<>();
        }
        return maxProfit;
    }


}
