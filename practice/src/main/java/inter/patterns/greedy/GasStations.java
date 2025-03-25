package inter.patterns.greedy;

import java.util.ArrayList;
import java.util.List;

public class GasStations {

    public int startingPoint(List<Integer> cost, List<Integer> gas) {
        var startingPoint = -1;
        List<Integer> gasMinusCosts = new ArrayList<>();
        for (int i = 0; i < cost.size(); i++) {
            var gasMinusCost = gas.get(i) - cost.get(i);
            gasMinusCosts.add(gasMinusCost);
        }
        var totalGasMinusCost = gasMinusCosts.stream().reduce((a, b) -> a + b).get();
        if (totalGasMinusCost < 0) {
            return startingPoint;
        } else {
            var tank = 0;
            var onGoingStarting = 0;
            for (int i = 0; i < gasMinusCosts.size(); i++) {
                var gasMinusCostPlusTank = gasMinusCosts.get(i)+tank;
                if (gasMinusCostPlusTank<0){
                   onGoingStarting = i+1;
                   tank = 0;
                } else {
                    tank = gasMinusCostPlusTank;
                }
            }
            return onGoingStarting;
        }

    }
}
