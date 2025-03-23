package inter.patterns.graphs;

import java.util.List;

public class CountIslands {

    public int countIslands(int[][] matrix) {
        int islands = 0;
        for (int rowCount = 0; rowCount < matrix.length; rowCount++) {
            int[] row = matrix[rowCount];
            for (int columnCount = 0; columnCount < row.length; rowCount++) {
                var cell = matrix[rowCount][columnCount];
                if (cell == 1) {
                    evaluateCell(rowCount, columnCount, matrix);
                    islands ++;
                }
            }
        }
        return islands;
    }

    private void evaluateCell(int row, int column, int[][] matrix) {
        matrix[row][column] = -1;
    }

}
