package inter.patterns.dynamic;

public class MatrixPathways {

    public int getMatrixPathWays(int rows, int columns){
        var uniquePaths = new int[rows][columns];
        for (int c=0;c<columns;c++){
            uniquePaths[0][c]=1;
        }
        for (int r=0;r<rows;r++) {
            uniquePaths[r][0] = 1;
        }
        for (int r=1;r<rows;r++) {
            for (int c=1;c<columns;c++){
                uniquePaths[r][c] = uniquePaths[r-1][c] + uniquePaths[r][c-1];
            }
        }
        var result = uniquePaths[rows-1][columns-1];
        return result;
    }
}
