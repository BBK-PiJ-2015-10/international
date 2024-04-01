package com.allpago.delivery.calculator;

import com.allpago.delivery.calculator.distance.DistanceCalculator;
import com.allpago.delivery.calculator.weight.WeightCalculator;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Component
public class DeliveryCostCalculatorImpl implements DeliveryCostCalculator {

    public DeliveryCostCalculatorImpl(WeightCalculator weightCalculator, DistanceCalculator distanceCalculator) {
        this.weightCalculator = weightCalculator;
        this.distanceCalculator = distanceCalculator;
    }

    private WeightCalculator weightCalculator;

    private DistanceCalculator distanceCalculator;

    @Override
    public String calculateCosts(String fromId, String toId, int width, int length, int depth, double weight) {
        var calculatedWeight = weightCalculator.calculateWeight(width, length, depth, weight);
        var minimumPathCost = distanceCalculator.getMinimumDistance(fromId, toId);
        if (minimumPathCost == -1.0) {
            return "~";
        } else {
            var result = Math.sqrt(minimumPathCost * calculatedWeight);
            DecimalFormat df = new DecimalFormat("#.00");
            df.setRoundingMode(RoundingMode.HALF_EVEN);
            return df.format(result);
        }
    }
}
