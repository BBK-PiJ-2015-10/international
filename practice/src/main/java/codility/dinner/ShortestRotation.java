package codility.dinner;


//https://app.codility.com/programmers/task/dinner/

public class ShortestRotation {


    public int solution(int[] A, int[] B) {
        return compareHelper(A,B,0);
    }

    private int compareHelper(int[] A, int[] B, int rotation) {
        // we reached the end
        boolean satisfied = true;
        if (Math.abs(rotation) >= A.length) {
            return -1;
        } else {
            for (int i = 0; i < A.length; i++) {
                var b = bPosition(i, rotation, A.length);
                if (A[i] == B[b]) {
                    satisfied = false;
                }
            }
            if (satisfied) {
                return rotation;
            } else {
                compareHelper(A, B, rotation - 1);
            }
        }
        return -1;
    }

    private int bPosition(int positionA, int rotation, int n) {
        var baseBPosition = positionA - rotation;
        if (baseBPosition < 0) {
            return n - baseBPosition;
        }
        return baseBPosition;
    }
}
