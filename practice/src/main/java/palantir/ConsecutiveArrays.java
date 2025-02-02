package palantir;

public class ConsecutiveArrays {

    public ConsecutiveArrays() {
    }

    public int longestConsecutive(int[] input) {
        int maxConsecutiveArraySize = 0;
        if (input.length <= 1) {
            return maxConsecutiveArraySize;
        } else {
            return maxArraySizeHelper(maxConsecutiveArraySize, 0, 0, input);
        }
    }


    public int maxArraySizeHelper(int maxArrayToDate, int maxCurrentSubarray, int position, int[] array) {
        if (position <= array.length - 2) {
            var nextPosition = position + 1;
            var next = array[nextPosition];
            var current = array[position];
            if (next == current + 1) {
                var updatedMaxCurrentSubarray = maxCurrentSubarray + 1;
                var updatedMaxArrayToDate = maxArrayToDate;
                if (updatedMaxCurrentSubarray > maxArrayToDate) {
                    updatedMaxArrayToDate = updatedMaxCurrentSubarray;
                }
                return maxArraySizeHelper(updatedMaxArrayToDate, updatedMaxCurrentSubarray, position + 1, array);
            } else {
                return maxArraySizeHelper(maxArrayToDate, maxCurrentSubarray, position + 1, array);
            }
        } else {
            if (maxArrayToDate!=0){
                var updatedMaxCurrentSubarray = maxCurrentSubarray + 1;
                var updatedMaxArrayToDate = maxArrayToDate;
                if (updatedMaxCurrentSubarray > maxArrayToDate) {
                    updatedMaxArrayToDate = updatedMaxCurrentSubarray;
                }
                return updatedMaxArrayToDate;
            }
            return maxArrayToDate;
        }
    }


}
