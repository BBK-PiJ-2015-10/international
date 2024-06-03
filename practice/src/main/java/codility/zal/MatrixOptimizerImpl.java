package codility.zal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatrixOptimizerImpl implements MatrixPathOptimizer {

    Logger logger  = LoggerFactory.getLogger(this.getClass());

    class Node {

        int xPosition;
        int yPosition;
        int number;
        List<Node> pathToNode = new LinkedList<>();
        int totalNumber;

        public Node(int xPosition, int yPosition, int number) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.number = number;
            this.totalNumber = number;
        }

        public int getxPosition() {
            return xPosition;
        }

        public int getyPosition() {
            return yPosition;
        }

        public int getNumber() {
            return number;
        }

        public List<Node> getPathToNode() {
            return pathToNode;
        }

        public int getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(int totalNumber) {
            this.totalNumber = totalNumber;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "xPosition=" + xPosition +
                    ", yPosition=" + yPosition +
                    ", number=" + number +
                    ", pathToNode=" + pathToNode +
                    ", totalNumber=" + totalNumber +
                    '}';
        }
    }

    public MatrixOptimizerImpl() {

    }

    @Override
    public String findHighestPath(int[][] matrix) {

        var length = matrix.length;
        var height = matrix[0].length;

        var maxXPos = length - 1;
        var minYPos = 0;


        Queue<Node> nodeTracker = new LinkedList<>();
        var originNode = new Node(0, height - 1, matrix[0][height - 1]);
        nodeTracker.add(originNode);
        var maxValue = originNode.totalNumber;
        var maxNode = originNode;

        while (!nodeTracker.isEmpty()) {
            var node = nodeTracker.poll();
            logger.info("Polling node: {}", node);
            var downYPos = node.yPosition - 1;
            var rightXPos = node.xPosition + 1;
            if (rightXPos <= maxXPos) {
                var rightNode = new Node(rightXPos, node.yPosition, matrix[rightXPos][node.yPosition]);
                rightNode.setTotalNumber(rightNode.totalNumber + node.totalNumber);
                if (rightNode.getTotalNumber() >= maxValue) {
                    maxValue = rightNode.getTotalNumber();
                    rightNode.pathToNode.add(node);
                    nodeTracker.add(rightNode);
                    maxNode = rightNode;
                    logger.info("Adding right node: {}", rightNode);
                }
            }
            if (downYPos >= minYPos) {
                var downNode = new Node(node.xPosition, downYPos, matrix[node.xPosition][downYPos]);
                downNode.setTotalNumber(downNode.totalNumber + node.totalNumber);
                if (downNode.getTotalNumber() >= maxValue) {
                    maxValue = downNode.getTotalNumber();
                    downNode.pathToNode.add(node);
                    nodeTracker.add(downNode);
                    maxNode = downNode;
                    logger.info("Adding down node: {}", downNode);
                }
            }
        }
        return String.valueOf(maxValue);
    }
}
