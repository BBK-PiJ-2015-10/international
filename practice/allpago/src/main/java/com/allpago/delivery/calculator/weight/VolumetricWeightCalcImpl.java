package com.allpago.delivery.calculator.weight;

import org.springframework.stereotype.Component;

@Component
public class VolumetricWeightCalcImpl implements VolumetricWeightCalc {

    @Override
    public double calculateWeight(int width, int length, int height, double adjFactor) {
        var rawWeight = width * length * height / adjFactor;
        double root = Math.floor(rawWeight / .5) * .5;
        var balance = (rawWeight - root) == 0.00000 ? 0.0 : 0.5;
        return (root + balance);
    }


}
