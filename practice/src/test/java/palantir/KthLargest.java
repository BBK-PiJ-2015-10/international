package palantir;

public class KthLargest {

    public int kthLargest(int k, int[] array) {
        var set = new CustomSortedTreeSet(k);
        for (int i = 0; i < array.length; i++) {
            var elementValue = array[i];
            set.add(elementValue);
        }
        return se
    }



}
