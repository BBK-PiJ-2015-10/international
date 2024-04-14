package com.allpago.delivery.calculator;

import com.allpago.delivery.calculator.distance.DistanceCalculator;
import com.allpago.delivery.calculator.weight.WeightCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Component
public class DeliveryCostCalculatorImpl implements DeliveryCostCalculator {

    private Logger logger = LoggerFactory.getLogger(DeliveryCostCalculatorImpl.class);

    public DeliveryCostCalculatorImpl(WeightCalculator weightCalculator, DistanceCalculator distanceCalculator) {
        this.weightCalculator = weightCalculator;
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public DistanceCalculator getDistanceCalculator() {
        return distanceCalculator;
    }

    private WeightCalculator weightCalculator;

    private DistanceCalculator distanceCalculator;

    @Override
    public String calculateCosts(String fromId, String toId, int width, int length, int depth, double weight) {
        logger.info("Calculating costs from startNode: {} to endNode{} with width {} length {} depth {} weight {}",
                fromId, toId, width, length, depth, weight);
        var calculatedWeight = weightCalculator.calculateWeight(width, length, depth, weight);
        logger.info("Calculated weight: {}", calculatedWeight);
        var minimumPathCost = distanceCalculator.getMinimumDistance(fromId, toId);
        logger.info("Minimum path cost: {}", minimumPathCost);
        if (minimumPathCost == -1.0) {
            return "~";
        } else {
            var result = Math.sqrt(minimumPathCost * calculatedWeight);
            DecimalFormat df = new DecimalFormat("#.00");
            df.setRoundingMode(RoundingMode.HALF_EVEN);
            var response = df.format(result);
            logger.info("Calculated path cost: {}", response);
            return response;
        }
    }
}
