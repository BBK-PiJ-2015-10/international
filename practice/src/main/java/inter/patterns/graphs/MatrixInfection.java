package inter.patterns.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixInfection {

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
    }

    public int numberOfSecondsAllInfected(int[][] matrix) {
        int numberOfSeconds = -1;
        int rowLimits = matrix.length;
        int columnLimits = matrix[0].length;
        MatrixPoints[][] infectedMatrix = new MatrixPoints[rowLimits][columnLimits];
        int uninfected = 0;
        int seconds = 0;
        int maxSeconds = 0;
        //HashSet<MatrixPoints> visitedInfected = new HashSet<>();
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
                }
                if (infectedValue == 1) {
                    uninfected++;
                }
            }
        }
        while (unvisitedInfected.isEmpty() == false && maxSeconds <= uninfected) {
            var infected = unvisitedInfected.remove();
            if (maxSeconds == 0 || infected.infectedSecond < seconds) {
                seconds++;
                maxSeconds++;
            }
            //visitedInfected.add(infected);
            var infectedRow = infected.row;
            var infectedColumn = infected.column;
            // evaluate infectedColumn with row-1
            if (infectedRow - 1 >= 0) {
                var neighbor = infectedMatrix[infectedRow - 1][infectedColumn];
                if (neighbor.value == 1) {
                    var matrixPoint = new MatrixPoints(infectedRow - 1, infectedColumn, 2);
                    matrixPoint.setInfected(seconds);
                    unvisitedInfected.add(matrixPoint);
                }
            }
            if (infectedRow + 1 < rowLimits) {
                var neighbor = infectedMatrix[infectedRow + 1][infectedColumn];
                if (neighbor.value == 1) {
                    var matrixPoint = new MatrixPoints(infectedRow + 1, infectedColumn, 2);
                    matrixPoint.setInfected(seconds);
                    unvisitedInfected.add(matrixPoint);
                }
            }
            if (infectedColumn - 1 >= 0) {
                var neighbor = infectedMatrix[infectedRow][infectedColumn - 1];
                if (neighbor.value == 1) {
                    var matrixPoint = new MatrixPoints(infectedRow, infectedColumn - 1, 2);
                    matrixPoint.setInfected(seconds);
                    unvisitedInfected.add(matrixPoint);
                }
            }
            if (infectedColumn + 1 < columnLimits) {
                var neighbor = infectedMatrix[infectedRow][infectedColumn+1];
                if (neighbor.value == 1) {
                    var matrixPoint = new MatrixPoints(infectedRow, infectedColumn + 1, 2);
                    matrixPoint.setInfected(seconds);
                    unvisitedInfected.add(matrixPoint);
                }
            }
        }


        if (uninfected == 0) {
            numberOfSeconds = seconds;
        }
        return numberOfSeconds;
    }
}
