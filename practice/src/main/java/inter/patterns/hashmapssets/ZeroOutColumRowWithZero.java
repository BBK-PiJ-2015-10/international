package inter.patterns.hashmapssets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ZeroOutColumRowWithZero {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int[][] zeroOut(int[][] input) {
        int rows = input.length;
        int columns = input[0].length;
        Set<Integer> rowsWithZero = new HashSet<>();
        Set<Integer> columnsWithZero = new HashSet<>();
        logger.info(String.format("Rows are %d and columns are %d", rows, columns));
        for (int r = 0; r < rows; r++) {
            int[] row = input[r];
            for (int c = 0; c < columns; c++) {
                int value = row[c];
                if (value == 0) {
                    logger.info(String.format("Found a zero at row %d and columns %d", r, c));
                    rowsWithZero.add(r);
                    columnsWithZero.add(c);
                }
            }
        }
        if ((rowsWithZero.size() * columnsWithZero.size()) > 0) {
            int[] zeroRow = new int[columns];
            Arrays.fill(zeroRow, 0);
            for (int r = 0; r < rows; r++) {
                if (rowsWithZero.remove(r)) {
                    input[r] = zeroRow;
                    logger.info(String.format("Making zero row %d", r));
                } else {
                    int[] row = input[r];
                    for (int c = 0; c < columns; c++) {
                        if (columnsWithZero.contains(c)) {
                            row[c] = 0;
                            logger.info(String.format("Zeroing cell at r %d c %d", r, c));
                        }
                    }
                }
            }
        }
        return input;
    }

}
