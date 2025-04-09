package inter.patterns.twopointers;

public class LargestContainer {

    public int largestContainerBrutal(int[] bars) {
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

    public int largestContainer(int[] bars) {
        int maxVolume = 0;
        int l = 0;
        int r = bars.length - 1;
        while (l < r) {
            int width = r - l;
            int leftHeight = bars[l];
            int rightHeight = bars[r];
            int height = Math.min(leftHeight, rightHeight);
            int volume = width * height;
            if (volume > maxVolume) {
                maxVolume = volume;
            }
            if (leftHeight == rightHeight) {
                ++l;
                --r;
            }
            if (leftHeight < rightHeight) {
                ++l;
            } else {
                --r;
            }
        }
        return maxVolume;
    }

}
