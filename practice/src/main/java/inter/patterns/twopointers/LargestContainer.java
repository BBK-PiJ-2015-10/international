package inter.patterns.twopointers;

public class LargestContainer {

    public int largestContainer(int[] bars) {
        int largest = 0;
        for (int i = 0; i < bars.length - 1; i++) {
            for (int k = i + 1; k < bars.length; k++) {
                var width = k - i;
                var height = Math.min(bars[i], bars[k]);
                var volume = width * height;
                if (volume > largest) {
                    largest = volume;
                }
            }
        }
        return largest;
    }

}
