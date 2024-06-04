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

        public int getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(int newNumber) {
            String newNumberString = String.valueOf(newNumber);
            String existingNumberString = String.valueOf(totalNumber);
            String updatedTotalNumberString =  newNumberString +existingNumberString;
            this.totalNumber = Integer.valueOf(updatedTotalNumberString);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "xPosition=" + xPosition +
                    ", yPosition=" + yPosition +
                    ", number=" + number +
                    ", totalNumber=" + totalNumber +
                    '}';
        }
    }

    public MatrixOptimizerImpl() {

    }

    @Override
    public String findHighestPath(int[][] matrix) {

        logger.error("Starting dod");

        var height = matrix.length;
        var length = matrix[0].length;

        logger.error("length = {}", length);
        logger.error("height = {}", height);

        var maxXPos = length - 1;
        var maxYPos = height-1;

        System.out.println("FUCKER");
        //var cat = matrix[0][1];
        //this is right = matrix[0][1]; 2 => row 0, column 2
        // this is Y or down  matrix[1][0];
        var cat = matrix[1][0];
        System.out.println(cat);


        Queue<Node> nodeTracker = new LinkedList<>();
        var originNode = new Node(0, 0, matrix[0][0]);
        nodeTracker.add(originNode);
        var maxValue = originNode.totalNumber;
        var maxNode = originNode;

        while (!nodeTracker.isEmpty()) {
            var node = nodeTracker.poll();
            logger.error("Polling node: {}", node);
            var downYPos = node.yPosition + 1;
            var rightXPos = node.xPosition + 1;
            if (rightXPos <= maxXPos) {
                var rightNode = new Node(rightXPos, node.yPosition, matrix[node.yPosition][rightXPos]);
                rightNode.setTotalNumber(node.totalNumber);
                if (rightNode.getTotalNumber() >= maxValue) {
                    maxValue = rightNode.getTotalNumber();
                    nodeTracker.add(rightNode);
                    maxNode = rightNode;
                    logger.error("Adding right node: {}", rightNode);
                }
            }
            if (downYPos <= maxYPos) {
                var downNode = new Node(node.xPosition, downYPos, matrix[downYPos][node.xPosition]);
                downNode.setTotalNumber(node.totalNumber);
                if (downNode.getTotalNumber() >= maxValue) {
                    maxValue = downNode.getTotalNumber();
                    nodeTracker.add(downNode);
                    maxNode = downNode;
                    logger.error("Adding down node: {}", downNode);
                }
            }
        }
        return String.valueOf(maxValue);
    }
}
