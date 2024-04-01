package com.allpago.delivery.calculator.weight;

public interface VolumetricWeightCalc {

    double calculateWeight(int width, int length, int height, double adjFactor);

}
