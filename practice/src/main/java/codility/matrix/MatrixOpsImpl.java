package codility.matrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixOpsImpl implements MatrixOps {

    public MatrixOpsImpl() {
    }

    @Override
    public int minTrailingZeros(int[][] A) {
        var xLenght = A.length;
        var yLenght = A[0].length;
        System.out.println("X goes to " + xLenght);
        System.out.println("Y goes to  " + yLenght);
        var originValue = A[0][0];
        var originPoint = new Point(0, 0, originValue);
        Queue<Point> queue = new LinkedList<>();
        queue.offer(originPoint);
        List<Point> solutions = new LinkedList<>();
        while (!queue.isEmpty()) {
            var point = queue.poll();
            //System.out.println("Polling point: " + point);
            var x = point.x;
            var y = point.y;
            if (x <= xLenght - 1 && y <= yLenght - 1) {
                // look for right
                var xRight = x + 1;
                if (xRight <= xLenght - 1) {
                    var rightValue = A[y][xRight];
                    var rightPoint = new Point(y, xRight, rightValue * point.value);
                    if (rightPoint.x == xLenght - 1 && rightPoint.y == yLenght - 1) {
                        solutions.add(rightPoint);
                        //System.out.println("Adding to Solution down: " + rightPoint);
                    } else {
                        queue.offer(rightPoint);
                        //System.out.println("Offering right point: " + rightPoint);
                    }
                }
                // look for down
                var yDown = y + 1;
                if (yDown <= yLenght - 1) {
                    var downValue = A[yDown][x];
                    var downPoint = new Point(yDown, x, downValue * point.value);
                    if (downPoint.x == xLenght - 1 && downPoint.y == yLenght - 1) {
                        solutions.add(downPoint);
                        // System.out.println("Adding to Solution right: " + downPoint);
                    } else {
                        queue.offer(downPoint);
                        // System.out.println("Offering right point: " + downPoint);
                    }
                }
            }
        }
        return solutions.stream().map(v -> helperTrailingZeros(v.value)).min(Integer::compareTo).get();
    }


    private int helperTrailingZeros(int number) {
        //System.out.println("Evaluating " + number);
        int zeroes = 0;
        while (number % 10 == 0) {
            zeroes++;
            if (number != 0) {
                number = number / 10;
            } else {
                return zeroes;
            }
        }
        return zeroes;
    }


}
