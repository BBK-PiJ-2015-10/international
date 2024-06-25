package codility.tricolortower;

import java.util.*;
import java.util.stream.Collectors;

//Year of the Tiger
public class TriColorTowersAnalyzer {

    public int maxNumberOfTowersSameColorOrder(String[] T) {
        Map<String, Integer> colorsCount = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            var tower = T[i];
            var colors = tower.chars().mapToObj(e -> (char) e)
                    .map(c -> c.toString())
                    .collect(Collectors.toList());
            Set<String> colorsSet = new HashSet<>();
            var towerSwap102 = colors.get(1) + colors.get(0) + colors.get(2);
            var towerSwap021 = colors.get(0) + colors.get(2) + colors.get(1);
            colorsSet.add(tower);
            colorsSet.add(towerSwap102);
            colorsSet.add(towerSwap021);
            for (String color : colorsSet) {
                colorsCount.put(color, colorsCount.getOrDefault(color, 0) + 1);
            }
        }
        var maxCommonColors = colorsCount.entrySet().stream().max(Map.Entry.comparingByValue());
        var maxColor = maxCommonColors.get();
        //System.out.println("Max color is " + maxColor.getKey() + " with count" + maxColor.getValue());
        return maxColor.getValue();
    }

    public int maxNumberOfTowersSameColorOrderFaster(String[] T) {
        Map<String, Integer> colorsCountOriginal = new HashMap<>();
        Arrays.stream(T).forEach(tower -> colorsCountOriginal.put(tower, colorsCountOriginal.getOrDefault(tower, 0) + 1));
        Map<String, Integer> colorsCount = new HashMap<>();
        for (Map.Entry<String, Integer> pair : colorsCountOriginal.entrySet()) {
            var tower = pair.getKey();
            var towerCount = pair.getValue();
            var colors = tower.chars().mapToObj(e -> (char) e)
                    .map(c -> c.toString())
                    .collect(Collectors.toList());
            Set<String> colorsSet = new HashSet<>();
            var towerSwap102 = colors.get(1) + colors.get(0) + colors.get(2);
            var towerSwap021 = colors.get(0) + colors.get(2) + colors.get(1);
            colorsSet.add(tower);
            colorsSet.add(towerSwap102);
            colorsSet.add(towerSwap021);
            for (String color : colorsSet) {
                colorsCount.put(color, colorsCount.getOrDefault(color, 0) + towerCount);
            }
        }
        var maxCommonColors = colorsCount.entrySet().stream().max(Map.Entry.comparingByValue());
        var maxColor = maxCommonColors.get();
        //System.out.println("Max color is " + maxColor.getKey() + " with count" + maxColor.getValue());
        return maxColor.getValue();
    }

}
