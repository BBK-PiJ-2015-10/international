package codility.zal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixOptimizerImpl implements MatrixPathOptimizer {

    class Node {

        int rowPosition;
        int columnPosition;
        int number;
        List<Node> pathToNode = new LinkedList<>();
        int totalNumber;

        public Node(int rowPosition, int columnPosition, int number) {
            this.rowPosition = rowPosition;
            this.columnPosition = columnPosition;
            this.number = number;
            this.totalNumber = number;
        }

        public int getRowPosition() {
            return rowPosition;
        }

        public int getColumnPosition() {
            return columnPosition;
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
    }

    public MatrixOptimizerImpl() {

    }

    @Override
    public String findHighestPath(int[][] matrix) {

        var length = matrix.length;
        var height = matrix[0].length;

        var maxRow = length - 1;
        var maxColumn = 0;


        Queue<Node> nodeTracker = new LinkedList<>();
        var originNode = new Node(0, height - 1, matrix[0][height - 1]);
        nodeTracker.add(originNode);
        var maxValue = originNode.totalNumber;

        while (!nodeTracker.isEmpty()) {
            var node = nodeTracker.poll();

        }
        

        return "";
    }
}
