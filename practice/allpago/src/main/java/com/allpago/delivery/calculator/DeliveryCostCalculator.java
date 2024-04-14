package com.allpago.delivery.calculator;

import com.allpago.delivery.calculator.distance.DistanceCalculator;

public interface DeliveryCostCalculator {

    String calculateCosts(String fromId, String toId, int length, int width, int depth, double weight);

    DistanceCalculator getDistanceCalculator();

}
