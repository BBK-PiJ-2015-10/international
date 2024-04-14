package com.allpago.delivery.calculator.weight;

import org.springframework.stereotype.Component;

@Component
public class NormalizedWeightCalculator implements WeightCalculator {

    private VolumetricWeightCalc volumetricWeightCalc;

    public NormalizedWeightCalculator(VolumetricWeightCalc volumetricWeightCalc) {
        this.volumetricWeightCalc = volumetricWeightCalc;
    }

    @Override
    public double calculateWeight(int width, int length, int height, double weight) {
        var weightInKgs = weight / 1000;
        double volumeWeight = volumetricWeightCalc.calculateWeight(width, length, height, 5000.0);
        return (volumeWeight > weightInKgs) ? volumeWeight : weightInKgs;
    }
}
