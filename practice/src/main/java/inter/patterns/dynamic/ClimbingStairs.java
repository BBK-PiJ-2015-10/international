package inter.patterns.dynamic;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public ClimbingStairs() {
    }

    // either one or 2 steps at a time
    public int waysOfClimbingStairs(int height) {
        Map<Integer, Integer> waysOfClimbing = new HashMap<>();
        return waysToClimb(height, waysOfClimbing);
    }

    private int waysToClimb(int level, Map<Integer, Integer> waysOfClimbing) {
        if (level == 1) {
            var existing = waysOfClimbing.get(1);
            if (existing == null) {
                waysOfClimbing.put(1, 1);
            }
            return 1;
        }
        if (level == 2) {
            var existing = waysOfClimbing.get(1);
            if (existing == null) {
                waysOfClimbing.put(2, 2);
            }
            return 2;
        }
        var oneDown = level - 1;
        var twoDown = level - 2;
        if (twoDown > 0) {
            var existing = waysOfClimbing.get(level);
            if (existing == null) {
                var result = waysToClimb(twoDown, waysOfClimbing) + waysToClimb(oneDown, waysOfClimbing);
                waysOfClimbing.put(level, result);
                return result;
            } else {
                return existing;
            }

        } else if (oneDown > 0) {
            var existing = waysOfClimbing.get(level);
            if (existing == null) {
                var result = waysToClimb(oneDown, waysOfClimbing);
                waysOfClimbing.put(level, result);
                return result;
            } else {
                return existing;
            }
        } else {
            return 0;
        }
    }


}
