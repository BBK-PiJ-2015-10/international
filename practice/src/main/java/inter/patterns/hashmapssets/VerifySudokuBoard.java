package inter.patterns.hashmapssets;

import java.util.*;
import java.util.logging.Logger;

public class VerifySudokuBoard {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private int solveQuandrant(Integer position) {
        return position / 3;
    }

    public boolean isValidSudokoBoard(char[][] board) {
        // length = 9
        Map<Integer, HashSet<Integer>> rows = new HashMap<>();
        Map<Integer, HashSet<Integer>> columns = new HashMap<>();
        Map<Integer, HashSet<Integer>> grid = new HashMap<>();
        int xbase = 0;
        int ybase = 0;
        while (xbase < 7 && ybase < 7) {
            for (int x = xbase; x <= xbase + 2; x++) {
                for (int y = ybase; y <= ybase + 3; y++) {
                    Character charValue = board[x][y];
                    if (Character.isDigit(charValue)) {
                        var value = Integer.valueOf(charValue.toString());
                        logger.info(String.format("Evaluating x %d, y %d with value %d", x, y, value));
                        var existingOnRow = rows.get(x);
                        if (existingOnRow == null) {
                            HashSet<Integer> newExistingRow = new HashSet<>();
                            newExistingRow.add(value);
                            rows.put(x, newExistingRow);
                        } else {
                            if (existingOnRow.contains(value)) {
                                logger.info(String.format("Invalid Sudoko row at x %d y %d with value %d", x, y, value));
                                return false;
                            } else {
                                existingOnRow.add(value);
                            }
                        }
                        var existingOnColumn = columns.get(y);
                        if (existingOnColumn == null) {
                            HashSet<Integer> newExistingColumn = new HashSet<>();
                            newExistingColumn.add(value);
                            rows.put(y, newExistingColumn);
                        } else {
                            if (existingOnColumn.contains(value)) {
                                logger.info(String.format("Invalid Sudoko column at x %d y %d with value %d", x, y, value));
                                return false;
                            } else {
                                existingOnColumn.add(value);
                            }
                        }
                        var quadrant = solveQuandrant(x);
                        var existingQuadrant = grid.get(quadrant);
                        if (existingQuadrant == null) {
                            HashSet<Integer> newExistingQuadrant = new HashSet<>();
                            existingQuadrant.add(value);
                            rows.put(quadrant, newExistingQuadrant);
                        } else {
                            if (existingQuadrant.contains(value)) {
                                logger.info(String.format("Invalid Quadrant at quadrant with value %d", quadrant, value));
                                return false;
                            } else {
                                existingQuadrant.add(value);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokoBoard(int[][] board) {
        // length = 9
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> columns = new HashMap<>();
        Map<Integer, List<Integer>> grid = new HashMap<>();
        int xbase = 0;
        int ybase = 0;
        while (xbase < 7 && ybase < 7) {
            for (int x = xbase; x <= xbase + 2; x++) {
                for (int y = ybase; y <= ybase + 3; y++) {
                    var value = board[x][y];
                    logger.info(String.format("Evaluating x %d, y %d with value %d", x, y, value));
                    var existingOnRow = rows.get(x);
                    if (existingOnRow == null) {
                        List<Integer> newExistingRow = new LinkedList<>();
                        newExistingRow.add(value);
                        rows.put(x, newExistingRow);
                    } else {
                        if (existingOnRow.contains(value)) {
                            logger.info(String.format("Invalid Sudoko row at x %d y %d with value %d", x, y, value));
                            return false;
                        } else {
                            existingOnRow.add(value);
                        }
                    }
                    var existingOnColumn = columns.get(y);
                    if (existingOnColumn == null) {
                        List<Integer> newExistingColumn = new LinkedList<>();
                        newExistingColumn.add(value);
                        rows.put(y, newExistingColumn);
                    } else {
                        if (existingOnColumn.contains(value)) {
                            logger.info(String.format("Invalid Sudoko column at x %d y %d with value %d", x, y, value));
                            return false;
                        } else {
                            existingOnColumn.add(value);
                        }
                    }
                    var quadrant = solveQuandrant(x);
                    var existingQuadrant = grid.get(quadrant);
                    if (existingQuadrant == null) {
                        List<Integer> newExistingQuadrant = new LinkedList<>();
                        existingQuadrant.add(value);
                        rows.put(quadrant, newExistingQuadrant);
                    } else {
                        if (existingQuadrant.contains(value)) {
                            logger.info(String.format("Invalid Quadrant at quadrant with value %d", quadrant, value));
                            return false;
                        } else {
                            existingQuadrant.add(value);
                        }
                    }
                }
            }
        }
        return true;
    }

}
