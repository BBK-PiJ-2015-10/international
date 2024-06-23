package codility.dinner;


//https://app.codility.com/programmers/task/dinner/

public class ShortestRotation {


    public int solution(int[] A, int[] B) {
        return compareHelper(A, B);
    }

    private boolean areAllSatisfied(int[] A, int[] B, int rotation) {
        for (int i = 0; i < A.length; i++) {
            var b = bPosition(i, rotation, A.length);
            if (A[i] == B[b]) {
                System.out.println("Dissatisfied on rotation " + rotation + " position A: " + i + "position B: " + b);
                return false;
            }
        }
        System.out.println("Satisfied on rotation" + rotation);
        return true;
    }

    private int compareHelper(int[] A, int[] B) {
        // we reached the end
        int rotation = 0;
        Boolean satisfied = false;
        while (!satisfied && Math.abs(rotation) < A.length + 1) {
            satisfied = areAllSatisfied(A, B, rotation);
            if (!satisfied) {
                System.out.println("Not yet satisfied at rotation " + rotation);
                rotation--;
            }
        }
        if (satisfied) {
            System.out.println("Found satisfaction at rotation " + Math.abs(rotation));
            return Math.abs(rotation);
        } else {
            return -1;
        }
    }

    private int bPosition(int positionA, int rotation, int n) {
        var baseBPosition = positionA + rotation;
        if (baseBPosition < 0) {
            return n + baseBPosition;
        }
        return baseBPosition;
    }
}
