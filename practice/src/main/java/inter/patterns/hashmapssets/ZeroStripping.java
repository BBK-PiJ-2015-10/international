package inter.patterns.hashmapssets;

import jdk.jfr.consumer.RecordedStackTrace;

import java.util.*;
import java.util.logging.Logger;

public class ZeroStripping {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int[][] zeroStripping2N2(int[][] input) {
        Set<Integer> rowsToStrip = new HashSet<>();
        Set<Integer> columnsToStrip = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            var column = input[i];
            for (int k = 0; k < column.length; k++) {
                var rc = column[k];
                if (rc == 0) {
                    rowsToStrip.add(i);
                    columnsToStrip.add(k);
                    logger.info(String.format("Need to strip row %d column %d", i, k));
                }
            }
        }
        for (int r = 0; r < input.length; r++) {
            var column = input[r];
            for (int c = 0; c < column.length; c++) {
                if (rowsToStrip.contains(r) || columnsToStrip.contains(c)) {
                    column[c] = 0;
                }
            }
        }
        return input;
    }
}
