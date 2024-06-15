package codility.doublehanoi;


import java.util.Comparator;
import java.util.TreeSet;


public class DoubleHanoiImpl implements DoubleHanoi {

    Comparator<Disk> leftComparatorDesc = (Disk c1, Disk c2) -> -Integer.compare(c1.size, c2.size);
    Comparator<Disk> rightComparatorAsc = (Disk c1, Disk c2) -> Integer.compare(c1.size, c2.size);

    @Override
    public int maxNumberOfDisk(int[] A, int L, int R) {

        TreeSet<Disk> leftCandidates = new TreeSet<>(leftComparatorDesc);
        TreeSet<Disk> rightCandidates = new TreeSet<>(rightComparatorAsc);

        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < A.length; i++) {
            var disk = new Disk(A[i]);
            if (disk.size < L && disk.size > R) {
                var isAlreadyInLeft = leftCandidates.contains(disk);
                if (isAlreadyInLeft) {
                    rightCandidates.add(disk);
                } else {
                    leftCandidates.add(disk);
                }
            }
            if (disk.size < L) {
                leftCandidates.add(disk);
            } else if (disk.size > R) {
                rightCandidates.add(disk);
            }
        }

        while (!leftCandidates.isEmpty()) {
            leftCandidates.pollFirst();
            leftCount++;
        }
        while (!rightCandidates.isEmpty()) {
            rightCandidates.pollFirst();
            rightCount++;
        }

        return leftCount + rightCount;
    }
}
