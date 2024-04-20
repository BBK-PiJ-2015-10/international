package com.allpago.delivery.calculator.weight;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class NormalizedWeightCalculator implements WeightCalculator {

    private Logger logger = LoggerFactory.getLogger(NormalizedWeightCalculator.class);

    private VolumetricWeightCalc volumetricWeightCalc;

    public NormalizedWeightCalculator(VolumetricWeightCalc volumetricWeightCalc) {
        this.volumetricWeightCalc = volumetricWeightCalc;
    }

    @Override
    public double calculateWeight(int width, int length, int height, double weight) {
        Double weightInKgs = weight / 1000 ;
        Double factor = (weightInKgs / .5);
        int fact = factor.intValue();


        int roundedWeight = (int) Math.round(weightInKgs);
        var calcWeight = Double.valueOf(roundedWeight);
        double volumeWeight = volumetricWeightCalc.calculateWeight(width, length, height, 5000.0);
        logger.info("MassWeight is : {} kds VolumetricWeight: {} kgs ",calcWeight, volumeWeight);
        return (volumeWeight > weightInKgs) ? volumeWeight : weightInKgs;
    }
}
