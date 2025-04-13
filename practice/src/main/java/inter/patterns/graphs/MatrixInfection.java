package inter.patterns.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class MatrixInfection {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public class MatrixPoints {
        int row;
        int column;
        int value;
        Integer infectedSecond = null;

        public MatrixPoints(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        public void setInfected(int infectedSecond) {
            this.value = 2;
            this.infectedSecond = infectedSecond;
        }

        @Override
        public String toString() {
            return "MatrixPoints{" + "row=" + row + ", column=" + column + ", value=" + value + ", infectedSecond=" + infectedSecond + '}';
        }
    }

    public int numberOfSecondsAllInfected(int[][] matrix) {
        int numberOfSeconds = -1;
        int rowLimits = matrix.length;
        int columnLimits = matrix[0].length;
        MatrixPoints[][] infectedMatrix = new MatrixPoints[rowLimits][columnLimits];
        int uninfected = 0;
        Queue<MatrixPoints> unvisitedInfected = new LinkedList<>();
        for (int rowNumber = 0; rowNumber < rowLimits; rowNumber++) {
            for (int columnNumber = 0; columnNumber < columnLimits; columnNumber++) {
                var infectedValue = matrix[rowNumber][columnNumber];
                var matrixPoint = new MatrixPoints(rowNumber, columnNumber, infectedValue);
                //matrixPoint.setInfected(0);
                infectedMatrix[rowNumber][columnNumber] = matrixPoint;
                if (infectedValue == 2) {
                    matrixPoint.setInfected(0);
                    unvisitedInfected.add(matrixPoint);
                    logger.info(String.format("Found infected %s", matrixPoint));
                }
                if (infectedValue == 1) {
                    uninfected++;
                }
            }
        }

        var nextInfectedSecond = 0;
        while (unvisitedInfected.isEmpty() == false) {
            var infected = unvisitedInfected.remove();
            logger.info(String.format("Visiting infected %s at seconds %d", infected, nextInfectedSecond));
            nextInfectedSecond = infected.infectedSecond + 1;
            var infectedRow = infected.row;
            var infectedColumn = infected.column;
            boolean anyInfected = false;
            if (infectedRow - 1 >= 0) {
                var neighbor = infectedMatrix[infectedRow - 1][infectedColumn];
                logger.info(String.format("Visiting row %d column %d with neighbor %s ", infectedRow - 1, infectedColumn, neighbor));
                if (neighbor.value == 1) {
                    neighbor.setInfected(nextInfectedSecond);
                    unvisitedInfected.add(neighbor);
                    uninfected--;
                    anyInfected = true;
                }
            }
            if (infectedRow + 1 < rowLimits) {
                var neighbor = infectedMatrix[infectedRow + 1][infectedColumn];
                logger.info(String.format("Visiting row %d column %d with neighbor %s", infectedRow + 1, infectedColumn, neighbor));
                if (neighbor.value == 1) {
                    neighbor.setInfected(nextInfectedSecond);
                    unvisitedInfected.add(neighbor);
                    uninfected--;
                    anyInfected = true;
                }
            }
            if (infectedColumn - 1 >= 0) {
                var neighbor = infectedMatrix[infectedRow][infectedColumn - 1];
                logger.info(String.format("Visiting row %d column %d with neighbor %s", infectedRow, infectedColumn - 1, neighbor));

                if (neighbor.value == 1) {
                    neighbor.setInfected(nextInfectedSecond);
                    unvisitedInfected.add(neighbor);
                    uninfected--;
                    anyInfected = true;
                }
            }
            if (infectedColumn + 1 < columnLimits) {
                var neighbor = infectedMatrix[infectedRow][infectedColumn + 1];
                logger.info(String.format("Visiting row %d column %d with neighbor %s", infectedRow, infectedColumn + 1, neighbor));

                if (neighbor.value == 1) {
                    neighbor.setInfected(nextInfectedSecond);
                    unvisitedInfected.add(neighbor);
                    uninfected--;
                    anyInfected = true;
                }
            }
            if (anyInfected == false) {
                nextInfectedSecond--;
            }
        }
        if (uninfected == 0) {
            numberOfSeconds = nextInfectedSecond;
            logger.info(String.format("Uninfected count is %d, and nextInfectedSecond is %d", uninfected, nextInfectedSecond));
        } else {
            logger.info(String.format("Woof Uninfected count is %d, and seconds is %d", uninfected, nextInfectedSecond));
        }
        return numberOfSeconds;
    }
}
