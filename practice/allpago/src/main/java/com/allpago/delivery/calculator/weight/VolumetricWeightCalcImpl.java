package com.allpago.delivery.calculator.weight;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class VolumetricWeightCalcImpl implements VolumetricWeightCalc {

    private Logger logger = LoggerFactory.getLogger(VolumetricWeightCalcImpl.class);

    @Override
    public double calculateWeight(int width, int length, int height, double adjFactor) {
        double rawWeight = width * length * height / adjFactor;
        double rawWeightRoundDown = Math.floor(rawWeight);
        double leftOver = rawWeight - rawWeightRoundDown;
        Double adj = 0.5;
        if (leftOver == 0) {
            adj = 0.0;
        } else if (leftOver > 0.5) {
            adj = 1.0;
        }
        var rounded = rawWeightRoundDown + adj;
        logger.info("Raw weight: {} roundedIs {}", rawWeight, rounded);
        return rounded;
    }


}
